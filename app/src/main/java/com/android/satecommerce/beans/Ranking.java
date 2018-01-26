package com.android.satecommerce.beans;

/**
 * Created by SACHIN MUTTHE on 26-01-2018.
 */

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ranking implements Serializable
{

    @SerializedName("ranking")
    @Expose
    private String ranking;
    @SerializedName("products")
    @Expose
    private List<Product_> products = null;
    private final static long serialVersionUID = 7302006726267774827L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Ranking() {
    }

    /**
     *
     * @param products
     * @param ranking
     */
    public Ranking(String ranking, List<Product_> products) {
        super();
        this.ranking = ranking;
        this.products = products;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public List<Product_> getProducts() {
        return products;
    }

    public void setProducts(List<Product_> products) {
        this.products = products;
    }

}
