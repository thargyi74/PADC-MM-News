package com.yeminnaing.sfc.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.yeminnaing.sfc.R;
import com.yeminnaing.sfc.viewholders.RelatedNewsViewHolder;

/**
 * Created by yeminnaing on 11/22/17.
 */

public class RelatedNewsAdapter extends RecyclerView.Adapter<RelatedNewsViewHolder> {

    private LayoutInflater mlayoutInflater;

    public RelatedNewsAdapter(Context context){
        mlayoutInflater = LayoutInflater.from(context);

    }


    @Override
    public RelatedNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view =  mlayoutInflater.inflate(R.layout.view_item_related_news, parent, false);
        return new RelatedNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RelatedNewsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 16;
    }
}
