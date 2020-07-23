package com.softsquared.template.src.main.MapFragment.MapComplex.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.softsquared.template.R;
import com.softsquared.template.src.main.MapFragment.MapComplex.ComplexInfo;



import java.util.ArrayList;
import java.util.List;

public class ComplexAdapter extends ArrayAdapter implements AdapterView.OnItemClickListener {

    private Context context;
    private List list;


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();

    }


    class ViewHolder {
        public TextView complexName;
        public TextView kindOfBuilding;
        public TextView householdNum;
        public TextView completionDate;;
        public TextView complexAdress;
        public ImageView complexImg;
    }


    public ComplexAdapter(Context context, ArrayList list) {
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
        viewHolder.complexName = (TextView) convertView.findViewById(R.id.complexName);
        viewHolder.kindOfBuilding = (TextView) convertView.findViewById(R.id.kindOfBuilding);
        viewHolder.householdNum = (TextView) convertView.findViewById(R.id.householdNum);
        viewHolder.completionDate = (TextView) convertView.findViewById(R.id.completionDate);
        viewHolder.complexAdress = (TextView) convertView.findViewById(R.id.complexAdress);
        viewHolder.complexImg = (ImageView) convertView.findViewById(R.id.complexImg);


        final ComplexInfo complexInfo = (ComplexInfo) list.get(position);
        viewHolder.complexName.setText(complexInfo.getComplexName());
        viewHolder.kindOfBuilding.setText(complexInfo.getKindOfBuilding());
        viewHolder.householdNum.setText(complexInfo.getHouseholdNum());
        viewHolder.completionDate.setText(complexInfo.getCompletionDate());
        viewHolder.complexAdress.setText(complexInfo.getComplexAdress());
        viewHolder.complexName.setTag(complexInfo.getComplexName());
        //viewHolder.complexImg.setImageResource(complexInfo.getComplexImg());



//        convertView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, " " + dangi_info.getComplexName(), Toast.LENGTH_SHORT).show();
//            }
//        });

        return convertView;
    }

}