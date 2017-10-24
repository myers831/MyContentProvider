package com.example.admin.mycontentprovider.mainactivity;

import android.content.Context;

import com.example.admin.mycontentprovider.model.AnimeCharacter;
import com.example.admin.mycontentprovider.Utils.DatabaseHelper;

/**
 * Created by Admin on 10/23/2017.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    MainActivityContract.View view;

    @Override
    public void addView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {

    }

    public void populateDB(Context context, AnimeCharacter animeCharacter){
        DatabaseHelper databaseHelper = new DatabaseHelper(context);

        databaseHelper.saveAnimeCharacter(animeCharacter);


    }

}
