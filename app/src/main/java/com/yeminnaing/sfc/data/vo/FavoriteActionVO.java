package com.yeminnaing.sfc.data.vo;

import android.content.ContentValues;

import com.google.gson.annotations.SerializedName;
import com.yeminnaing.sfc.network.persistence.NewsContract;

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

    public ContentValues parseToContentValues(String newsId){
        ContentValues contentValues = new ContentValues();
        contentValues.put(NewsContract.FavoriteActionEntry.COLUMN_USER_ID, actionUser.getUserId());
        contentValues.put(NewsContract.FavoriteActionEntry.COLUMN_FAVORITE_ID, favoriteID);
        contentValues.put(NewsContract.FavoriteActionEntry.COLUMN_FAVORITE_DATE, favoriteDate);
        contentValues.put(NewsContract.FavoriteActionEntry.COLUMN_NEWS_ID, newsId);

        return contentValues;
    }
}
