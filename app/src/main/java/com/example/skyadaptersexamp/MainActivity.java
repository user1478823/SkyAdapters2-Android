package com.example.skyadaptersexamp;

import android.content.Intent;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<String> list = new ArrayList();
        list.add("One");
        list.add("Two");
        list.add("Three");
        toggle = new ToolbarAdapter(this).setupToolbarForMainActivity(R.id.rv_drawer,
                list, R.id.toolbar, "Main", R.id.drawer_layout, R.string.drawer_open, R.string.drawer_closed,
                new RvAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Toast.makeText(MainActivity.this, list.get(position), Toast.LENGTH_SHORT).show();
                    }
                });
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Activity2.class));
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return false;
    }
}
