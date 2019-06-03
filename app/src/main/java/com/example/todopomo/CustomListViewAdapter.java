package com.example.todopomo;

import android.app.Dialog;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomListViewAdapter extends BaseAdapter {

    private ArrayList<ListViewItem> listViewItems = new ArrayList<ListViewItem>();

    public CustomListViewAdapter() {

    }

    @Override
    public int getCount() {
        return listViewItems.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.content_main, parent, false);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.text_view);
        TextView textViewSets = (TextView) convertView.findViewById(R.id.text_view_sets);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.check_box);
        Button buttonStart = (Button) convertView.findViewById(R.id.start_button);
//        Button editButton = (Button) convertView.findViewById(R.id.start_button);

        // getting position from Data set
        ListViewItem listViewItem = listViewItems.get(position);
        // adjust data based on each items
        textView.setText(listViewItem.getDesc());
        textViewSets.setText(listViewItem.getSets());

        // Timer
        final Timer timer = new Timer();
        buttonStart.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.pomodoroTimer();
            }
        });

        // after timer is over, listViewItem has to have current data of sets
//        startButton.

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return listViewItems.get(position);
    }

    public void addItem(String sets, String desc) {
        ListViewItem item = new ListViewItem();
        item.setDesc(desc);
        item.setSets(sets);

        listViewItems.add(item);
    }

    public void editItem(String sets, String desc, int position) {

        ListViewItem item = new ListViewItem();

        item.setDesc(desc);
        item.setSets(sets);

        listViewItems.set(position, item);
    }

}
