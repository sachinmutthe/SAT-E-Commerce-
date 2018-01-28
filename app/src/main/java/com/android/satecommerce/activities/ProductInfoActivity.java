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
import com.android.satecommerce.adapters.ProductInfoAdapter;
import com.android.satecommerce.holders.ProductsInfoHolder;
import com.android.satecommerce.model.DataService;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by SACHIN MUTTHE on 27-01-2018.
 */

public class ProductInfoActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.text_view_toolbar_title)
    TextView text_view_toolbar_title;
    @Bind(R.id.recycler_view_products_variants)
    RecyclerView recycler_view_products_variants;
    ProductInfoAdapter productInfoAdapter;
    @Bind(R.id.text_view_product_name)
    TextView text_view_product_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_info_activity);
        ButterKnife.bind(this);

        text_view_toolbar_title.setText("Product Info");

        initToolBar();

        text_view_product_name.setText(getIntent().getStringExtra("product_name"));

        productInfoAdapter = new ProductInfoAdapter(ProductInfoActivity.this, DataService.getProductByProductId(getIntent().getIntExtra("product_id", 0)).getVariants());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(ProductInfoActivity.this, 2);
        recycler_view_products_variants.setLayoutManager(mLayoutManager);
        recycler_view_products_variants.setAdapter(productInfoAdapter);
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
