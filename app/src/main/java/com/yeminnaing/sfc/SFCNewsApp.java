package com.yeminnaing.sfc;

import android.app.Application;

import com.yeminnaing.sfc.data.model.NewsModel;

/**
 * Created by yeminnaing on 11/4/17.
 */

public class SFCNewsApp extends Application {

    public static final String LOG_TAG = "SFCNewsApp";

    @Override
    public void onCreate() {
        super.onCreate();
        NewsModel.getInstance().startLoadMMNews(getApplicationContext());
    }
}
