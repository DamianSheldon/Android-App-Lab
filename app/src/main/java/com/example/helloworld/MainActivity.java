package com.example.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    int [] mTabResIds = {R.string.tab_bar_layout, R.string.tab_bar_control, R.string.tab_bar_data, R.string.tab_bar_network};

    HashMap<Integer, Integer> mResIdToLayoutIdMap = new HashMap<>();
    HashMap<Integer, Integer> mResIdToViewIdMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Map resId to layoutId
        mResIdToLayoutIdMap.put(R.string.tab_bar_layout, R.layout.fragment_layout);
        mResIdToLayoutIdMap.put(R.string.tab_bar_control, R.layout.fragment_control);
        mResIdToLayoutIdMap.put(R.string.tab_bar_data, R.layout.fragment_data);
        mResIdToLayoutIdMap.put(R.string.tab_bar_network, R.layout.fragment_network);

        // Map resId to view id
        mResIdToViewIdMap.put(R.string.tab_bar_layout, R.id.layout);
        mResIdToViewIdMap.put(R.string.tab_bar_control, R.id.control);
        mResIdToViewIdMap.put(R.string.tab_bar_data, R.id.data);
        mResIdToViewIdMap.put(R.string.tab_bar_network, R.id.network);

        // Set up tab host
        setUpTabHost();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void setUpTabHost() {
        TabHost tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup();

        for (int resId : mTabResIds) {
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(getString(resId));

            tabSpec.setContent(mResIdToViewIdMap.get(resId));
            tabSpec.setIndicator(getString(resId));
            tabHost.addTab(tabSpec);
        }

        tabHost.setCurrentTabByTag(getString(R.string.tab_bar_layout));
    }
}
