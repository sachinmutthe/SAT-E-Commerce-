package com.android.satecommerce.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.satecommerce.R;
import com.android.satecommerce.activities.ProductInfoActivity;
import com.android.satecommerce.activities.ProductsActivity;
import com.android.satecommerce.beans.Category;
import com.android.satecommerce.beans.Product;
import com.android.satecommerce.holders.CategoryHolder;
import com.android.satecommerce.holders.ProductsHolder;
import com.android.satecommerce.model.DataService;

import java.util.Collections;
import java.util.List;

/**
 * Created by SACHIN MUTTHE on 26-01-2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductsHolder> {

    private LayoutInflater infilator;
    List<Product> data = Collections.emptyList();
    Context mContext;

    public ProductAdapter(Context mContext, List<Product> data) {
        infilator = LayoutInflater.from(mContext);
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public ProductsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = infilator.inflate(R.layout.product_single_row_item, parent, false);
        ProductsHolder productsHolder = new ProductsHolder(view);
        return productsHolder;
    }

    @Override
    public void onBindViewHolder(ProductsHolder holder, int position) {
        final Product current = data.get(position);
        holder.text_view_product_name.setText("" + current.getName());
        holder.text_view_product_color.setText(DataService.getBoldFormatedText("Color : ", current.getVariants().get(0).getColor()));

        if (current.getVariants().get(0).getSize() == null) {
            holder.text_view_product_size.setVisibility(View.GONE);
        }

        holder.text_view_product_size.setText(DataService.getBoldFormatedText("Size : ", String.valueOf(current.getVariants().get(0).getSize())));
        holder.text_view_product_price.setText(DataService.getBoldFormatedText("Price : ₹ ", String.valueOf(current.getVariants().get(0).getPrice())));
        holder.text_view_product_variant.setText(DataService.getBoldFormatedText("Variants : ", String.valueOf(current.getVariants().size())));


        holder.linear_layout_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent productIntent = new Intent(mContext, ProductInfoActivity.class);
                productIntent.putExtra("product_id", current.getId());
                productIntent.putExtra("product_name", current.getName());
                mContext.startActivity(productIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
