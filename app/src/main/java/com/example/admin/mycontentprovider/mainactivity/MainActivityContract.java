package com.example.admin.mycontentprovider.mainactivity;

import com.example.admin.mycontentprovider.mvpbase.BasePresenter;
import com.example.admin.mycontentprovider.mvpbase.BaseView;

/**
 * Created by Admin on 10/23/2017.
 */

public interface MainActivityContract {
    interface View extends BaseView {
    }

    interface Presenter extends BasePresenter<View> {

    }
}
