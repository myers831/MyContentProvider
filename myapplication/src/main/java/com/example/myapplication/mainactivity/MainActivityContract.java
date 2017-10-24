package com.example.myapplication.mainactivity;

import com.example.myapplication.AnimeCharacter;
import com.example.myapplication.BasePresenter;
import com.example.myapplication.BaseView;

import java.util.List;

/**
 * Created by Admin on 10/24/2017.
 */

public interface MainActivityContract {
    interface View extends BaseView {
        public void setView(List<AnimeCharacter> animeCharacterList);
    }

    interface Presenter extends BasePresenter<View> {

    }
}
