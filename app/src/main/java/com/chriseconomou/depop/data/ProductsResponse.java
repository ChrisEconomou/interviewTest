package com.chriseconomou.depop.data;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;


public class ProductsResponse {

    @Expose
    public List<Product> selling = new ArrayList<Product>();

    @Expose
    public List<Product> liked = new ArrayList<Product>();

}
