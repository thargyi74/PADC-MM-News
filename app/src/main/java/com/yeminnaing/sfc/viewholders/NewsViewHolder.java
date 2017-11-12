package com.yeminnaing.sfc.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yeminnaing.sfc.delegates.NewsItemDelegate;

/**
 * Created by yeminnaing on 11/4/17.
 */

public class NewsViewHolder extends RecyclerView.ViewHolder {

    public NewsItemDelegate mDelegate;



    public NewsViewHolder(View itemView, NewsItemDelegate newsItemDelegate) {
        super(itemView);
        mDelegate = newsItemDelegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDelegate.onTabNews();

            }
        });
    }
}
