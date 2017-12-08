package com.yeminnaing.sfc.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yeminnaing on 12/2/17.
 */

public class NewsVO {


    @SerializedName("news-id")
    private String newsId;

    @SerializedName("brief")
    private String breif;

    @SerializedName("details")
    private String details;

    @SerializedName("images")
    private List<String> images;

    @SerializedName("posted-date")
    private String postedDate;


    @SerializedName("publication")
    private PublicationVO publication;


    @SerializedName("favorites")
    private List<FavoriteActionVO> favoriteAction;


    @SerializedName("comments")
    private List<CommentVO> commentList;


    @SerializedName("sent-tos")
    private List<SentToVO> sentToList;


    public String getNewsId() {
        return newsId;
    }

    public String getBreif() {
        return breif;
    }

    public String getDetails() {
        return details;
    }

    public List<String> getImages() {
        return images;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public PublicationVO getPublication() {
        return publication;
    }

    public List<FavoriteActionVO> getFavoriteAction() {
        return favoriteAction;
    }

    public List<CommentVO> getCommentList() {
        return commentList;
    }

    public List<SentToVO> getSentToList() {
        return sentToList;
    }
}
