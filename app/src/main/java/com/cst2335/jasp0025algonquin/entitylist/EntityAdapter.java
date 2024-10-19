package com.cst2335.jasp0025algonquin.entitylist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EntityAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Entity> entities;

    public EntityAdapter(Context context, ArrayList<Entity> entities) {
        this.context = context;
        this.entities = entities;
    }

    @Override
    public int getCount() {
        return entities.size();
    }

    @Override
    public Object getItem(int position) {
        return entities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate the layout for each list item
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.entity_item, parent, false);
        }

        // Get the current Entity object
        Entity entity = entities.get(position);

        // Get references to the ImageView and TextView in the list item layout
        ImageView icon = convertView.findViewById(R.id.entity_icon);  // Make sure you have entityIcon in your XML layout
        TextView name = convertView.findViewById(R.id.entity_icon);   // Make sure you have entityName in your XML layout

        // Set the name of the entity
        name.setText(entity.getName());

        // Assuming the icons are stored as drawable resources with names matching the entity type (e.g., 1.png, 2.png)
        int iconResId = context.getResources().getIdentifier("drawable/" + entity.getType(), null, context.getPackageName());
        icon.setImageResource(iconResId);

        return convertView;
    }
}
