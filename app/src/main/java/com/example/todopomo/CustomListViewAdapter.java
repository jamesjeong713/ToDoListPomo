package com.example.todopomo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
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
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.check_box);
        // getting position from Data set
        ListViewItem listViewItem = listViewItems.get(position);
        // adjust data based on each items
        textView.setText(listViewItem.getDesc());
        checkBox.setChecked(listViewItem.getCheckBox());

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

    public void addItem(boolean check, String text) {
        ListViewItem item = new ListViewItem();
        item.setDesc(text);
        item.setCheckBox(check);

        listViewItems.add(item);
    }

//    public void selectItem(boolean check) {
//        ListViewItem item = new ListViewItem();
//        item.setCheckBox(check);
//
//        listViewItems.set()
//    }

}
