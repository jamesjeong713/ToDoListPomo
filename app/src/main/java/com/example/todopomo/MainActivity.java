package com.example.todopomo;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    static final String[] LIST_ITEM = {"LIST1", "LIST2", "LIST3"};
    final ArrayList<String> items = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items);

        ListView listview = (ListView) findViewById(R.id.list_view_main);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get TextView's text
                String strText = (String) parent.getItemAtPosition(position);

                // TODO : use strText
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count;
                count = adapter.getCount();

                items.add("LIST" + Integer.toString(count + 1));

                adapter.notifyDataSetChanged();
                Snackbar.make(view, "Add item", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
