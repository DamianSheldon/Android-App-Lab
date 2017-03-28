package com.example.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class LinearLayoutCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding(getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin), getResources().getDimensionPixelSize(R.dimen.activity_vertical_margin), getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin), getResources().getDimensionPixelSize(R.dimen.activity_vertical_margin));
        // To edit text
        EditText toEditText = editTextWithHint(getString(R.string.to));
        LinearLayout.LayoutParams toEditTextParams = widthMatchParentHeightWrapContentEditTextParams();

        linearLayout.addView(toEditText, toEditTextParams);

        // Subject edit text
        EditText subjectEditText = editTextWithHint(getString(R.string.subject));
        LinearLayout.LayoutParams subjectEditTextParams = widthMatchParentHeightWrapContentEditTextParams();

        linearLayout.addView(subjectEditText, subjectEditTextParams);

        // Message edit text
        EditText messageEditText = editTextWithHint(getString(R.string.message));
        messageEditText.setGravity(Gravity.TOP);

        LinearLayout.LayoutParams messageEditTextParams = messageEditTextParams();

        linearLayout.addView(messageEditText, messageEditTextParams);

        // Send button
        Button sendButton = sendButton();
        LinearLayout.LayoutParams sendButtonParams = sendButtonParams();

        linearLayout.addView(sendButton, sendButtonParams);

        setContentView(linearLayout);
    }

    private EditText editTextWithHint(CharSequence hint) {
        EditText editText = new EditText(this);
        editText.setHint(hint);

        return editText;
    }

    private LinearLayout.LayoutParams widthMatchParentHeightWrapContentEditTextParams () {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        return params;
    }

    private LinearLayout.LayoutParams messageEditTextParams () {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0);
        params.weight = 1;

        return params;
    }

    private Button sendButton() {
        Button button = new Button(this);
        button.setText(getString(R.string.send));

        return button;
    }

    private LinearLayout.LayoutParams sendButtonParams() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.RIGHT;

        return params;
    }
}
