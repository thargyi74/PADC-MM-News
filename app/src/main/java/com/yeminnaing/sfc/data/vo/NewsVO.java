package com.yeminnaing.sfc.data.vo;

import android.content.ContentValues;
import android.database.Cursor;

import com.google.gson.annotations.SerializedName;
import com.yeminnaing.sfc.network.persistence.NewsContract;

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

    public ContentValues parseToContentValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(NewsContract.NewsEntry.COLUMN_NEWS_ID, newsId);
        contentValues.put(NewsContract.NewsEntry.COLUMN_BRIEF, breif);
        contentValues.put(NewsContract.NewsEntry.COLUMN_DETAILS, details);
        contentValues.put(NewsContract.NewsEntry.COLUMN_POSTED_DATE, postedDate);
        contentValues.put(NewsContract.NewsEntry.COLUMN_PUBLICATION_ID, publication.getPublicationId());


        return contentValues;
    }

    public static NewsVO parseFromCursor(Cursor cursor){

        NewsVO news = new NewsVO();
        news.newsId = cursor.getString(cursor.getColumnIndex(NewsContract.NewsEntry.COLUMN_NEWS_ID));
        news.breif = cursor.getString(cursor.getColumnIndex(NewsContract.NewsEntry.COLUMN_BRIEF));
        news.details = cursor.getString(cursor.getColumnIndex(NewsContract.NewsEntry.COLUMN_DETAILS));
        news.postedDate = cursor.getString(cursor.getColumnIndex(NewsContract.NewsEntry.COLUMN_POSTED_DATE));
        return news;

    }
}
