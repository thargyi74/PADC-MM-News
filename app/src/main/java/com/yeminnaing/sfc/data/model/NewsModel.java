package com.yeminnaing.sfc.data.model;

import com.yeminnaing.sfc.data.vo.NewsVO;
import com.yeminnaing.sfc.events.RestApiEvents;
import com.yeminnaing.sfc.network.MMNewsDataAgent;
import com.yeminnaing.sfc.network.MMNewsDataAgentImpl;
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

    public void startLoadMMNews(){

        MMNewsDataAgentImpl.getInstance().loadMMNews(AppConstants.ACCESS_TOKEN, mmNewsPageIndex);


    }

    //event listen
    @Subscribe
    public void onNewsDataLoaded(RestApiEvents.NewDataLoadedEvent event){
        mNews.addAll(event.getLoadedNews());
        mmNewsPageIndex = event.getLoadedPageIndex() +1;



    }


}
