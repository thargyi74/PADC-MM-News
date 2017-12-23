package com.yeminnaing.sfc.network.persistence;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import com.yeminnaing.sfc.SFCNewsApp;

/**
 * Created by yeminnaing on 12/10/17.
 */

public class NewsContract {

    public static final String CONTENT_AUTHORITY = SFCNewsApp.class.getPackage().getName();

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_NEWS = "news";
    public static final String PATH_IMAGES_IN_NEWS = "images_in_news";
    public static final String PATH_PUBLICATIONS = "publications";
    public static final String PATH_FAVORITE_ACTION = "favorite_action";
    public static final String PATH_COMMENT_ACTION = "comment_action";
    public static final String PATH_SEND_TO_ACTION = "send_to_action";
    public static final String PATH_USERS = "users";


    public static class NewsEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_NEWS).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_NEWS;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_NEWS;


        public static final String TABLE_NAME = PATH_NEWS;

        public static final String COLUMN_NEWS_ID = "news_id";
        public static final String COLUMN_BRIEF = "brief";
        public static final String COLUMN_DETAILS = "details";
        public static final String COLUMN_POSTED_DATE = "posted_date";
        public static final String COLUMN_PUBLICATION_ID = "publication_id";

        public static Uri buildNewsUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

    }

    public static class ImagesInNewsEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_IMAGES_IN_NEWS).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_IMAGES_IN_NEWS;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_IMAGES_IN_NEWS;

        public static final String TABLE_NAME = PATH_IMAGES_IN_NEWS;

        public static final String COLUMN_NEWS_ID = "news_id";
        public static final String COLUMN_IMAGE_URL = "image_url";

        public static Uri buildImagesInNewsUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }


    }

    public static class PublicationEntry implements BaseColumns{

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_PUBLICATIONS).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PUBLICATIONS;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PUBLICATIONS;

        public static final String TABLE_NAME = PATH_PUBLICATIONS;

        public static final String COLUMN_PUBBLICATION_ID = "publication_id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_LOGO = "logo";

        public static Uri buildPublicationUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }


    }

    public static class FavoriteActionEntry implements BaseColumns{

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_FAVORITE_ACTION).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FAVORITE_ACTION;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FAVORITE_ACTION;

        public static final String TABLE_NAME = PATH_FAVORITE_ACTION;


        public static final String COLUMN_FAVORITE_ID = "favorite_id";
        public static final String COLUMN_FAVORITE_DATE = "favorite_date";
        public static final String COLUMN_NEWS_ID = "news_id";
        public static final String COLUMN_USER_ID = "user_id";

        public static Uri buildFavoriteActionUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }


    }

    public static class CommentActionsEntry implements BaseColumns{


        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_COMMENT_ACTION).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_COMMENT_ACTION;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_COMMENT_ACTION;

        public static final String TABLE_NAME = PATH_COMMENT_ACTION;


        public static final String COLUMN_COMMENT_ID = "comment_id";
        public static final String COLUMN_COMMENT_DATE = "comment_date";
        public static final String COLUMN_COMMENT = "comment";

        public static final String COLUMN_NEWS_ID = "news_id";
        public static final String COLUMN_USER_ID = "user_id";

        public static Uri buildCommentUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }


    }

    public static class SendToActionsEntry implements BaseColumns{

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_SEND_TO_ACTION).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SEND_TO_ACTION;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SEND_TO_ACTION;

        public static final String TABLE_NAME = PATH_SEND_TO_ACTION;

        public static final String COLUMN_COMMENT_ID = "comment_id";
        public static final String COLUMN_SENT_TO_ID = "sent_to_id";
        public static final String COLUMN_COMMENT_DATE = "comment_date";
        public static final String COLUMN_NEWS_ID = "news_id";
        public static final String COLUMN_SENDER_ID = "sender_id";
        public static final String COLUMN_RECEIVER_ID = "receiver_id";

        public static Uri buildSendToUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

    }

    public static class UserEntry implements BaseColumns{

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_USERS).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_USERS;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_USERS;

        public static final String TABLE_NAME = PATH_USERS;

        public static final String COLUMN_USER_ID = "user_id";
        public static final String COLUMN_USER_NAME = "user_name";
        public static final String COLUMN_PROFILE_IMAGE = "profile_name";

        public static Uri buildUserUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }


    }




}
