package com.yeminnaing.sfc.data.vo;

import com.google.gson.annotations.SerializedName;

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
}
