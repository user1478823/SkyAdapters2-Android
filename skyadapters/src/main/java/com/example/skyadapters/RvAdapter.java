package com.example.skyadapters;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {

    private Activity a;
    private String[] list;
    private TypedArray imgList;
    private int customLayoutID;
    private OnItemClickListener onItemClickListener;

    private int color = Color.WHITE;

    public RvAdapter(String[] rvList, TypedArray imgList, final Activity a, int customLayoutID,
                     RecyclerView.LayoutManager layoutManager, Integer drawerItemsColor,
                     OnItemClickListener onItemClickListener) {
        this.list = rvList;
        this.imgList = imgList;
        this.a = a;
        this.customLayoutID = customLayoutID;
        this.onItemClickListener = onItemClickListener;

        if (drawerItemsColor != null){
            color = drawerItemsColor;
        }

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
        return new ViewHolder(LayoutInflater.from(a).inflate(customLayoutID, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.itemView.setBackgroundColor(color);
        String item = list[position];
        holder.txt.setText(item);
        if (holder.img != null){
            holder.img.setImageResource(imgList.getResourceId(position, 0));
        }
        holder.bind(onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return list.length;
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
