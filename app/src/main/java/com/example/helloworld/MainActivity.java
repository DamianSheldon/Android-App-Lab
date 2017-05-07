package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.helloworld.control.Controls;
import com.example.helloworld.layout.Layouts;
import com.example.helloworld.network.Networks;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    int [] mTabResIds = {R.string.tab_bar_layout, R.string.tab_bar_control, R.string.tab_bar_data, R.string.tab_bar_network};

    HashMap<Integer, Integer> mResIdToLayoutIdMap = new HashMap<>();
    HashMap<Integer, Integer> mResIdToViewIdMap = new HashMap<>();
    HashMap<Integer, Integer> mResIdToMenuDrawableId = new HashMap<>();

    // List views
    private ListView mLayoutListView;
    private ListView mControlListView;
    private ListView mNetworkListView;

    // Android supported layouts: Linear Layout, Relative Layout, TableLayout, FragmentLayout,
    // ConstraintLayout, GridLayout
    private Layouts[] mLayouts = Layouts.values();

    // Android builtin controls
    private Controls[] mControls = Controls.values();

    // Android support network methods
    private Networks[] mNetworks = Networks.values();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Populate basic data
        populateBasicData();

        // Set up tab host
        setUpTabHost();

        // Set up layout list view
        setUpLayoutListView();

        // Set up control list view
        setUpControlListView();

        setUpNetworkListView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void populateBasicData() {
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

        mResIdToMenuDrawableId.put(R.string.tab_bar_layout, android.R.drawable.ic_menu_add);
        mResIdToMenuDrawableId.put(R.string.tab_bar_control, android.R.drawable.ic_menu_agenda);
        mResIdToMenuDrawableId.put(R.string.tab_bar_data, android.R.drawable.ic_menu_call);
        mResIdToMenuDrawableId.put(R.string.tab_bar_network, android.R.drawable.ic_menu_camera);
    }

    private void setUpTabHost() {
        TabHost tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup();

        for (int resId : mTabResIds) {
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(getString(resId));

            tabSpec.setContent(mResIdToViewIdMap.get(resId));

            View tabBarItem = LayoutInflater.from(this).inflate(R.layout.tab_bar_item, null);

            TextView textView = (TextView) tabBarItem.findViewById(R.id.item_text_view);
            textView.setText(getString(resId));

            ImageView imageView = (ImageView) tabBarItem.findViewById(R.id.item_image_view);
            imageView.setImageResource(mResIdToMenuDrawableId.get(resId));

            tabSpec.setIndicator(tabBarItem);
            tabHost.addTab(tabSpec);
        }

        tabHost.setCurrentTabByTag(getString(R.string.tab_bar_layout));
    }

    private void setUpLayoutListView() {
        mLayoutListView = (ListView) findViewById(R.id.layout_list_view);
        mLayoutListView.setAdapter(new ArrayAdapter<Layouts>(this, android.R.layout.simple_list_item_1, mLayouts));
        mLayoutListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Class<?> cls = mLayouts[position].mappedClass();

                if (cls != null) {
                    Intent intent = new Intent(MainActivity.this, cls);
                    startActivity(intent);
                }
            }
        });
    }

    private void setUpControlListView() {
        mControlListView = (ListView) findViewById(R.id.control_list_view);
        mControlListView.setAdapter(new ArrayAdapter<Controls>(this, android.R.layout.simple_list_item_1, mControls));
        mControlListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Class<?> cls = mControls[position].mappedClass();

                if (cls != null) {
                    Intent intent = new Intent(MainActivity.this, cls);
                    startActivity(intent);
                }
            }
        });
    }

    private void setUpNetworkListView() {
        mNetworkListView =(ListView) findViewById(R.id.network_list_view);
        mNetworkListView.setAdapter(new ArrayAdapter<Networks>(this, android.R.layout.simple_list_item_1, mNetworks));
        mNetworkListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Class<?> cls = mNetworks[position].mappedClass();

                if (cls != null) {
                    Intent intent = new Intent(MainActivity.this, cls);
                    startActivity(intent);
                }
            }
        });
    }
}
