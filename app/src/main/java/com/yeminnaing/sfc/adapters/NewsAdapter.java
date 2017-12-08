package com.yeminnaing.sfc.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yeminnaing.sfc.R;
import com.yeminnaing.sfc.data.vo.NewsVO;
import com.yeminnaing.sfc.delegates.NewsItemDelegate;
import com.yeminnaing.sfc.viewholders.NewsViewHolder;

/**
 * Created by yeminnaing on 11/4/17.
 */

public class NewsAdapter extends BaseRecyclerAdapter<NewsViewHolder, NewsVO>{
    //private Context mContext;


    private NewsItemDelegate mNewsItemDelegate;

    public NewsAdapter(Context context, NewsItemDelegate newsItemDelegate){
        //***
        super(context);
        //mContext = context;


        mNewsItemDelegate = newsItemDelegate;

    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View newsItemView = mLayoutInflator.inflate(R.layout.view_item_news, parent, false);

        return new NewsViewHolder(newsItemView, mNewsItemDelegate);
    }




}
