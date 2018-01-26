package com.android.satecommerce.beans;

/**
 * Created by SACHIN MUTTHE on 26-01-2018.
 */

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseServerData implements Serializable
{

    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("rankings")
    @Expose
    private List<Ranking> rankings = null;
    private final static long serialVersionUID = 7652978840011421158L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseServerData() {
    }

    /**
     *
     * @param rankings
     * @param categories
     */
    public ResponseServerData(List<Category> categories, List<Ranking> rankings) {
        super();
        this.categories = categories;
        this.rankings = rankings;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Ranking> getRankings() {
        return rankings;
    }

    public void setRankings(List<Ranking> rankings) {
        this.rankings = rankings;
    }

}