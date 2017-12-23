package com.yeminnaing.sfc.events;

import android.content.Context;

import com.yeminnaing.sfc.data.vo.NewsVO;

import java.util.List;

/**
 * Created by yeminnaing on 12/3/17.
 */

public class RestApiEvents {

    public static class EmptyResponseEvent{


    }

    public static class ErrorInvokingAPIEvent{

        private String errorMsg;

        public ErrorInvokingAPIEvent(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public String getErrorMsg() {
            return errorMsg;
        }
    }

    public static class NewDataLoadedEvent{
        private int loadedPageIndex;
        private List<NewsVO> loadedNews;
        private Context context;

        public Context getContext() {
            return context;
        }

        public NewDataLoadedEvent(int loadedPageIndex, List<NewsVO> loadedNews, Context context) {
            this.loadedPageIndex = loadedPageIndex;
            this.loadedNews = loadedNews;
            this.context = context;
        }

        public int getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<NewsVO> getLoadedNews() {
            return loadedNews;
        }
    }

}
