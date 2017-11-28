package com.example.skyadapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {

    private Activity a;
    private int customLayoutID;
    private OnItemClickListener onItemClickListener;

    private Menu menu;


    public RvAdapter(Menu menu, final Activity a, int customLayoutID,
                     RecyclerView.LayoutManager layoutManager,
                     OnItemClickListener onItemClickListener) {
        this.menu = menu;
        this.a = a;
        this.customLayoutID = customLayoutID;
        this.onItemClickListener = onItemClickListener;

        RecyclerView rv = (RecyclerView) a.findViewById(R.id.sky_rv_drawer);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(this);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt;
        ImageView img;

        ViewHolder(View itemView) {
            super(itemView);
            txt = (TextView) itemView.findViewById(R.id.sky_txt_drawer);
            img = (ImageView) itemView.findViewById(R.id.sky_img_drawer);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(a).inflate(customLayoutID, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final MenuItem menuItem = menu.getItem(position);
        holder.txt.setText(menuItem.getTitle());
        if (holder.img != null) holder.img.setImageDrawable(menuItem.getIcon());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(menuItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return menu.size();
    }


    public interface OnItemClickListener {
        void onItemClick(MenuItem position);
    }
}
