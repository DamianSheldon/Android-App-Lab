package com.example.helloworld.control;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.helloworld.BaseActivity;
import com.example.helloworld.R;

public class ToggleButtonActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);

        ToggleButton toggle = (ToggleButton) findViewById(R.id.togglebutton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    Toast.makeText(ToggleButtonActivity.this, "The toggle is enabled", Toast.LENGTH_LONG).show();
                } else {
                    // The toggle is disabled
                    Toast.makeText(ToggleButtonActivity.this, "The toggle is disabled", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
