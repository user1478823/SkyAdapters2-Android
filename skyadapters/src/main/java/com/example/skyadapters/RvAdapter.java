package com.example.skyadapters;

import android.app.Activity;
import android.content.res.TypedArray;
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
    private Integer txtID;
    private Integer imgID;
    private OnItemClickListener onItemClickListener;

    public RvAdapter(String[] rvList, TypedArray imgList, final Activity a, ToolbarIDs toolbarIDs, OnItemClickListener onItemClickListener) {
        this.list = rvList;
        this.imgList = imgList;
        this.a = a;
        this.customLayoutID = toolbarIDs.getCustomLayoutId();
        this.txtID = toolbarIDs.getItemTitleId();
        this.imgID = toolbarIDs.getItemImageId();
        this.onItemClickListener = onItemClickListener;

        RecyclerView rv = (RecyclerView) a.findViewById(R.id.sky_rv_drawer);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(a);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(this);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt;
        ImageView img;

        ViewHolder(View itemView) {
            super(itemView);
            //txt = (TextView) itemView.findViewById(txtID);
            //LayoutInflater inflater = a.getLayoutInflater();
            //View v = inflater.inflate(customLayoutID, null);
            /*ViewGroup root = (ViewGroup) v;
            for (int i = 0; i < root.getChildCount(); i++) {
                View myView = root.getChildAt(i);
                if (myView instanceof TextView) {
                    txt = (TextView) myView;
                }
            }*/
            txt = (TextView) itemView.findViewById(R.id.sky_txt_drawer);
            img = (ImageView) itemView.findViewById(R.id.sky_img_drawer);
            /*if (imgID != null){
                img = (ImageView) itemView.findViewById(imgID);
            }*/
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
