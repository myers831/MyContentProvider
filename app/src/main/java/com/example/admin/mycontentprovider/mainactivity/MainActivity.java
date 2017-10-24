package com.example.admin.mycontentprovider.mainactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.mycontentprovider.model.AnimeCharacter;
import com.example.admin.mycontentprovider.Utils.DatabaseHelper;
import com.example.admin.mycontentprovider.R;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{

    EditText etAnimeCharacterName, etAnimeCharacterShow, etAnimeCharacterCatchPhrase;
    DatabaseHelper databaseHelper;
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenter();
        presenter.addView(this);
        databaseHelper = new DatabaseHelper(this);

        etAnimeCharacterName = findViewById(R.id.etAnimeCharacterName);
        etAnimeCharacterShow = findViewById(R.id.etAnimeCharacterShow);
        etAnimeCharacterCatchPhrase = findViewById(R.id.etAnimeCharacterCatchPhrase);

    }


    public void addAnimeCharacter(View view) {
        presenter.populateDB(this,
                new AnimeCharacter(etAnimeCharacterName.getText().toString(),
                        etAnimeCharacterShow.getText().toString(),
                        etAnimeCharacterCatchPhrase.getText().toString()));
        Toast.makeText(this, "Anime Character Added", Toast.LENGTH_SHORT).show();
    }
}
