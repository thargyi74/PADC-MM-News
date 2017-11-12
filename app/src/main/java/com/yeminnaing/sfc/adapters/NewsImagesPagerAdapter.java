package com.yeminnaing.sfc.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yeminnaing.sfc.R;

/**
 * Created by yeminnaing on 11/11/17.
 */

public class NewsImagesPagerAdapter extends PagerAdapter {

    private LayoutInflater mLayoutInflater;

    public NewsImagesPagerAdapter (Context context){

        //1
        super();
        mLayoutInflater = LayoutInflater.from(context);


    }



    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        //3
        return (view == (View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //2
        View itemView = mLayoutInflater.inflate(R.layout.view_item_news_details_images, container, false);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
