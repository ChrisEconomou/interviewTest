package com.chriseconomou.depop.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Header {

    @Expose
    @SerializedName("following_count")
    public Integer followingCount;

    @Expose
    @SerializedName("followers_count")
    public Integer followersCount;

    @Expose
    @SerializedName("first_name")
    public String firstName;


    @Expose
    @SerializedName("last_name")
    public String lastName;

    @Expose
    @SerializedName("seller_ratings")
    public String sellerRatings;

    @Expose
    @SerializedName("rating")
    public Float rating;


    @Expose
    @SerializedName("picture")
    public String picture;

}
