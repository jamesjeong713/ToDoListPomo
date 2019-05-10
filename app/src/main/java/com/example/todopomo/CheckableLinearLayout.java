package com.example.todopomo;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CheckableLinearLayout extends LinearLayout implements Checkable {

    public CheckableLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    public void setChecked(boolean checked) {
        CheckBox cb = (CheckBox) findViewById(R.id.check_box);

        if (cb.isChecked() != checked) {
            cb.setChecked(checked);
        }

        if (cb.isChecked())
            strikout(true);
        else
            strikout(false);
    }

    @Override
    public boolean isChecked() {
        CheckBox cb = (CheckBox) findViewById(R.id.check_box);
        return cb.isChecked();
    }

    @Override
    public void toggle() {
        CheckBox cb = (CheckBox) findViewById(R.id.check_box);
        setChecked(cb.isChecked() ? false : true);
    }

    public void strikout(boolean check) {
        TextView tv = (TextView) findViewById(R.id.text_view);
        if (check)
            tv.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        else
            tv.setPaintFlags(0);

    }

}
