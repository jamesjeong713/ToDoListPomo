package com.example.todopomo;

import android.widget.CheckBox;

public class ListViewItem {
    private Boolean checkBox;
    private String descStr;

    public void setCheckBox(Boolean cb) { checkBox = cb; }
    public void setDesc(String descStr) {
        this.descStr = descStr;
    }

    public Boolean getCheckBox() { return this.checkBox; }
    public String getDesc() { return this.descStr; }
}
