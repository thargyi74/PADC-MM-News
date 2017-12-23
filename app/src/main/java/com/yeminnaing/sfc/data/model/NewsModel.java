package com.yeminnaing.sfc.data.model;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.yeminnaing.sfc.SFCNewsApp;
import com.yeminnaing.sfc.data.vo.NewsVO;
import com.yeminnaing.sfc.events.RestApiEvents;
import com.yeminnaing.sfc.network.MMNewsDataAgent;
import com.yeminnaing.sfc.network.MMNewsDataAgentImpl;
import com.yeminnaing.sfc.network.persistence.NewsContract;
import com.yeminnaing.sfc.utils.AppConstants;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yeminnaing on 12/3/17.
 */

public class NewsModel {

    private static NewsModel objInstance;

    private List<NewsVO> mNews;

    private int mmNewsPageIndex = 1;



    private NewsModel(){

        //register
        EventBus.getDefault().register(this);

        mNews = new ArrayList<>();


    }

    public static NewsModel getInstance(){

        if(objInstance == null){
            objInstance = new NewsModel();
        }
        return objInstance;
    }

    public void startLoadMMNews(Context context){

        MMNewsDataAgentImpl.getInstance().loadMMNews(AppConstants.ACCESS_TOKEN, mmNewsPageIndex, context);


    }

    //event listen
    @Subscribe
    public void onNewsDataLoaded(RestApiEvents.NewDataLoadedEvent event){
        mNews.addAll(event.getLoadedNews());
        mmNewsPageIndex = event.getLoadedPageIndex() +1;

        //TODO Logic to save the data in Rersistence Layer

        ContentValues[] newsCVs = new ContentValues[event.getLoadedNews().size()];
        for(int index=0; index< newsCVs.length; index++){
            newsCVs[index] = event.getLoadedNews().get(index).parseToContentValues();

        }


       int insertedRow = event.getContext().getContentResolver().bulkInsert(NewsContract.NewsEntry.CONTENT_URI, newsCVs);
        Log.d(SFCNewsApp.LOG_TAG, "instered Row" + insertedRow);



    }


}
