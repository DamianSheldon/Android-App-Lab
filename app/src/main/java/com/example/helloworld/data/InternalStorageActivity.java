package com.example.helloworld.data;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.helloworld.BaseActivity;
import com.example.helloworld.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class InternalStorageActivity extends BaseActivity {

    private final String FILENAME = "hello_file";

    private StringBuilder mStringBuilder = new StringBuilder();

    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);

        mEditText = (EditText) findViewById(R.id.internal_edit_text);

        try {
            FileInputStream fileInputStream = openFileInput(FILENAME);

            Reader ir = new InputStreamReader(fileInputStream);
            BufferedReader in = new BufferedReader( ir );
            String line;

            while ((line = in.readLine()) != null) {
                mStringBuilder.append(line);
            }

            mEditText.setText(mStringBuilder.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onStop() {
        super.onStop();

        persistentUserInputText();
    }

    public void saveToInternalStorage(View view) {
        persistentUserInputText();
    }

    private void persistentUserInputText() {
        try {
            FileOutputStream fileOutputStream = openFileOutput(FILENAME, Context.MODE_PRIVATE);

            Writer writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

            writer.write(mEditText.getText().toString());

            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
