package com.android.satecommerce.beans;

/**
 * Created by SACHIN MUTTHE on 26-01-2018.
 */

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tax implements Serializable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("value")
    @Expose
    private Double value;
    private final static long serialVersionUID = -8823971350437249880L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Tax() {
    }

    /**
     *
     * @param name
     * @param value
     */
    public Tax(String name, Double value) {
        super();
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

}
