package com.yeminnaing.sfc.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yeminnaing on 12/3/17.
 */

public class SentToVO {

    @SerializedName("send-to-id")
    private String sendToId;
    @SerializedName("sent-date")
    private  String sentDate;
    @SerializedName("acted-user")
    private ActionUserVO sender;
    @SerializedName("received-user")
    private ActionUserVO receiver;

    public String getSendToId() {
        return sendToId;
    }

    public String getSentDate() {
        return sentDate;
    }

    public ActionUserVO getSender() {
        return sender;
    }

    public ActionUserVO getReciver() {
        return receiver;
    }
}
