package com.chriseconomou.depop.controllers;


import com.chriseconomou.depop.data.ProductsResponse;

public interface GetProductsListener extends BaseListener {

    void onGetProductsError(Throwable throwable);

	void onGetProductsSuccesful(ProductsResponse productsResponse);
}