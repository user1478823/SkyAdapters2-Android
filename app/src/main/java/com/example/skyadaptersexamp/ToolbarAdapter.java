package com.example.skyadaptersexamp;

import android.app.Activity;
import android.support.annotation.StringRes;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ttlnisoffice on 11/17/17.
 */
public class ToolbarAdapter {

    private AppCompatActivity a;

    public ToolbarAdapter(AppCompatActivity a) {
        this.a = a;
    }

    public void setupToolbar(int id, String title) {
        Toolbar toolbar = (Toolbar) a.findViewById(id);
        a.setSupportActionBar(toolbar);
        a.getSupportActionBar().setTitle(title);
        a.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a.finish();
            }
        });
    }

    public ActionBarDrawerToggle setupToolbarForMainActivity(int rvID,
                                                             List<String> rvList,
                                                             int toolbarID,
                                                             String title,
                                                             int drawerLayoutID,
                                                             @StringRes int open,
                                                             @StringRes int closed,
                                                             RvAdapter.OnItemClickListener onItemClickListener){

        new RvAdapter(rvID, rvList, a, onItemClickListener);

        DrawerLayout drawerLayout = (DrawerLayout) a.findViewById(drawerLayoutID);
        ActionBarDrawerToggle toggleBtn = new ActionBarDrawerToggle(a, drawerLayout,
                open, closed);
        drawerLayout.addDrawerListener(toggleBtn);

        Toolbar toolbar = (Toolbar) a.findViewById(toolbarID);
        a.setSupportActionBar(toolbar);
        a.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        a.getSupportActionBar().setTitle(title);

        toggleBtn.syncState();

        return toggleBtn;
    }
}

class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {

    private Activity a;
    private List<String> list;
    private OnItemClickListener onItemClickListener;

    public RvAdapter(int rvID, List<String> list, final Activity a, OnItemClickListener onItemClickListener) {
        this.list = list;
        this.a = a;
        this.onItemClickListener = onItemClickListener;

        RecyclerView rv = (RecyclerView) a.findViewById(rvID);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(a);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(this);
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt;

        ViewHolder(View itemView) {
            super(itemView);
            txt = (TextView) itemView.findViewById(R.id.txt_custom_row);
        }

        public void bind(final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getLayoutPosition());
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(a).inflate(R.layout.custom_row, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        String item = list.get(position);
        holder.txt.setText(item);

        holder.bind(onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}