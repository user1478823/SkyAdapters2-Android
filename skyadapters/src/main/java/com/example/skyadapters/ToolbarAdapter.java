package com.example.skyadapters;

import android.content.res.TypedArray;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

/**
 * Created by ttlnisoffice on 11/17/17.
 */
public class ToolbarAdapter {

    private AppCompatActivity a;
    RvAdapter rvAdapter;
    private Toolbar toolbar;

    public ToolbarAdapter(AppCompatActivity a) {
        this.a = a;
    }

    public Toolbar buildToolbar(int id) {
        toolbar = (Toolbar) a.findViewById(id);
        a.setSupportActionBar(toolbar);
        a.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a.finish();
            }
        });
        return toolbar;
    }

    public ActionBarDrawerToggle buildToolbarForMainActivity(String[] rvList,
                                                             TypedArray imgList,
                                                             int customLayoutID,
                                                             RecyclerView.LayoutManager layoutManager,
                                                             RvAdapter.OnItemClickListener onItemClickListener){

        rvAdapter = new RvAdapter(rvList, imgList, a, customLayoutID, layoutManager,
                                  onItemClickListener);

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

    public Toolbar setToolbarTitle(String title){
        toolbar.setTitle(title);
        return toolbar;
    }

    public Toolbar setToolbarColor(int color) {
        toolbar.setBackgroundColor(color);
        return toolbar;
    }
}

