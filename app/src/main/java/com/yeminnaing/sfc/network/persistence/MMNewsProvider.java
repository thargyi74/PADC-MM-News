package com.yeminnaing.sfc.network.persistence;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by yeminnaing on 12/16/17.
 */

public class MMNewsProvider extends ContentProvider {

    public static final int NEWS = 100;
    public static final int ACTED_USERS = 200;
    public static final int PUBLICATIONS = 300;
    public static final int IMAGES_IN_NEWS = 400;
    public static final int FAVORITE_ACTIONS = 500;
    public static final int COMMENT_ACTIONS = 600;
    public static final int SENT_TO_ACTION = 700;

    private static final UriMatcher sUriMatcher = buildUriMatcher();

    private MNNewsDBHelper mDBHelper;

    private static UriMatcher buildUriMatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(NewsContract.CONTENT_AUTHORITY, NewsContract.PATH_USERS, ACTED_USERS);
        uriMatcher.addURI(NewsContract.CONTENT_AUTHORITY, NewsContract.PATH_PUBLICATIONS, PUBLICATIONS);
        uriMatcher.addURI(NewsContract.CONTENT_AUTHORITY, NewsContract.PATH_NEWS, NEWS);
        uriMatcher.addURI(NewsContract.CONTENT_AUTHORITY, NewsContract.PATH_IMAGES_IN_NEWS, IMAGES_IN_NEWS);
        uriMatcher.addURI(NewsContract.CONTENT_AUTHORITY, NewsContract.PATH_FAVORITE_ACTION, FAVORITE_ACTIONS);
        uriMatcher.addURI(NewsContract.CONTENT_AUTHORITY, NewsContract.PATH_COMMENT_ACTION, COMMENT_ACTIONS);
        uriMatcher.addURI(NewsContract.CONTENT_AUTHORITY, NewsContract.PATH_SEND_TO_ACTION, SENT_TO_ACTION);


        return uriMatcher;
    }

    private String getTableName(Uri uri) {

        switch (sUriMatcher.match(uri)) {
            case ACTED_USERS:
                return NewsContract.UserEntry.TABLE_NAME;

            case PUBLICATIONS:
                return NewsContract.PublicationEntry.TABLE_NAME;

            case NEWS:
                return NewsContract.NewsEntry.TABLE_NAME;
            case IMAGES_IN_NEWS:
                return NewsContract.ImagesInNewsEntry.TABLE_NAME;

            case FAVORITE_ACTIONS:
                return NewsContract.FavoriteActionEntry.TABLE_NAME;
            case COMMENT_ACTIONS:
                return NewsContract.CommentActionsEntry.TABLE_NAME;
            case SENT_TO_ACTION:
                return NewsContract.SendToActionsEntry.TABLE_NAME;
            default:
                throw new UnsupportedOperationException("Unknown uri : " + uri);
        }

    }

    private Uri getContentUri(Uri uri) {

        switch (sUriMatcher.match(uri)) {
            case ACTED_USERS:
                return NewsContract.UserEntry.CONTENT_URI;

            case PUBLICATIONS:
                return NewsContract.PublicationEntry.CONTENT_URI;

            case NEWS:
                return NewsContract.NewsEntry.CONTENT_URI;
            case IMAGES_IN_NEWS:
                return NewsContract.ImagesInNewsEntry.CONTENT_URI;

            case FAVORITE_ACTIONS:
                return NewsContract.FavoriteActionEntry.CONTENT_URI;
            case COMMENT_ACTIONS:
                return NewsContract.CommentActionsEntry.CONTENT_URI;
            case SENT_TO_ACTION:
                return NewsContract.SendToActionsEntry.CONTENT_URI;
            default:
                throw new UnsupportedOperationException("Unknown uri : " + uri);
        }


    }


    @Override
    public boolean onCreate() {
        mDBHelper = new MNNewsDBHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor queryCursor = mDBHelper.getReadableDatabase().query(getTableName(uri),
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder);
        if(getContext() != null){
            queryCursor.setNotificationUri(getContext().getContentResolver(), uri);
        }


        return queryCursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case ACTED_USERS:
                return NewsContract.UserEntry.DIR_TYPE;

            case PUBLICATIONS:
                return NewsContract.PublicationEntry.DIR_TYPE;

            case NEWS:
                return NewsContract.NewsEntry.DIR_TYPE;
            case IMAGES_IN_NEWS:
                return NewsContract.ImagesInNewsEntry.DIR_TYPE;

            case FAVORITE_ACTIONS:
                return NewsContract.FavoriteActionEntry.DIR_TYPE;
            case COMMENT_ACTIONS:
                return NewsContract.CommentActionsEntry.DIR_TYPE;
            case SENT_TO_ACTION:
                return NewsContract.SendToActionsEntry.DIR_TYPE;
            default:
                throw new UnsupportedOperationException("Unknown uri : " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        final SQLiteDatabase db = mDBHelper.getWritableDatabase();
        String tableName = getTableName(uri);
        long _id = db.insert(tableName, null, contentValues);
        if (_id > 0) {
            Uri tableContentUri = getContentUri(uri);
            Uri insertedUri = ContentUris.withAppendedId(tableContentUri, _id);

            if (getContext() != null) {

                getContext().getContentResolver().notifyChange(uri, null);
            }

            return insertedUri;
        }

        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        final SQLiteDatabase db = mDBHelper.getWritableDatabase();
        int rowDeleted;
        String tableName = getTableName(uri);

        rowDeleted = db.delete(tableName, selection, selectionArgs);
        Context context = getContext();
        if (context != null && rowDeleted > 0) {
            context.getContentResolver().notifyChange(uri, null);

        }

        return rowDeleted;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String selection, @Nullable String[] selectionArgs) {
        final SQLiteDatabase db = mDBHelper.getWritableDatabase();
        int rowUpdated;
        String tableName = getTableName(uri);

        rowUpdated = db.update(tableName, contentValues, selection, selectionArgs);
        Context context = getContext();
        if (context != null && rowUpdated > 0) {
            context.getContentResolver().notifyChange(uri, null);
        }
        return rowUpdated;
    }

    @Override
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] values) {
        final SQLiteDatabase db = mDBHelper.getWritableDatabase();
        String tableName = getTableName(uri);
        int insertedCount = 0;

        try {
            db.beginTransaction();
            for (ContentValues cv : values) {
                long _id = db.insert(tableName, null, cv);
                if (_id > 0) {
                    insertedCount++;
                }
            }

            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }

        Context context = getContext();
        if (context != null) {
            context.getContentResolver().notifyChange(uri, null);
        }

        return insertedCount;
    }
}
