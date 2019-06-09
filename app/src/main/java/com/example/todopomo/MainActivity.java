package com.example.todopomo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements CustomListViewAdapter.ListBtnClickListener {

    private ListView listview;
    private CustomListViewAdapter customAdapter;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.list_view_main);
//        customAdapter = new CustomListViewAdapter();
//        listview.setAdapter(customAdapter);

        customAdapter = new CustomListViewAdapter(this, R.layout.content_main, this) ;
        listview.setAdapter(customAdapter);
        // When user select an item on list...
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
//                pomodoroTimer();
                // TODO : ...
//                customAdapter.selectedItem(position);
//                customAdapter.notifyDataSetChanged();
            }

        });

        // instead of edit button, I am going to edit task by using longClick
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position);

                String strDesc = item.getDesc();
                String strSets = item.getSets();

                editTaskDialog(strDesc, strSets, position);

                return false;
            }
        });

        // For test
        customAdapter.addItem("1", "empty");
        // fab button to add list
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = customAdapter.getCount();
                taskDialog();

                Snackbar.make(view, "Add item", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    // add timer with dialog
    public void pomodoroTimer() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.timer);

        final Chronometer chronometer = (Chronometer) dialog.findViewById(R.id.chronometer);
        Button buttonStart = (Button) dialog.findViewById(R.id.timer_button_start);
        Button buttonStop = (Button) dialog.findViewById(R.id.timer_button_stop);
        Button buttonReset = (Button) dialog.findViewById(R.id.timer_button_reset);

        buttonStart.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                chronometer.start();
            }
        });

        buttonStop.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                chronometer.stop();
            }
        });

        buttonReset.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
            }
        });
        dialog.show();
    }

    // add task with dialog
    public void taskDialog() {
        // Add button to load dialog
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.add_task);

        Button saveButton = (Button) dialog.findViewById(R.id.add_task_yes);
        Button noButton = (Button) dialog.findViewById(R.id.add_task_no);

    //        final NumberPicker taskEditSets = (NumberPicker) findViewById(R.id.add_task_sets);
        final EditText taskEditSets = (EditText) dialog.findViewById(R.id.add_task_sets);
        final EditText taskEditName = (EditText) dialog.findViewById(R.id.add_task_edit);

        saveButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (taskEditName.getText().toString() != null && taskEditName.getText().toString() != null ) {
                    String taskSets = taskEditSets.getText().toString();
                    String taskDec = taskEditName.getText().toString();

                    customAdapter.addItem(taskSets, taskDec);
                    customAdapter.notifyDataSetChanged();
                }
                dialog.dismiss();
            }
        });

        noButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    // edit task with dialog
    public void editTaskDialog(String desc, String sets, final int position) {
        // Add button to load dialog
        ListViewItem item = new ListViewItem();
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.add_task);

        Button saveButton = (Button) dialog.findViewById(R.id.add_task_yes);
        Button noButton = (Button) dialog.findViewById(R.id.add_task_no);

        final EditText taskEditSets = (EditText) dialog.findViewById(R.id.add_task_sets);
        taskEditSets.setText(sets);
        final EditText taskEditName = (EditText) dialog.findViewById(R.id.add_task_edit);
        taskEditName.setText(desc);

        saveButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (taskEditName.getText().toString() != null && taskEditName.getText().toString() != null ) {
                    String taskSets = taskEditSets.getText().toString();
                    String taskDec = taskEditName.getText().toString();

                    customAdapter.editItem(taskSets, taskDec, position);
                    customAdapter.notifyDataSetChanged();
                }
                dialog.dismiss();
            }
        });

        noButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    @Override
    public void onListBtnClick(int position) {
        pomodoroTimer();
        Toast.makeText(this, Integer.toString(position+1) + " Item is selected..", Toast.LENGTH_SHORT).show() ;
    }
}
