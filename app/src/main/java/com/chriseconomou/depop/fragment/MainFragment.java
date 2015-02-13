package com.chriseconomou.depop.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.chriseconomou.depop.R;
import com.chriseconomou.depop.adapter.ProductsViewpagerAdapter;
import com.chriseconomou.depop.controllers.GetProductsListener;
import com.chriseconomou.depop.controllers.GetUserDetailsListener;
import com.chriseconomou.depop.data.HeaderResponse;
import com.chriseconomou.depop.data.Product;
import com.chriseconomou.depop.data.ProductsResponse;
import com.chriseconomou.depop.util.MockDataUtils;
import com.viewpagerindicator.UnderlinePageIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;


public class MainFragment extends BaseFragment implements GetProductsListener, GetUserDetailsListener {

    public static String TAG = MainFragment.class.getSimpleName();
    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    //    @InjectView(R.id.header_image_profile)
//    ImageView mImageProfile;
//    @InjectView(R.id.header_text_name)
//    TextView mTextName;
//    @InjectView(R.id.header_text_following_value)
//    TextView mTextFollowingValue;
//    @InjectView(R.id.header_text_following)
//    TextView mTextFollowing;
//    @InjectView(R.id.header_text_followers_value)
//    TextView mTextFollowersValue;
//    @InjectView(R.id.header_text_followers)
//    TextView mTextFollowers;
//    @InjectView(R.id.header_text_reviews)
//    TextView mHeaderTextReviews;
//    @InjectView(R.id.header_text_description)
//    TextView mHeaderTextDescription;
//    @InjectView(R.id.header_text_url)
//    TextView mHeaderTextUrl;
//    @InjectView(R.id.products_image)
//    RelativeLayout mProductsImage;
    @InjectView(R.id.indicator)
    UnderlinePageIndicator mIndicator;
    @InjectView(R.id.viewpager)
    ViewPager mViewpager;

    private ProductsViewpagerAdapter mProductsViewpagerAdapter;
    private List<Product> mSellingProducts = new ArrayList<Product>();
    private List<Product> mLikedProducts = new ArrayList<Product>();

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initializeViews(Bundle savedInstanceState) {
//        mProductsViewpagerAdapter = new ProductsViewpagerAdapter(getActivity(), mSellingProducts, mLikedProducts, new String[]{"SELLING", "LIKED"});
//        mViewpager.setAdapter(mProductsViewpagerAdapter);
//        mIndicator.setViewPager(mViewpager);

        onGetProductsSuccesful(MockDataUtils.getCategoriesMenResponse(getActivity()));
    }

    @Override
    public void onGetProductsError(Throwable throwable) {
        //handle error
    }

    @Override
    public void onGetProductsSuccesful(ProductsResponse productsResponse) {
        mProductsViewpagerAdapter = new ProductsViewpagerAdapter(getActivity(), productsResponse.selling, productsResponse.liked, new String[]{"SELLING", "LIKED"});
        mViewpager.setAdapter(mProductsViewpagerAdapter);
        mIndicator.setViewPager(mViewpager);
    }

    @Override
    public void onGetUserDetailsError(Throwable throwable) {

    }

    @Override
    public void onGetUserDetailsSuccesful(HeaderResponse categoriesResponse) {

    }

    @Override
    public void onEnd() {

    }
}
