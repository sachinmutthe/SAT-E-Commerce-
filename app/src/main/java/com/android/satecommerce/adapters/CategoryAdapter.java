package com.android.satecommerce.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.satecommerce.R;
import com.android.satecommerce.activities.ProductsActivity;
import com.android.satecommerce.beans.Category;
import com.android.satecommerce.holders.CategoryHolder;

import java.util.Collections;
import java.util.List;

/**
 * Created by SACHIN MUTTHE on 26-01-2018.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryHolder> {

    private LayoutInflater infilator;
    List<Category> data = Collections.emptyList();
    Context mContext;

    public CategoryAdapter(Context mContext, List<Category> data) {
        infilator = LayoutInflater.from(mContext);
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = infilator.inflate(R.layout.category_single_row_item, parent, false);
        CategoryHolder categoryHolder = new CategoryHolder(view);
        return categoryHolder;
    }

    @Override
    public void onBindViewHolder(CategoryHolder holder, int position) {
        final Category current = data.get(position);
        holder.text_view_category_name.setText("" + current.getName());
        holder.text_view_category_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent productIntent = new Intent(mContext, ProductsActivity.class);
                productIntent.putExtra("category_id",current.getId());
                productIntent.putExtra("category_name",current.getName());
                mContext.startActivity(productIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
