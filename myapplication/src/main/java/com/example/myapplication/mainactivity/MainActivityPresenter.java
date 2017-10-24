package com.example.myapplication.mainactivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.myapplication.AnimeCharacter;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by Admin on 10/24/2017.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {
    private static final String TAG = "MainActivityPresenter";
    MainActivityContract.View view;

    @Override
    public void addView(MainActivityContract.View view) {
        this.view = view;

    }

    @Override
    public void removeView() {

    }

    public void getContent(Cursor cursor){
        List<AnimeCharacter> animeCharacterList = new ArrayList<>();

        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("Name"));
            String show = cursor.getString(cursor.getColumnIndex("Show"));
            String catchPhrase = cursor.getString(cursor.getColumnIndex("CatchPhase"));

            animeCharacterList.add(new AnimeCharacter(name, show, catchPhrase));
        }

        view.setView(animeCharacterList);
    }


}
