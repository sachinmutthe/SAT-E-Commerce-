package com.android.satecommerce.model;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;

import com.android.satecommerce.beans.Category;
import com.android.satecommerce.beans.Product;
import com.android.satecommerce.beans.Product_;
import com.android.satecommerce.beans.Ranking;
import com.android.satecommerce.beans.ResponseServerData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SACHIN MUTTHE on 26-01-2018.
 */

public class DataService {

    public static ResponseServerData responseServerData = null;

    public static ResponseServerData getResponseServerData() {
        return responseServerData;
    }

    public static void setResponseServerData(ResponseServerData responseServerData) {
        DataService.responseServerData = responseServerData;
    }

    public static List<Product> getProductByCategoryId(int categoryId) {
        List<Product> productList = new ArrayList<>();

        for (Category category : responseServerData.getCategories()) {
            if (category.getId() == categoryId) {
                productList.addAll(category.getProducts());
            }
        }
        return productList;
    }

    public static Product getProductByProductId(int product_id) {
        Product product = null;

        for (Category category : responseServerData.getCategories()) {
            for (Product product1 : category.getProducts()) {
                if (product1.getId() == product_id)
                    return product1;
            }
        }
        return product;
    }


    public static List<Product_> getMostViewedProducts() {
        List<Product_> productList = new ArrayList<>();
        productList.addAll(responseServerData.getRankings().get(0).getProducts());
        return productList;
    }

    public static List<Product_> getMostOrderedProducts() {
        List<Product_> productList = new ArrayList<>();
        productList.addAll(responseServerData.getRankings().get(1).getProducts());
        return productList;
    }

    public static List<Product_> getMostSharedProducts() {
        List<Product_> productList = new ArrayList<>();
        productList.addAll(responseServerData.getRankings().get(2).getProducts());
        return productList;
    }

    public static SpannableString getBoldFormatedText(String boldText, String normalText) {
        SpannableString str = new SpannableString(boldText + normalText);
        str.setSpan(new StyleSpan(Typeface.BOLD), 0, boldText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return str;
    }
}
