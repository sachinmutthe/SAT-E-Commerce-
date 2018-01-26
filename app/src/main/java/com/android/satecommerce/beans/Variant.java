package com.android.satecommerce.beans;

/**
 * Created by SACHIN MUTTHE on 26-01-2018.
 */

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Variant implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("size")
    @Expose
    private Object size;
    @SerializedName("price")
    @Expose
    private Integer price;
    private final static long serialVersionUID = -267162487859470763L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Variant() {
    }

    /**
     *
     * @param id
     * @param price
     * @param color
     * @param size
     */
    public Variant(Integer id, String color, Object size, Integer price) {
        super();
        this.id = id;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Object getSize() {
        return size;
    }

    public void setSize(Object size) {
        this.size = size;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}