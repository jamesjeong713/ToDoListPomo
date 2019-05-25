package com.example.todopomo;

import android.widget.Button;
import android.widget.CheckBox;

public class ListViewItem {
    private Boolean checkBox;
    private String descStr;
    private String sets;

    public void setCheckBox(Boolean cb) { checkBox = cb; }
    public void setDesc(String descStr) {
        this.descStr = descStr;
    }
    public void setSets(String sets) {
        this.sets = sets;
    }

    public Boolean getCheckBox() { return this.checkBox; }
    public String getDesc() { return this.descStr; }
    public String getSets() { return this.sets;
    }
//    public Button getEditButton() { return this.}
}
