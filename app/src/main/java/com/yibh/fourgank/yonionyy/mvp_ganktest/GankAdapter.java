package com.yibh.fourgank.yonionyy.mvp_ganktest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yibh.fourgank.FourApp;
import com.yibh.fourgank.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yibh on 2016/9/5  12:08 .
 */

public class GankAdapter extends RecyclerView.Adapter<GankAdapter.GankHolder> {
    private List<FuliBean.Meiz> mMeizs=new ArrayList<>();

    @Override
    public GankHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.gank_recy_item, parent, false);
        return new GankHolder(inflate);
    }

    @Override
    public void onBindViewHolder(GankHolder holder, int position) {
        FuliBean.Meiz meiz = mMeizs.get(position);
        Glide.with(FourApp.mContext).load(meiz.mUrl).centerCrop().into(holder.mMeizView);
        holder.mDescView.setText(meiz.mDesc);

    }

    @Override
    public int getItemCount() {
        return null == mMeizs ? 0 : mMeizs.size();
    }

    public class GankHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.meiz_img)
        public ImageView mMeizView;

        @BindView(R.id.desc_textview)
        public TextView mDescView;

        public GankHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


    public void onRefresh(List<FuliBean.Meiz> meizList){
//        if (meizList.size()>0) this.mMeizs.clear();
        this.mMeizs.addAll(meizList);
        notifyDataSetChanged();
    }


}
