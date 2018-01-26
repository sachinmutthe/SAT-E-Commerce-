package com.android.satecommerce.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.satecommerce.R;

/**
 * Created by SACHIN MUTTHE on 26-01-2018.
 */

public class ProductsHolder extends RecyclerView.ViewHolder {

    public TextView text_view_product_name,text_view_product_color,text_view_product_size,
            text_view_product_price,text_view_product_variant;
    public LinearLayout linear_layout_product;

    public ProductsHolder(View itemView) {
        super(itemView);

        text_view_product_name = itemView.findViewById(R.id.text_view_product_name);
        text_view_product_color = itemView.findViewById(R.id.text_view_product_color);
        text_view_product_size  =itemView.findViewById(R.id.text_view_product_size);
        text_view_product_price  =itemView.findViewById(R.id.text_view_product_price);
        text_view_product_variant = itemView.findViewById(R.id.text_view_product_variant);
        linear_layout_product = itemView.findViewById(R.id.linear_layout_product);
    }
}
