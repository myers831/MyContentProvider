package com.example.admin.mycontentprovider.mainactivity.di;

import android.content.Context;

import com.example.admin.mycontentprovider.Utils.DatabaseHelper;
import com.example.admin.mycontentprovider.mainactivity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Admin on 10/20/2017.
 */

//denote the module with @module annotation
@Module
public class MainActivityModule {

    //provides the MainActivityPresenter object by this method
    @Provides
    MainActivityPresenter providesMainActivityPresenter(){
        return new MainActivityPresenter();
    }
    @Provides
    DatabaseHelper providesDatabaseHelper(Context context){return new DatabaseHelper(context);}
}
