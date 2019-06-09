package com.example.todopomo;

import android.app.Dialog;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomListViewAdapter extends BaseAdapter implements View.OnClickListener { //ArrayAdapter

    private ArrayList<ListViewItem> listViewItems = new ArrayList<ListViewItem>();

    // define interface for button click event
    // to lead inherit this from MainActivity
    public interface ListBtnClickListener {
        void onListBtnClick(int position);
    }

    int resourceId;
    private ListBtnClickListener listBtnClickListener;

    CustomListViewAdapter() {}

    CustomListViewAdapter(Context context, int resource, ListBtnClickListener clickListener) {

        this.resourceId = resource ;
        this.listBtnClickListener = clickListener ;
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
//        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.check_box);

        // getting position from Data set
        ListViewItem listViewItem = listViewItems.get(position);
        // adjust data based on each items
        textView.setText(listViewItem.getDesc());
        textViewSets.setText(listViewItem.getSets());

        // When you click start button.. you can change the property
//        Button buttonStart = (Button) convertView.findViewById(R.id.start_button);
//        buttonStart.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) {
//
//                // Maybe progress bar in selected listView
//            }
//        });

        // button2의 TAG에 position값 지정. Adapter를 click listener로 지정.
        Button button2 = (Button) convertView.findViewById(R.id.start_button);
        button2.setTag(position);
        button2.setOnClickListener(this);

        // after timer is over, listViewItem has to have current data of sets

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

    // for testing
//    public void selectedItem(int position) {
//        ListViewItem item = new ListViewItem();
//        item.setSets("selected");
//        listViewItems.set(position, item);
//    }

    // button2가 눌려졌을 때 실행되는 onClick함수.
    public void onClick(View v) {
        // ListBtnClickListener(MainActivity)의 onListBtnClick() 함수 호출.
        if (this.listBtnClickListener != null) {
            this.listBtnClickListener.onListBtnClick((int)v.getTag()) ;

        }
    }
}
