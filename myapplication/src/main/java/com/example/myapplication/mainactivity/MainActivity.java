package com.example.myapplication.mainactivity;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.myapplication.AnimeCharacter;
import com.example.myapplication.R;
import com.example.myapplication.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    RecyclerView rvAnimeCharacterList;
    RecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvAnimeCharacterList = findViewById(R.id.rvAnimeCharacterList);
        layoutManager = new LinearLayoutManager(this);
        presenter = new MainActivityPresenter();

        Uri contentURI = Uri.parse("content://com.example.admin.mycontentprovider.provider");
        //Log.d(TAG, "getContent: " + contentURI);

        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);

        presenter.addView(this);
        presenter.getContent(cursor);

    }

    @Override
    public void setView(List<AnimeCharacter> animeCharacterList) {
        adapter = new RecyclerAdapter(animeCharacterList);
        rvAnimeCharacterList.setLayoutManager(layoutManager);
        rvAnimeCharacterList.setAdapter(adapter);
    }
}
