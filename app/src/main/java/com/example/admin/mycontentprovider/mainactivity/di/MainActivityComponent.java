package com.example.admin.mycontentprovider.mainactivity.di;

import com.example.admin.mycontentprovider.mainactivity.MainActivity;

import dagger.Component;

/**
 * Created by Admin on 10/20/2017.
 */

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
