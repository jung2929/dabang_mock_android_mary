package com.softsquared.template.src.main.heart.heart_dangi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.softsquared.template.R;
import com.softsquared.template.src.main.map.map_dangi.Dangi_info;

import java.util.ArrayList;
import java.util.List;

//import com.softsquared.template.src.main.map.map_dangi.Dangi_info;

public class HeartDangiAdapter extends ArrayAdapter implements AdapterView.OnItemClickListener {

    private Context context;
    private List list;


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();

    }


    class ViewHolder {
        public TextView complexName1;
        public TextView kindOfBuilding1;
        public TextView householdNum1;
        public TextView completionDate1;;
        public TextView complexAdress1;
        //public TextView Img_url;
    }


    public HeartDangiAdapter(Context context, ArrayList list) {
        super(context, 0, list);
        this.context = context;
        this.list = list;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.item_layout, parent, false);
        }

        viewHolder = new ViewHolder();
        viewHolder.complexName1 = (TextView) convertView.findViewById(R.id.complexName);
        viewHolder.kindOfBuilding1 = (TextView) convertView.findViewById(R.id.kindOfBuilding);
        viewHolder.householdNum1 = (TextView) convertView.findViewById(R.id.householdNum);
        viewHolder.completionDate1 = (TextView) convertView.findViewById(R.id.completionDate);
        viewHolder.complexAdress1 = (TextView) convertView.findViewById(R.id.complexAdress);
        //viewHolder.Img_url = (TextView) convertView.findViewById(R.id.Img_url);

        //final Dangi_info dangi_info = (Dangi_info) list.get(position);
        viewHolder.complexName1.setText(Dangi_info.getComplexName());
        viewHolder.kindOfBuilding1.setText(Dangi_info.getKindOfBuilding());
        viewHolder.householdNum1.setText(Dangi_info.getHouseholdNum());
        viewHolder.completionDate1.setText(Dangi_info.getCompletionDate());
        viewHolder.complexAdress1.setText(Dangi_info.getComplexAdress());

        viewHolder.complexName1.setTag(Dangi_info.getComplexName());

        return convertView;
    }

}
