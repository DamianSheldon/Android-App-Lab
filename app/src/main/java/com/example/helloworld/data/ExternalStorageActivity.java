package com.example.helloworld.data;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.helloworld.BaseActivity;
import com.example.helloworld.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.UUID;

public class ExternalStorageActivity extends BaseActivity {
    private final String TAG = "ExternalStorageActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);
    }


    public void saveToExternalStorage(View view) {
        if (isExternalStorageWritable()) {
            File[] files = ContextCompat.getExternalFilesDirs(this, Environment.DIRECTORY_PICTURES);
            if (files.length > 0) {
                File file = files[0];

                try {
                    InputStream inputStream = getResources().openRawResource(R.raw.lake);

                    Reader ir = new InputStreamReader(inputStream);
                    BufferedReader in = new BufferedReader( ir );
                    String line;
                    StringBuilder stringBuilder = new StringBuilder();

                    while ((line = in.readLine()) != null) {
                        stringBuilder.append(line);
                    }

                    inputStream.close();

                    Log.d(TAG, file.getAbsolutePath() + "/lake.jpg");

                    FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsoluteFile() + "/lake.jpg");

                    fileOutputStream.write(stringBuilder.toString().getBytes());

                    fileOutputStream.close();

                    Toast.makeText(this, R.string.save_successfully_message, Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                } catch (IOException e) {
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
            else {
                Toast.makeText(this, R.string.external_storage_no_picture_directory_message, Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this, R.string.external_storage_cannot_write_message, Toast.LENGTH_LONG).show();
        }
    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
}
