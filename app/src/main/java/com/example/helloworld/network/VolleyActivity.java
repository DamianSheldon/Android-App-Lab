package com.example.helloworld.network;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.helloworld.BaseActivity;
import com.example.helloworld.R;

import org.json.JSONObject;

public class VolleyActivity extends BaseActivity {

    TextView mTxtDisplay;
    ImageView mImageView;

    String url = "https://www.metaweather.com/api/location/2487956/";

    JsonObjectRequest jsObjRequest = new JsonObjectRequest
            (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    mTxtDisplay.setText("Response: " + response.toString());
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    mTxtDisplay.setText("Error: " + error.toString());
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        mTxtDisplay = (TextView) findViewById(R.id.result_text_view);
    }

    @Override
    protected void onResume() {
        super.onResume();

        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsObjRequest);
    }
}
