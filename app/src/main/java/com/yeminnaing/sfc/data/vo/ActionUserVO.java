package com.yeminnaing.sfc.data.vo;

import android.content.ContentValues;

import com.google.gson.annotations.SerializedName;
import com.yeminnaing.sfc.network.persistence.NewsContract;

/**
 * Created by yeminnaing on 12/3/17.
 */

public class ActionUserVO {

    @SerializedName("user-id")
    private String userId;
    @SerializedName("user-name")
    private String userName;
    @SerializedName("profile-image")
    private String profileImage;

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public ContentValues parseToContentValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(NewsContract.UserEntry.COLUMN_USER_ID, userId);
        contentValues.put(NewsContract.UserEntry.COLUMN_USER_NAME, userName);
        contentValues.put(NewsContract.UserEntry.COLUMN_PROFILE_IMAGE, profileImage);

        return contentValues;
    }
}
