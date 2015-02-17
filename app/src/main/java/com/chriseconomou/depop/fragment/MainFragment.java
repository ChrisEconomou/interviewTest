package com.chriseconomou.depop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chriseconomou.depop.R;
import com.chriseconomou.depop.adapter.ProductsViewpagerAdapter;
import com.chriseconomou.depop.controllers.GetProductsListener;
import com.chriseconomou.depop.controllers.GetUserDetailsListener;
import com.chriseconomou.depop.data.HeaderResponse;
import com.chriseconomou.depop.data.Product;
import com.chriseconomou.depop.data.ProductsResponse;
import com.chriseconomou.depop.util.MockDataUtils;
import com.chriseconomou.depop.view.RoundedImageView;
import com.squareup.picasso.Picasso;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;


public class MainFragment extends BaseFragment implements GetProductsListener, GetUserDetailsListener {

    public static String TAG = MainFragment.class.getSimpleName();

    @InjectView(R.id.header_image_profile)
    RoundedImageView mImageProfile;
    @InjectView(R.id.header_text_name)
    TextView mTextName;
    @InjectView(R.id.header_text_following_value)
    TextView mTextFollowingValue;

    @InjectView(R.id.header_text_followers_value)
    TextView mTextFollowersValue;

    @InjectView(R.id.header_text_reviews)
    TextView mHeaderTextReviews;
    @InjectView(R.id.header_text_description)
    TextView mHeaderTextDescription;
    @InjectView(R.id.header_text_url)
    TextView mHeaderTextUrl;
    @InjectView(R.id.products_image)
    ViewGroup mProductsImage;
    @InjectView(R.id.indicator)
    TabPageIndicator mIndicator;
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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeViews(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initializeViews(Bundle savedInstanceState) {

        onGetUserDetailsSuccesful(MockDataUtils.getHeaderResponse(getActivity()));
        onGetProductsSuccesful(MockDataUtils.getCategoriesMenResponse(getActivity()));

    }

    @Override
    public void onGetProductsError(Throwable throwable) {
        //handle error
    }

    @Override
    public void onGetProductsSuccesful(ProductsResponse productsResponse) {
        mProductsViewpagerAdapter = new ProductsViewpagerAdapter(getActivity(), productsResponse.selling, productsResponse.liked, new String[]{"SELLING", "LIKED"});
        setViewPagerHeight(productsResponse.selling.size() >= productsResponse.liked.size() ? productsResponse.selling.size() : productsResponse.liked.size());
        mViewpager.setAdapter(mProductsViewpagerAdapter);
        mIndicator.setViewPager(mViewpager);
    }

    @Override
    public void onGetUserDetailsError(Throwable throwable) {

    }

    @Override
    public void onGetUserDetailsSuccesful(HeaderResponse headerResponse) {
        populateHeaderData(headerResponse);
    }

    @Override
    public void onEnd() {

    }

    private void setViewPagerHeight(int listSize) {
        int rowCount = getRowCount(mProductsViewpagerAdapter.getSpanCount(), listSize);
        int height = rowCount * (int) getResources().getDimension(R.dimen.product_image_height);
        ViewGroup.LayoutParams layoutParams = mViewpager.getLayoutParams();
        layoutParams.height = height;
        mViewpager.setLayoutParams(layoutParams);

    }

    private int getRowCount(int columnCount, int listSize) {

        return (listSize % columnCount == 0 ? listSize / columnCount : listSize / columnCount + 1);
    }

    private void populateHeaderData(HeaderResponse headerResponse) {
        if (headerResponse.picture != null) {
            Picasso.with(getActivity()).load(headerResponse.picture).into(mImageProfile);
        }
        mTextName.setText(headerResponse.firstName + " " + headerResponse.lastName);
        mTextFollowingValue.setText(headerResponse.followingCount);
        mTextFollowersValue.setText(headerResponse.followersCount);
    }
}
