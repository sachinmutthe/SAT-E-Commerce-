package com.android.satecommerce.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.satecommerce.R;

/**
 * Created by SACHIN MUTTHE on 26-01-2018.
 */

public class ProductsInfoHolder extends RecyclerView.ViewHolder {

    public TextView text_view_product_color, text_view_product_size,
            text_view_product_price;

    public ProductsInfoHolder(View itemView) {
        super(itemView);

        text_view_product_color = itemView.findViewById(R.id.text_view_product_color);
        text_view_product_size = itemView.findViewById(R.id.text_view_product_size);
        text_view_product_price = itemView.findViewById(R.id.text_view_product_price);
    }
}
