package com.example.admin.mycontentprovider.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.admin.mycontentprovider.model.AnimeCharacter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 10/2/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "AnimeCharacter.db";

    public static final String TABLE_NAME = "AnimeCharacter";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_SHOW = "Show";
    public static final String COLUMN_CATCHPHASE = "CatchPhase";
    public static final String ID = "id";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY, " + COLUMN_NAME + " TEXT, " + COLUMN_SHOW + " TEXT, " + COLUMN_CATCHPHASE + " TEXT " + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long saveAnimeCharacter(AnimeCharacter animeCharacter){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, animeCharacter.getName());
        contentValues.put(COLUMN_SHOW, animeCharacter.getShow());
        contentValues.put(COLUMN_CATCHPHASE, animeCharacter.getCatchPhase());

        long isSaved = database.insert(TABLE_NAME, null, contentValues);

        return isSaved;
    }

    public List<AnimeCharacter> getAnimeCharacterList(){
        List<AnimeCharacter> animeCharacterList = new ArrayList<>();

        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "SELECT * from " + TABLE_NAME;

        Cursor cursor = database.rawQuery(QUERY, null);

        if(cursor.moveToFirst()){
            do{
                AnimeCharacter animeCharacter = new AnimeCharacter(cursor.getString(0), cursor.getString(1), cursor.getString(2));
                animeCharacterList.add(animeCharacter);
            }while (cursor.moveToNext());
        }

        return animeCharacterList;
    }
}
