package  com.chriseconomou.depop.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chriseconomou.depop.application.SampleApplication;

import butterknife.ButterKnife;


/**
 * Base fragment, that has access to global instances, manages errors and token responses.
 */
public abstract class BaseFragment extends Fragment {



    private SampleApplication mSampleApplication;



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mSampleApplication = (SampleApplication) activity.getApplication();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.inject(this, rootView);
        return rootView;
    }


    protected abstract int getLayoutId();

    protected abstract void initializeViews(Bundle savedInstanceState);



    protected SampleApplication getApplication() {
        return mSampleApplication;
    }




}
