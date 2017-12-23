package com.yeminnaing.sfc.network.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.NfcEvent;

/**
 * Created by yeminnaing on 12/16/17.
 */

public class MNNewsDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "mmNews.db";
    private static final int DB_VERSION = 2;


    private static final String SQL_CREATE_NEWS = "CREATE TABLE " + NewsContract.NewsEntry.TABLE_NAME + " (" +
            NewsContract.NewsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NewsContract.NewsEntry.COLUMN_NEWS_ID + " VARCHAR(256), " +
            NewsContract.NewsEntry.COLUMN_BRIEF + " TEXT, " +
            NewsContract.NewsEntry.COLUMN_DETAILS + " TEXT, " +
            NewsContract.NewsEntry.COLUMN_POSTED_DATE + " TEXT, " +
            NewsContract.NewsEntry.COLUMN_PUBLICATION_ID + " TEXT, " +

            " UNIQUE (" + NewsContract.NewsEntry.COLUMN_NEWS_ID + ") ON CONFLICT REPLACE" +

            ");";


    private static final String SQL_CREATE_IMAGES = "CREATE TABLE " + NewsContract.ImagesInNewsEntry.TABLE_NAME + " (" +
            NewsContract.ImagesInNewsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NewsContract.ImagesInNewsEntry.COLUMN_NEWS_ID + " VERCHAR(256), " +
            NewsContract.ImagesInNewsEntry.COLUMN_IMAGE_URL + " TEXT, " +

            " UNIQUE (" + NewsContract.ImagesInNewsEntry.COLUMN_IMAGE_URL + ") ON CONFLICT REPLACE" +

            ");";

    private static final String SQL_CREATE_PUBLICATION = "CREATE TABLE " + NewsContract.PublicationEntry.TABLE_NAME + " (" +
            NewsContract.PublicationEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NewsContract.PublicationEntry.COLUMN_PUBBLICATION_ID + " VARCHAR(256), " +
            NewsContract.PublicationEntry.COLUMN_TITLE + " TEXT, " +
            NewsContract.PublicationEntry.COLUMN_LOGO + "TEXT, " +

            " UNIQUE (" + NewsContract.PublicationEntry.COLUMN_PUBBLICATION_ID + ") ON CONFLICT REPLACE" +


            ");";

    private static final String SQL_CREATE_FAVOURITE_ACTION = "CREATE TABLE " + NewsContract.FavoriteActionEntry.TABLE_NAME + " (" +
            NewsContract.FavoriteActionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NewsContract.FavoriteActionEntry.COLUMN_FAVORITE_ID+ " VARCHAR(256), " +
            NewsContract.FavoriteActionEntry.COLUMN_FAVORITE_DATE + " TEXT, " +
            NewsContract.FavoriteActionEntry.COLUMN_NEWS_ID + " VARCHAR(256), " +
            NewsContract.FavoriteActionEntry.COLUMN_USER_ID + " VARCHAR(256), " +

            " UNIQUE (" + NewsContract.FavoriteActionEntry.COLUMN_FAVORITE_ID+ ") ON CONFLICT REPLACE" +


            ");";

    private static final String SQL_CREATE_COMMENT_ACTION = "CREATE TABLE " + NewsContract.CommentActionsEntry.TABLE_NAME + " (" +
            NewsContract.CommentActionsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NewsContract.CommentActionsEntry.COLUMN_COMMENT_ID+ " VARCHAR(256), " +
            NewsContract.CommentActionsEntry.COLUMN_COMMENT_DATE + " TEXT, " +
            NewsContract.CommentActionsEntry.COLUMN_COMMENT + " TEXT, " +
            NewsContract.CommentActionsEntry.COLUMN_NEWS_ID + " VARCHAR(256), " +
            NewsContract.CommentActionsEntry.COLUMN_USER_ID + " VARCHAR(256), " +

            " UNIQUE (" + NewsContract.CommentActionsEntry.COLUMN_COMMENT_ID + ") ON CONFLICT REPLACE" +


            ");";

    private static final String SQL_CREATE_SEND_TO_ACTION = "CREATE TABLE " + NewsContract.SendToActionsEntry.TABLE_NAME + " (" +
            NewsContract.SendToActionsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NewsContract.SendToActionsEntry.COLUMN_COMMENT_ID+ " VARCHAR(256), " +
            NewsContract.SendToActionsEntry.COLUMN_SENT_TO_ID+ " VARCHAR(256), " +
            NewsContract.SendToActionsEntry.COLUMN_COMMENT_DATE + " TEXT, " +
            NewsContract.SendToActionsEntry.COLUMN_SENDER_ID + " VARCHAR(256), " +
            NewsContract.SendToActionsEntry.COLUMN_NEWS_ID + " VARCHAR(256), " +
            NewsContract.SendToActionsEntry.COLUMN_RECEIVER_ID + " VARCHAR(256), " +

            " UNIQUE (" + NewsContract.SendToActionsEntry.COLUMN_SENDER_ID + ") ON CONFLICT REPLACE" +


            ");";

    private static final String SQL_CREATE_ACTED_USER = "CREATE TABLE " + NewsContract.UserEntry.TABLE_NAME + " (" +
            NewsContract.UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NewsContract.UserEntry.COLUMN_USER_ID+ " VARCHAR(256), " +
            NewsContract.UserEntry.COLUMN_USER_NAME+ " TEXT, " +
            NewsContract.UserEntry.COLUMN_PROFILE_IMAGE + " TEXT, " +

            " UNIQUE (" + NewsContract.UserEntry.COLUMN_USER_ID + ") ON CONFLICT REPLACE" +


            ");";



    public MNNewsDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(SQL_CREATE_ACTED_USER);
        sqLiteDatabase.execSQL(SQL_CREATE_PUBLICATION);
        sqLiteDatabase.execSQL(SQL_CREATE_NEWS);
        sqLiteDatabase.execSQL(SQL_CREATE_IMAGES);

        sqLiteDatabase.execSQL(SQL_CREATE_FAVOURITE_ACTION);
        sqLiteDatabase.execSQL(SQL_CREATE_COMMENT_ACTION);
        sqLiteDatabase.execSQL(SQL_CREATE_SEND_TO_ACTION);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + NewsContract.SendToActionsEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + NewsContract.CommentActionsEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + NewsContract.FavoriteActionEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + NewsContract.ImagesInNewsEntry.TABLE_NAME);

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + NewsContract.NewsEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + NewsContract.PublicationEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + NewsContract.UserEntry.TABLE_NAME);

        onCreate(sqLiteDatabase);



    }
}
