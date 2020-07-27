package com.softsquared.template.src.main.Map;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;

import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.tabs.TabLayout;

import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import com.google.maps.android.data.geojson.GeoJsonLayer;
import com.google.maps.android.data.geojson.GeoJsonPolygonStyle;

import com.google.maps.android.ui.IconGenerator;
import com.softsquared.template.R;
import com.softsquared.template.src.Search.SearchActivity;
import com.softsquared.template.src.main.Map.Adapter.ViewPagerAdapter2;
import com.softsquared.template.src.main.Map.interfaces.MapFragView;
import com.softsquared.template.src.main.Map.models.FragMapResponse;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MapFragment extends Fragment implements OnMapReadyCallback , View.OnClickListener, MapFragView,ClusterManager.OnClusterClickListener<MyItem>, ClusterManager.OnClusterInfoWindowClickListener<MyItem>, ClusterManager.OnClusterItemClickListener<MyItem>, ClusterManager.OnClusterItemInfoWindowClickListener<MyItem>, GoogleMap.OnMarkerClickListener{
    private View view;
    private MapView mapView;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private GoogleMap googleMap;
    Handler handler2;
    private ClusterManager<MyItem> mClusterManager;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_map, container, false);

        handler2 = new Handler();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                getMapInfo();
            }
        });
        t.start();

        ViewPager viewPager = view.findViewById(R.id.viewPager2);
        fragmentPagerAdapter = new ViewPagerAdapter2(getChildFragmentManager());

        TabLayout tabLayout = view.findViewById(R.id.tab_layout2);
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

       LinearLayout btn_map_search = view.findViewById(R.id.btn_map_search);
        btn_map_search.setOnClickListener(this);

        mapView=view.findViewById(R.id.googleMap);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);


        return view;
    }

    private void getMapInfo() {
        final MapFragService fragService = new MapFragService(this);
        fragService.getMap("원룸|오피스텔|아파트|투쓰리룸","0","999999999","0","99999999","37.5055200000","127.0783540000","10000000"); //MainActivity에서 통신하는 방법: MainService객체를 생성하고 함수호출
        //고칠필요 x
    }



    @Override
    public void onMapReady(@NonNull final GoogleMap googleMap) {
        this.googleMap = googleMap;
        //mClusterManager = new ClusterManager<>(getActivity(),googleMap);

        LatLng dong = new LatLng(37.5015118,127.060803); //대치동 위도경도
        MarkerOptions dongMarker = new MarkerOptions();
        dongMarker.position(dong); //마커위치
        dongMarker.icon((getIcon())); //마커 커스텀
        googleMap.addMarker(dongMarker); //마커 표시
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dong,14)); //숫자만큼 zoom한것
        googleMap.setOnMarkerClickListener(this::onMarkerClick);
//            @Override
//            public boolean onMarkerClick(Marker marker) {
//                marker.showInfoWindow();
//                markBoundry();
//                bounceMarker(marker);
//                return true;
//            }
//        });


