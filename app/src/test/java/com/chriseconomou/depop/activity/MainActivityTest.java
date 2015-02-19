package com.chriseconomou.depop.activity;

import com.chriseconomou.depop.application.SampleApplication;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by oikonomouc on 19/02/2015.
 */
public class MainActivityTest extends RobolectricActivityTest {


//    @Test
//    public void isMainActivityNotNull(){
//        assertTrue(Robolectric.buildActivity(MainActivity.class).create().get() != null);
//    }

    @Before
    public void setup() {
        super.setUp(MainActivity.class);
    }

    @Override
    protected void mockObjects(SampleApplication sampleApplication) {

    }

    @Override
    protected void obtainViewReferences() {

    }

    @Test
    public void checkActivityNotNull() throws Exception {
        assertNotNull(mActivity);
    }



}
