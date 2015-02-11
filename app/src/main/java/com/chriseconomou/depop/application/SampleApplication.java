package com.chriseconomou.depop.application;

import android.app.Application;

import com.chriseconomou.depop.error.ErrorManager;


import java.util.ArrayList;
import java.util.List;


/**
 * Global  {@link android.app.Application} instance. Instantiates all global instances.
 */
public class SampleApplication extends Application {



    private ErrorManager mErrorManager;
    private List<rx.Subscription> mSubscriptions;


    @Override
    public void onCreate() {
        super.onCreate();


        mSubscriptions = new ArrayList<rx.Subscription>();
        mErrorManager = new ErrorManager(this);
    }

    /**
     * @return Api client to use store services.
     */


    public ErrorManager getErrorManager() {
        return mErrorManager;
    }
}
