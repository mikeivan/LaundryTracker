package com.mikeivan.apps.laundrytracker;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mivan on 4/22/2017.
 */

public class MachineAdapter extends ArrayAdapter<Machine> {

    // Constructor, which calls super, passing in 0 for default resource file,
    // which is defined later in getView
    public MachineAdapter(Activity context, ArrayList<Machine> items) {
        super(context, 0, items);
    }

    // Override getView to display according to machine_list_item.xml
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.machine_list_item, parent, false);
        }

        // Get the Machine object located at this position in the list
        Machine currentMachine = getItem(position);


        TextView typeTextView = (TextView) listItemView.findViewById(R.id.machine_type);
        typeTextView.setText(currentMachine.getType());

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.machine_name);
        nameTextView.setText(currentMachine.getName());

        TextView timeTextView = (TextView) listItemView.findViewById(R.id.machine_time);
        timeTextView.setText("" + currentMachine.getTime());

        return listItemView;
    }
}
