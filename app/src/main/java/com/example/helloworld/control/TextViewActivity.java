package com.example.helloworld.control;

import android.os.Bundle;
import android.widget.TextView;

import com.example.helloworld.BaseActivity;
import com.example.helloworld.R;

public class TextViewActivity extends BaseActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        mTextView = (TextView) findViewById(R.id.text_view);
        mTextView.setText(getString(R.string.lorem_ipsum));
    }
}
