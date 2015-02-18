package com.chriseconomou.depop.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by oikonomouc on 13/02/2015.
 */
public class HeaderResponse {

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

    @Expose
    @SerializedName("bio")
    public String bio;

    @Expose
    @SerializedName("website")
    public String website;
}
