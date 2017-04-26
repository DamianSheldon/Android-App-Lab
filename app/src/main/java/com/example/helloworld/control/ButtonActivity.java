package com.example.helloworld.control;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.helloworld.BaseActivity;
import com.example.helloworld.R;

public class ButtonActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
    }

    public void sendMessage(View view) {
        Toast.makeText(this, getString(R.string.button_greet_message), Toast.LENGTH_LONG).show();
    }
}
