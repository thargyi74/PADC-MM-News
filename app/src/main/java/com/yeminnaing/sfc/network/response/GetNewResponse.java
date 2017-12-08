package com.yeminnaing.sfc.network.response;

import com.google.gson.annotations.SerializedName;
import com.yeminnaing.sfc.data.vo.NewsVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yeminnaing on 12/3/17.
 */

public class GetNewResponse {

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("apiVersion")
    private String apiVersion;
    @SerializedName("page")
    private int pageNo;
    @SerializedName("mmNews")
    private List<NewsVO> newsList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public int getPageNo() {
        return pageNo;
    }

    public List<NewsVO> getNewsList() {

        if(newsList == null){

            newsList = new ArrayList<>();
        }
        return newsList;
    }
}
