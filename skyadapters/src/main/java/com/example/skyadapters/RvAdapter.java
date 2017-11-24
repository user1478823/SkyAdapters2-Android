package com.example.skyadapters;

import android.app.Activity;
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
    private List<Integer> imgList;
    private int customLayoutID;
    private Integer txtID;
    private Integer imgID;
    private OnItemClickListener onItemClickListener;

    public RvAdapter(String[] rvList, List<Integer> imgList, final Activity a, ToolbarIDs toolbarIDs, OnItemClickListener onItemClickListener) {
        this.list = rvList;
        this.imgList = imgList;
        this.a = a;
        this.customLayoutID = toolbarIDs.getCustomLayoutId();
        this.txtID = toolbarIDs.getItemTitleId();
        this.imgID = toolbarIDs.getItemImageId();
        this.onItemClickListener = onItemClickListener;

        RecyclerView rv = (RecyclerView) a.findViewById(toolbarIDs.getRvId());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(a);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(this);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt;
        ImageView img;

        ViewHolder(View itemView) {
            super(itemView);
            txt = (TextView) itemView.findViewById(txtID);
            if (imgID != null){
                img = (ImageView) itemView.findViewById(imgID);
            }
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
        String item = list[position];
        holder.txt.setText(item);
        if (holder.img != null){
            holder.img.setImageResource(imgList.get(position));
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
