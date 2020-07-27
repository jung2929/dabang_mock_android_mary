package com.softsquared.template.src.main.Map.MapEstate.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.softsquared.template.R;
import com.softsquared.template.src.main.Map.MapComplex.models.ComplexInfo;
import com.softsquared.template.src.main.Map.MapEstate.models.EstateInfo;

import java.util.ArrayList;
import java.util.List;

public class EstateAdapter extends ArrayAdapter implements AdapterView.OnItemClickListener {

    private Context context;
    private List list;


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
    }


    class ViewHolder {
        public TextView agencyName;
        public TextView agencyAddress;
        public TextView agencyComment;
        public ImageView agencyBossImg;

    }


    public EstateAdapter(Context context, ArrayList list) {
        super(context, 0, list);
        this.context = context;
        this.list = list;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.estate_item_layout, parent, false);
        }

        viewHolder = new ViewHolder();
        viewHolder.agencyName = (TextView) convertView.findViewById(R.id.agencyName);
        viewHolder.agencyAddress = (TextView) convertView.findViewById(R.id.agencyAddress);
        viewHolder.agencyComment = (TextView) convertView.findViewById(R.id.agencyComment);
        viewHolder.agencyBossImg = (ImageView) convertView.findViewById(R.id.agencyBossImg);



        final EstateInfo agencyInfo = (EstateInfo) list.get(position);
        viewHolder.agencyName.setText(agencyInfo.getAgencyName());
        viewHolder.agencyAddress.setText(agencyInfo.getAgencyAddress());
        viewHolder.agencyComment.setText(agencyInfo.getAgencyComment());

        Glide
                .with(context)
                .load(agencyInfo.getAgencyBossImg())
                .apply(new RequestOptions().circleCrop())
                .into(viewHolder.agencyBossImg);



        return convertView;
    }

}
