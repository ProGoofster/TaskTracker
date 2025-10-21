package com.example.tasktracker;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import androidx.annotation.Nullable;

import java.sql.SQLData;

public class MyTaskContentProvider extends ContentProvider {

    public final static String DB_NAME = "TaskDB";
    public final static String COL_TASK = "TASK";
    public final static String COL_OWN = "OWNER";
    public final static String TABLE_NAME = "TaskTable";

    public final static String SQL_CREATE = "Create TABLE "+ TABLE_NAME +" (" +
            "_ID INTEGER PRIMARY KEY, " +
            COL_TASK + " TEXT," +
            COL_OWN + " TEXT )";

    public static final Uri CONTENT_URI = Uri.parse("content://com.example.tasktrackerdv.provider");

    MainDatabaseHelper mHelper;
    protected final class MainDatabaseHelper extends SQLiteOpenHelper {


        public MainDatabaseHelper(Context context) {
            super(context, DB_NAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
    public MyTaskContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        String owner = values.getAsString(COL_OWN);
        String task = values.getAsString(COL_TASK);
        long id = mHelper.getWritableDatabase().insert(TABLE_NAME, null, values);
        return uri.withAppendedPath(uri, id + "");
    }

    @Override
    public boolean onCreate() {
        mHelper = new MainDatabaseHelper(getContext());
        // TODO: Implement this to initialize your content provider on startup.
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        return mHelper.getReadableDatabase().query(TABLE_NAME, projection, selection,
                selectionArgs, null, null, sortOrder);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}