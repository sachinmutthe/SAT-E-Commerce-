package com.android.satecommerce.activities;

import android.app.ProgressDialog;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.android.satecommerce.R;
import com.android.satecommerce.adapters.CategoryAdapter;
import com.android.satecommerce.beans.Category;
import com.android.satecommerce.beans.Product;
import com.android.satecommerce.beans.ResponseServerData;
import com.android.satecommerce.model.DataService;
import com.google.gson.Gson;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DEBUG";
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.text_view_toolbar_title)
    TextView text_view_toolbar_title;
    ProgressDialog pDialog;
    static OkHttpClient client = new OkHttpClient();
    Gson gson = new Gson();
    CategoryAdapter categoryAdapter;
    private LinearLayoutManager mLayoutManager;
    @Bind(R.id.recycler_view_categories)
    RecyclerView recycler_view_categories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        text_view_toolbar_title.setText("E-Commerce App");

        getDataFromServer();
    }

    private void getDataFromServer() {

        try {
            pDialog = ProgressDialog.show(MainActivity.this, "", "Getting data from server..", false, false);
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            String response = MainActivity.run("https://stark-spire-93433.herokuapp.com/json");
            Log.d(TAG, "getDataFromServer: " + response);

            pDialog.dismiss();
            ResponseServerData responseServerData = gson.fromJson(response, ResponseServerData.class);

            for (Category category : responseServerData.getCategories()) {
                Log.d(TAG, "Category Names : " + category.getName());
            }

            DataService.setResponseServerData(responseServerData);

            categoryAdapter = new CategoryAdapter(MainActivity.this, DataService.getResponseServerData().getCategories());
            mLayoutManager = new GridLayoutManager(MainActivity.this, 3);
            recycler_view_categories.setLayoutManager(mLayoutManager);
            recycler_view_categories.setAdapter(categoryAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static String run(String url) {
        String strResponse = "";
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Response response = client.newCall(request).execute();
            strResponse = response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strResponse;
    }
}
