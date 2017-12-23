package com.yeminnaing.sfc.data.vo;

import android.content.ContentValues;

import com.google.gson.annotations.SerializedName;
import com.yeminnaing.sfc.network.persistence.NewsContract;

/**
 * Created by yeminnaing on 12/3/17.
 */

public class CommentVO {

    @SerializedName("comment-id")
    private String commentId;
    @SerializedName("comment")
    private String comment;
    @SerializedName("comment-date")
    private String commentDate;
    @SerializedName("acted-user")
    private ActionUserVO actionUser;

    public String getCommentId() {
        return commentId;
    }

    public String getComment() {
        return comment;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public ActionUserVO getActionUser() {
        return actionUser;
    }

    public ContentValues parseToContentValues(String newsId){
        ContentValues contentValues = new ContentValues();
        contentValues.put(NewsContract.CommentActionsEntry.COLUMN_USER_ID, actionUser.getUserId());
        contentValues.put(NewsContract.CommentActionsEntry.COLUMN_COMMENT, comment);
        contentValues.put(NewsContract.CommentActionsEntry.COLUMN_COMMENT_ID, commentId);
        contentValues.put(NewsContract.CommentActionsEntry.COLUMN_NEWS_ID, newsId);
        contentValues.put(NewsContract.CommentActionsEntry.COLUMN_COMMENT_DATE, commentDate);

        return contentValues;
    }
}
