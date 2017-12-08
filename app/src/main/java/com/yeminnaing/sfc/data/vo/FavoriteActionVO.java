package com.yeminnaing.sfc.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yeminnaing on 12/3/17.
 */

public class FavoriteActionVO {

    @SerializedName("favorite-id")
    private String favoriteID;
    @SerializedName("favorite-date")
    private  String favoriteDate;
    @SerializedName("acted-user")
    private ActionUserVO actionUser;

    public String getFavoriteID() {
        return favoriteID;
    }

    public String getFavoriteDate() {
        return favoriteDate;
    }

    public ActionUserVO getActionUser() {
        return actionUser;
    }
}
