package com.android.satecommerce.beans;

/**
 * Created by SACHIN MUTTHE on 26-01-2018.
 */

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product_ implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("view_count")
    @Expose
    private Integer viewCount;
    @SerializedName("order_count")
    @Expose
    private Integer orderCount;
    @SerializedName("shares")
    @Expose
    private Integer shares;
    private final static long serialVersionUID = -3114699685274322054L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Product_() {
    }

    /**
     *
     * @param shares
     * @param id
     * @param orderCount
     * @param viewCount
     */
    public Product_(Integer id, Integer viewCount, Integer orderCount, Integer shares) {
        super();
        this.id = id;
        this.viewCount = viewCount;
        this.orderCount = orderCount;
        this.shares = shares;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getShares() {
        return shares;
    }

    public void setShares(Integer shares) {
        this.shares = shares;
    }

}