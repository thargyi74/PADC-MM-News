package com.yeminnaing.sfc.data.vo;

import com.google.gson.annotations.SerializedName;

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
}
