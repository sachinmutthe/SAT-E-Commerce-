package com.android.satecommerce.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.satecommerce.R;
import com.android.satecommerce.adapters.ProductAdapter;
import com.android.satecommerce.model.DataService;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by SACHIN MUTTHE on 26-01-2018.
 */

public class ProductsActivity extends AppCompatActivity {

    private static final String TAG = "DEBUG";
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.text_view_toolbar_title)
    TextView text_view_toolbar_title;
    @Bind(R.id.recycler_view_products)
    RecyclerView recycler_view_products;
    ProductAdapter productAdapter;
    int categoryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_activity);
        ButterKnife.bind(this);

        text_view_toolbar_title.setText(getIntent().getStringExtra("category_name"));

        initToolBar();
        categoryId = getIntent().getIntExtra("category_id", 1);

        productAdapter = new ProductAdapter(ProductsActivity.this, DataService.getProductByCategoryId(categoryId));
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(ProductsActivity.this, 2);
        recycler_view_products.setLayoutManager(mLayoutManager);
        recycler_view_products.setAdapter(productAdapter);
    }

    private void initToolBar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_keyboard_arrow_left_white);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish(); // close this activity and return to preview activity (if there is any)
        }
        return true;
    }
}
