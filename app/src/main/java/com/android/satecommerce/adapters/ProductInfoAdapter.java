package com.android.satecommerce.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.satecommerce.R;
import com.android.satecommerce.activities.ProductInfoActivity;
import com.android.satecommerce.beans.Product;
import com.android.satecommerce.beans.Product_;
import com.android.satecommerce.beans.Variant;
import com.android.satecommerce.holders.ProductsHolder;
import com.android.satecommerce.holders.ProductsInfoHolder;
import com.android.satecommerce.model.DataService;

import java.util.Collections;
import java.util.List;

/**
 * Created by SACHIN MUTTHE on 26-01-2018.
 */

public class ProductInfoAdapter extends RecyclerView.Adapter<ProductsInfoHolder> {

    private LayoutInflater infilator;
    List<Variant> data = Collections.emptyList();
    Context mContext;

    public ProductInfoAdapter(Context mContext, List<Variant> data) {
        infilator = LayoutInflater.from(mContext);
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public ProductsInfoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = infilator.inflate(R.layout.product_info_single_row_item, parent, false);
        ProductsInfoHolder productsInfoHolder = new ProductsInfoHolder(view);
        return productsInfoHolder;
    }

    @Override
    public void onBindViewHolder(ProductsInfoHolder holder, int position) {
        final Variant current = data.get(position);
        holder.text_view_product_color.setText(DataService.getBoldFormatedText("Color : ", current.getColor()));

        if (current.getSize() == null) {
            holder.text_view_product_size.setVisibility(View.GONE);
        }

        holder.text_view_product_size.setText(DataService.getBoldFormatedText("Size : ", String.valueOf(current.getSize())));
        holder.text_view_product_price.setText(DataService.getBoldFormatedText("Price : ₹ ", String.valueOf(current.getPrice())));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
