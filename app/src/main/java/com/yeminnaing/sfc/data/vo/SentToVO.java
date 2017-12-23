package com.yeminnaing.sfc.data.vo;

import android.content.ContentValues;

import com.google.gson.annotations.SerializedName;
import com.yeminnaing.sfc.network.persistence.NewsContract;

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

    public ContentValues parseToContentValues(String newsID){
        ContentValues contentValues = new ContentValues();
        contentValues.put(NewsContract.SendToActionsEntry.COLUMN_SENT_TO_ID, sendToId);
        contentValues.put(NewsContract.SendToActionsEntry.COLUMN_COMMENT_DATE, sentDate);
        contentValues.put(NewsContract.SendToActionsEntry.COLUMN_NEWS_ID, newsID);
        contentValues.put(NewsContract.SendToActionsEntry.COLUMN_SENDER_ID, sender.getUserId());
        contentValues.put(NewsContract.SendToActionsEntry.COLUMN_RECEIVER_ID, receiver.getUserId());

        return contentValues;
    }
}