//        mClusterManager.setRenderer(new MarkerRenderer(getContext(),googleMap,mClusterManager));
//        mClusterManager.setOnClusterItemClickListener(this);

       // googleMap.setOnCameraIdleListener(mClusterManager);
        //googleMap.setOnMarkerClickListener(mClusterManager);
        //mClusterManager.setRenderer(new PersonRenderer()); //클러스터링 되는 마커 커스텀
        //mClusterManager.setOnClusterItemClickListener(this::onClusterItemClick);

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        marker.showInfoWindow();
        markBoundry();
        bounceMarker(marker);
        return true;
    }

    private class PersonRenderer extends DefaultClusterRenderer<MyItem> {
        private final IconGenerator mIconGenerator = new IconGenerator(getContext());
        private final IconGenerator mClusterIconGenerator = new IconGenerator(getContext());


        public PersonRenderer() {
            super(getContext(), googleMap, mClusterManager);

            View multiProfile = getLayoutInflater().inflate(R.layout.cluster, null); //이미지layout
            mClusterIconGenerator.setContentView(multiProfile); //o

        }

        @Override
        protected void onBeforeClusterItemRendered(@NonNull MyItem myItem, MarkerOptions markerOptions) { //클러스터링 하기전 아이템 렌더링
            // Draw a single person - show their profile photo and set the info window to show their name
            markerOptions
                    .icon(getItemIcon(myItem));

        }

        @Override
        protected void onClusterItemUpdated(@NonNull MyItem myItem, Marker marker) {
            // Same implementation as onBeforeClusterItemRendered() (to update cached markers)
            marker.setIcon(getItemIcon(myItem));

        }

        private BitmapDescriptor getItemIcon(MyItem myItem) {
            Bitmap icon = mIconGenerator.makeIcon();
            return BitmapDescriptorFactory.fromBitmap(icon);
        }

        @Override
        protected void onBeforeClusterRendered(@NonNull Cluster<MyItem> cluster, MarkerOptions markerOptions) {
            // Draw multiple people.
            // Note: this method runs on the UI thread. Don't spend too much time in here (like in this example).
           // markerOptions.icon(getClusterIcon(cluster));
            //super.onBeforeClusterRendered(cluster, markerOptions);

            IconGenerator iconFactory = new IconGenerator(getContext());
            iconFactory.setStyle(IconGenerator.STYLE_GREEN);
            Bitmap icon = iconFactory.makeIcon("abc /bcd");

            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(icon));
        }

        @Override
        protected void onClusterUpdated(@NonNull Cluster<MyItem> cluster, Marker marker) {
            // Same implementation as onBeforeClusterRendered() (to update cached markers)
            marker.setIcon(getClusterIcon(cluster));
        }


        private BitmapDescriptor getClusterIcon(Cluster<MyItem> cluster) {

            Bitmap icon = mClusterIconGenerator.makeIcon(String.valueOf(cluster.getSize()));
            return BitmapDescriptorFactory.fromBitmap(icon);
        }

        @Override
        protected boolean shouldRenderAsCluster(Cluster cluster) {
            // Always render clusters.
            return cluster.getSize() > 1;
        }
    }



    private void addRoomItem(float Lat,float Lng){

            MyItem offsetItem = new MyItem(Lat, Lng);
            mClusterManager.addItem(offsetItem);

    }


    private void bounceMarker(final Marker marker){
        final Handler handler = new Handler();

        final long startTime = SystemClock.uptimeMillis();
        final long duration = 1500;

        Projection proj = googleMap.getProjection();
        final LatLng markerLatLng = marker.getPosition();
        Point startPoint = proj.toScreenLocation(markerLatLng);
        startPoint.offset(0, -100);
        final LatLng startLatLng = proj.fromScreenLocation(startPoint);

        final Interpolator interpolator = new BounceInterpolator();

        handler.post(new Runnable() {
            @Override
            public void run() {
                long elapsed = SystemClock.uptimeMillis() - startTime;
                float t = interpolator.getInterpolation((float) elapsed / duration);
                double lng = t * markerLatLng.longitude + (1 - t) * startLatLng.longitude;
                double lat = t * markerLatLng.latitude + (1 - t) * startLatLng.latitude;
                marker.setPosition(new LatLng(lat, lng));

                if (t < 1.0) {
                    // Post again 16ms later.
                    handler.postDelayed(this, 16);
                }
            }
        });

    }

    private void markBoundry(){
        try {
            GeoJsonLayer layer = new GeoJsonLayer(googleMap,R.raw.dong9,getActivity()); // create geojson layer
            GeoJsonPolygonStyle polyStyle = layer.getDefaultPolygonStyle(); //create polygon style
            polyStyle.setStrokeColor(Color.BLUE); //set polygon color
            polyStyle.setFillColor(Color.argb(125,190, 212, 253)); //set polygon color
            polyStyle.setStrokeWidth(5); // set outline width
            layer.addLayerToMap(); //add layer into map

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    public BitmapDescriptor getIcon(){ //대치동 마커 추후 만들어서 넣기
        Drawable circleDrawable = getResources().getDrawable(R.drawable.circle);
        return getMarkerIconFromDrawable(circleDrawable);

    }

    private BitmapDescriptor getMarkerIconFromDrawable(Drawable drawable) {
        Canvas canvas = new Canvas();
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_map_search:
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
        }

    }

    @Override
    public void validateSuccess(FragMapResponse.result result) {

        //int roomNum = Integer.parseInt(result.getRoomNum());

        for(FragMapResponse.RoomList roomList : result.getRoomList()) {
            float Lat = Float.parseFloat(roomList.getLatitude());
            float Lng = Float.parseFloat(roomList.getLongitude());

            //addRoomItem(Lat,Lng);
            //System.out.println(roomNum);

            }
    }

    @Override
    public void validateFailure(String message) {
        System.out.println("실패");
    }

    @Override
    public boolean onClusterClick(Cluster<MyItem> cluster) { //뭉쳐진 것 클릭했을 때

        // Show a toast with some info when the cluster is clicked.
        //String firstName = cluster.getItems().iterator().next().name;
        String firstName = "hi";
        Toast.makeText(getActivity(), cluster.getSize() + " (including " + firstName + ")", Toast.LENGTH_SHORT).show();

        // Zoom in the cluster. Need to create LatLngBounds and including all the cluster items
        // inside of bounds, then animate to center of the bounds.

        // Create the builder to collect all essential cluster items for the bounds.
        LatLngBounds.Builder builder = LatLngBounds.builder();
        for (ClusterItem item : cluster.getItems()) {
            builder.include(item.getPosition());
        }
        // Get the LatLngBounds
        final LatLngBounds bounds = builder.build();

        // Animate camera to the bounds
        try {
            googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 100));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public void onClusterInfoWindowClick(Cluster<MyItem> cluster) {

    }

    @Override
    public boolean onClusterItemClick(MyItem item) { //클러스터링 아이템 클릭했을 때
        return false;
    }

    @Override
    public void onClusterItemInfoWindowClick(MyItem item) {

    }
}

