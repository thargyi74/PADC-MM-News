package com.yeminnaing.sfc.data.vo;

import android.content.ContentValues;

import com.google.gson.annotations.SerializedName;
import com.yeminnaing.sfc.network.persistence.NewsContract;

/**
 * Created by yeminnaing on 12/3/17.
 */

public class PublicationVO {

    @SerializedName("publication-id")
    private String publicationId;
    @SerializedName("title")
    private String title;
    @SerializedName("logo")
    private String logo;

    public String getPublicationId() {
        return publicationId;
    }

    public String getTitle() {
        return title;
    }

    public String getLogo() {
        return logo;
    }

    public ContentValues parseToContentValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(NewsContract.PublicationEntry.COLUMN_PUBBLICATION_ID, publicationId);
        contentValues.put(NewsContract.PublicationEntry.COLUMN_TITLE, title);
        contentValues.put(NewsContract.PublicationEntry.COLUMN_LOGO, logo);

        return contentValues;
    }
}
