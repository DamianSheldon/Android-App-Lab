package com.example.helloworld.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.example.helloworld.BaseActivity;
import com.example.helloworld.R;

public class RelativeLayoutCodeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setPadding(getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin), getResources().getDimensionPixelSize(R.dimen.activity_vertical_margin), getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin), getResources().getDimensionPixelSize(R.dimen.activity_vertical_margin));

        // Reminder edit text
        EditText reminderEditText = reminderEditText();
        RelativeLayout.LayoutParams editTextLayoutParams = editTextLayoutParams();

        relativeLayout.addView(reminderEditText, editTextLayoutParams);

        // Dates spinner
        Spinner datesSpinner = new Spinner(this);
        RelativeLayout.LayoutParams datesSpinnerLayoutParams = new RelativeLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
        datesSpinnerLayoutParams.addRule(RelativeLayout.BELOW, R.id.name);
        datesSpinnerLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        datesSpinnerLayoutParams.addRule(RelativeLayout.LEFT_OF, R.id.times);

        relativeLayout.addView(datesSpinner, datesSpinnerLayoutParams);

        // Times spinner
        Spinner timesSpinner = new Spinner(this);
        timesSpinner.setId(R.id.times);

        RelativeLayout.LayoutParams timesSpinnerLayoutParams = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.times_spinner_width), ViewGroup.LayoutParams.WRAP_CONTENT);
        timesSpinnerLayoutParams.addRule(RelativeLayout.BELOW, R.id.name);
        timesSpinnerLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        relativeLayout.addView(timesSpinner, timesSpinnerLayoutParams);

        // Done button
        Button doneButton = new Button(this);
        doneButton.setText(getString(R.string.done));

        RelativeLayout.LayoutParams doneButtonLayoutParams = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.done_button_width), ViewGroup.LayoutParams.WRAP_CONTENT);
        doneButtonLayoutParams.addRule(RelativeLayout.BELOW, R.id.times);
        doneButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        relativeLayout.addView(doneButton, doneButtonLayoutParams);

        setContentView(relativeLayout);
    }

    private EditText reminderEditText() {
        EditText editText = new EditText(this);
        editText.setHint(getString(R.string.reminder));
        editText.setId(R.id.name);
        return editText;
    }

    private RelativeLayout.LayoutParams editTextLayoutParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        return layoutParams;
    }

}
