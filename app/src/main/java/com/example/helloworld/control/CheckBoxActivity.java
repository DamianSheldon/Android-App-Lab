package com.example.helloworld.control;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.helloworld.BaseActivity;
import com.example.helloworld.R;

public class CheckBoxActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_meat:
                // if (checked)
                // Put some meat on the sandwich
                // else
                // Remove the meat
                break;
            case R.id.checkbox_cheese:
                // if (checked)
                // Cheese me
                // else
                // I'm lactose intolerant
                break;
            // TODO: Veggie sandwich
        }
    }
}
