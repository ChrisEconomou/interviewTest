package com.chriseconomou.depop.fragment;

import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.chriseconomou.depop.R;
import com.chriseconomou.depop.application.SampleApplication;
import com.chriseconomou.depop.view.RoundedImageView;
import com.viewpagerindicator.TabPageIndicator;

import org.junit.Before;
import org.junit.Test;

import butterknife.InjectView;

import static org.junit.Assert.assertNotNull;

public class MainFragmentTest extends RobolectricFragmentTest {


    @InjectView(R.id.indicator)
    TabPageIndicator mIndicator;
    @InjectView(R.id.viewpager)
    ViewPager mViewpager;
    @InjectView(R.id.header_image_profile)
    RoundedImageView mImageProfile;
    @InjectView(R.id.header_text_name)
    TextView mTextName;
    @InjectView(R.id.header_text_following_value)
    TextView mTextFollowingValue;
    @InjectView(R.id.header_text_followers_value)
    TextView mTextFollowersValue;
    @InjectView(R.id.header_text_description)
    TextView mTextDescription;
    @InjectView(R.id.header_text_url)
    TextView mTextUrl;

    @Before
    public void setUp() {
        super.setUp(MainFragment.newInstance(), null);
    }

    @Override
    protected void obtainViewReferences() {
        mIndicator = getView(R.id.indicator);
        mViewpager = getView(R.id.viewpager);
        mImageProfile = getView(R.id.header_image_profile);
        mTextName = getView(R.id.header_text_name);
        mTextFollowingValue = getView(R.id.header_text_following_value);
        mTextFollowersValue = getView(R.id.header_text_followers_value);
        mTextDescription = getView(R.id.header_text_description);
        mTextUrl = getView(R.id.header_text_url);
    }

    @Override
    protected void mockObjects(SampleApplication sampleApplication) {

    }

    @Test
    public void checkFragmentNotNull() {
        assertNotNull(mFragment);
    }

    @Test
    public void checkViewsNotNull() throws Exception {
        assertNotNull(mIndicator);
        assertNotNull(mViewpager);
        assertNotNull(mImageProfile);
        assertNotNull(mTextName);
        assertNotNull(mTextFollowingValue);
        assertNotNull(mTextFollowersValue);
        assertNotNull(mTextDescription);
        assertNotNull(mTextUrl);


    }


}
