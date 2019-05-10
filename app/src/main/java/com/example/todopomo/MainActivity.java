package com.example.todopomo;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    private CustomListViewAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.list_view_main);
        customAdapter = new CustomListViewAdapter();

        listview.setAdapter(customAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                // get TextView's text
//                String strText = (String) parent.getItemAtPosition(position);
                // TODO : use strText
//                customAdapter.selectItem(position);
            }
        });

        customAdapter.addItem(true,"empty");

        // check item
        // https://dev-daddy.tistory.com/20 취소선
        int checked;
        checked = listview.getCheckedItemPosition();
        if (checked > -1) {
//            customAdapter.selectItem(checked);
        }


        // modify item


        // fab button to add list
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = customAdapter.getCount();

                customAdapter.addItem(false,"New Text test" + (count + 1));
                // IMPORTANT: refresh state.
                customAdapter.notifyDataSetChanged();

                Snackbar.make(view, "Add item", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
