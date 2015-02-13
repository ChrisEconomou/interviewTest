package com.chriseconomou.depop.controllers;


import com.chriseconomou.depop.data.HeaderResponse;

public interface GetUserDetailsListener extends BaseListener {

    void onGetUserDetailsError(Throwable throwable);

	void onGetUserDetailsSuccesful(HeaderResponse categoriesResponse);
}