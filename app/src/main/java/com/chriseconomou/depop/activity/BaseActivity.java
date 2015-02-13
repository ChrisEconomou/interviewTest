package com.chriseconomou.depop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.chriseconomou.depop.application.SampleApplication;

import butterknife.ButterKnife;

/**
 * Base activity, that holds access to global instances and has activity/fragment management methods.
 */
public abstract class BaseActivity extends ActionBarActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        ButterKnife.inject(this);
        SampleApplication app = ((SampleApplication) getApplication());

    }

    protected abstract int getLayoutId();

    protected abstract void initializeViews(Bundle savedInstanceState);


    protected void startActivity(Class classOfActivity, boolean newTask) {
        startActivity(classOfActivity, null, newTask);
    }


    protected void startActivity(Class classOfActivity, Bundle bundle, boolean newTask) {
        Intent intent = new Intent(this, classOfActivity);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (newTask) {
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        startActivity(intent);
    }


}

