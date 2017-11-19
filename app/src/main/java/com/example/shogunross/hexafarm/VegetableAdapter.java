package com.example.shogunross.hexafarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ShogunRoss on 11/17/2017.
 */

public class VegetableAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<VegetableType> vegetableList;

    public VegetableAdapter(Context context, int layout, List<VegetableType> vegetableTypes) {
        this.context = context;
        this.layout = layout;
        this.vegetableList = vegetableTypes;
    }

    @Override
    public int getCount() {
        return vegetableList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);

        // map to view
        TextView txtName = convertView.findViewById(R.id.txtName);
        TextView txtDescription = convertView.findViewById(R.id.txtDescription);
        ImageView imgVegetable = convertView.findViewById(R.id.imgVegetable);

        // assign value
        VegetableType vegetableType = vegetableList.get(position);
        txtName.setText(vegetableType.getName());
        txtDescription.setText(vegetableType.getDescription());
        imgVegetable.setImageResource(vegetableType.getImage());

        return convertView;
    }
}
