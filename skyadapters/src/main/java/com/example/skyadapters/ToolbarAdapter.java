package com.example.skyadapters;

import android.content.res.TypedArray;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

/**
 * Created by ttlnisoffice on 11/17/17.
 */
public class ToolbarAdapter {

    private AppCompatActivity a;

    public ToolbarAdapter(AppCompatActivity a) {
        this.a = a;
    }

    public void buildToolbar(int id) {
        Toolbar toolbar = (Toolbar) a.findViewById(id);
        a.setSupportActionBar(toolbar);
        a.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a.finish();
            }
        });
    }

    public ActionBarDrawerToggle buildToolbarForMainActivity(String[] rvList,
                                                             TypedArray imgList,
                                                             ToolbarIDs toolbarIDs,
                                                             RvAdapter.OnItemClickListener onItemClickListener){

        new RvAdapter(rvList, imgList, a, toolbarIDs, onItemClickListener);

        DrawerLayout drawerLayout = (DrawerLayout) a.findViewById(R.id.sky_drawer_layout);
        ActionBarDrawerToggle toggleBtn = new ActionBarDrawerToggle(a, drawerLayout,
                R.string.drawer_open, R.string.drawer_closed);
        drawerLayout.addDrawerListener(toggleBtn);

        Toolbar toolbar = (Toolbar) a.findViewById(R.id.sky_toolbar);
        a.setSupportActionBar(toolbar);
        a.getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        toggleBtn.syncState();

        return toggleBtn;
    }

    public void setToolbarTitle(String title){
        a.getSupportActionBar().setTitle(title);
    }
}

