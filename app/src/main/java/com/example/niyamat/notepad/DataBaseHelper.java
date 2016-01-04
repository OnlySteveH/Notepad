package com.example.niyamat.notepad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Niyamat on 1/2/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "note_table";
    public static final String DATABASE_NAME = "db";
    private static final int DATABASE_VERSION = 1;
    public static final String NOTE_ID = "ID";
    public static final String NOTE_TITLE = "NOTE_TITLE";
    public static final String NOTE_BODY = "NOTE_BODY";

    private SQLiteDatabase mDatabase;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE" + TABLE_NAME + "("
                + NOTE_ID + "INTEGER PRIMARY KEY ,"
                + NOTE_TITLE + "VARCHAR,"
                + NOTE_BODY + "VARCHAR" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF IT EXISTS" + TABLE_NAME);
        onCreate(db);
    }

    public void insertRecord(Note note) {
        mDatabase = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOTE_TITLE, note.getTitle());
        values.put(NOTE_BODY, note.getBody());
        mDatabase.insert(TABLE_NAME, null, values);
        mDatabase.close();
    }

    public void updateRecord(Note note) {
        mDatabase = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOTE_TITLE, note.getTitle());
        values.put(NOTE_BODY, note.getBody());
        mDatabase.update(TABLE_NAME, values, NOTE_ID + " = ?", new String[]{note.getId()});
        mDatabase.close();
    }

    public void deleteRecord(Note note) {
        mDatabase = getReadableDatabase();
        mDatabase.delete(TABLE_NAME, NOTE_ID + " = ?", new String[]{note.getId()});
        mDatabase.close();
    }

    public Note[] getAllRecords() {
        mDatabase = getReadableDatabase();
        Cursor cursor = mDatabase.query(TABLE_NAME, null, null, null, null, null,null);
        Note[] notes = new Note[cursor.getCount()];
        Note note;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                note = new Note();
                note.setId(cursor.getString(0));
                note.setTitle(cursor.getString(1));
                note.setBody(cursor.getString(2));
                notes[i] = note;
            }
        }
        cursor.close();
        mDatabase.close();
        return notes;
    }


}
