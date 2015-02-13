package com.chriseconomou.depop.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chriseconomou.depop.R;
import com.chriseconomou.depop.data.Product;
import com.chriseconomou.depop.data.ProductsResponse;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class ProductsViewpagerAdapter extends PagerAdapter {

    private static final int COUNT = 2;

    private ProductsResponse mProductsResponse;

    private String[] mTitles;
    private Context mContext;
    private SparseArray<View> mViews = new SparseArray<>();
    private LayoutInflater mLayoutInflater;
    private List<Product> mSelling;
    private List<Product> mLiked;

    public ProductsViewpagerAdapter(Context context, List<Product> selling, List<Product> liked, String[] titles) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mSelling = selling;
        mLiked = liked;
        mTitles = titles;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View root = getView(position, container);
        container.addView(root);
        mViews.put(position, root);
        return root;
    }

    @Override
    public int getCount() {
        return COUNT;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    public View getView(int position, ViewGroup container) {
        View view = mLayoutInflater.inflate(R.layout.view_products, container, false);
        ViewHolder viewHolder = new ViewHolder(view);
        populateRecyclerView(viewHolder.mList, position == 0 ? mSelling : mLiked);
        return view;
    }


    private void populateRecyclerView(RecyclerView recyclerView, List<Product> products) {
        ProductsAdapter adapter = new ProductsAdapter(mContext, products);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
    }

    public class ViewHolder {

        @InjectView(R.id.list)
        RecyclerView mList;

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
