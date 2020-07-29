package com.softsquared.template.src.main.Home.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.softsquared.template.R;
import com.softsquared.template.src.main.Home.models.InterestInfo;
import com.softsquared.template.src.main.Map.MapComplex.Adapter.ComplexAdapter;
import com.softsquared.template.src.main.Map.MapComplex.models.ComplexInfo;

import java.util.ArrayList;

public class InterestRecyclerviewAdapter extends RecyclerView.Adapter<InterestRecyclerviewAdapter.ViewHolder> {
    private ArrayList<InterestInfo> itemList;
    private Context context;
    private View.OnClickListener onClickItem;

    public InterestRecyclerviewAdapter(Context context, ArrayList<InterestInfo> itemList, View.OnClickListener onClickItem) {
        this.context = context;
        this.itemList = itemList;
        this.onClickItem = onClickItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.home_interest_item_layout, parent, false);




        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//
//        holder = new InterestRecyclerviewAdapter(context,itemList,onClickItem).ViewHolder();
//        holder.regionName = (TextView) convertView.findViewById(R.id.home_interestDong);
//        holder.completionDate = (TextView) convertView.findViewById(R.id.completionDate);
//        holder.complexAddress = (TextView) convertView.findViewById(R.id.complexAddress);
//        holder.complexImg = (ImageView) convertView.findViewById(R.id.complexImg);
//
//
        final InterestInfo interestInfo = (InterestInfo) itemList.get(position);
        holder.home_interestDong.setText(interestInfo.getRegionName());
        holder.home_interestRoomNum.setText(interestInfo.getRoomNum());
        holder.home_interestRoomType.setText(interestInfo.getRoomType());

        //System.out.println(complexInfo.getComplexName());
        Glide
                .with(context)
                .load(interestInfo.getRegionImg())
                .apply(new RequestOptions().override(400,800))
                //.apply(new RequestOptions().circleCrop().override(100,200))
                .into(holder.home_interestImg);

       //String item = itemList.get(position);
//
//        holder.textview.setText(item);
//        holder.textview.setTag(item);
//        holder.textview.setOnClickListener(onClickItem);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView home_interestImg;
        public TextView home_interestRoomNum;
        public TextView home_interestDong;
        public TextView home_interestRoomType;


        public ViewHolder(View itemView) {
            super(itemView);

            home_interestImg = itemView.findViewById(R.id.home_interestImg);
            home_interestRoomNum = itemView.findViewById(R.id.home_interestRoomNum);
            home_interestDong = itemView.findViewById(R.id.home_interestDong);
            home_interestRoomType = itemView.findViewById(R.id.home_interestRoomType);
        }
    }
}
