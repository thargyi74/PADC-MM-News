package com.yeminnaing.sfc.events;

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

        public NewDataLoadedEvent(int loadedPageIndex, List<NewsVO> loadedNews) {
            this.loadedPageIndex = loadedPageIndex;
            this.loadedNews = loadedNews;
        }

        public int getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<NewsVO> getLoadedNews() {
            return loadedNews;
        }
    }

}
