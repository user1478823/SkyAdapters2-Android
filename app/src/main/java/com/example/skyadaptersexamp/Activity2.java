package com.example.skyadaptersexamp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        new ToolbarAdapter(this).setupToolbar(R.id.toolbar_activity2, "Activity2");
    }
}
