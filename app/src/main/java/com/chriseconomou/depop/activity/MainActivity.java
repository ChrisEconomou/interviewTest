package com.chriseconomou.depop.activity;


import android.os.Bundle;

import com.chriseconomou.depop.R;
import com.chriseconomou.depop.fragment.MainFragment;
import com.chriseconomou.depop.util.Utils;

public class MainActivity extends BaseToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeViews(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initializeViews(Bundle savedInstanceState) {
        getSupportActionBar().setTitle(getString(R.string.user_profile));
        Utils.addFragment(this, R.id.container, MainFragment.newInstance(), MainFragment.TAG, false);
    }
}
