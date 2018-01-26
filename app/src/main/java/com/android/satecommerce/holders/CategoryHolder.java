package com.android.satecommerce.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.satecommerce.R;

/**
 * Created by SACHIN MUTTHE on 26-01-2018.
 */

public class CategoryHolder extends RecyclerView.ViewHolder {

    public TextView text_view_category_name;

    public CategoryHolder(View itemView) {
        super(itemView);

        text_view_category_name = itemView.findViewById(R.id.text_view_category_name);
    }
}
