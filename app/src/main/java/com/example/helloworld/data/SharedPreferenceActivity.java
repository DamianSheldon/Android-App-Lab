package com.example.helloworld.data;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import com.example.helloworld.BaseActivity;
import com.example.helloworld.R;

public class SharedPreferenceActivity extends BaseActivity {
    public static final String PREFS_NAME = "MyPrefsFile";

    private final String SILENTMODEKEY = "silentMode";

    private boolean mSilentMode;

    private ToggleButton mToggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        // Restore preferences
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        mSilentMode = settings.getBoolean(SILENTMODEKEY, false);

        mToggleButton = (ToggleButton) findViewById(R.id.silent_mode_toggle_button);
        mToggleButton.setChecked(mSilentMode);
    }

    @Override
    protected void onStop() {
        super.onStop();

        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(SILENTMODEKEY, mSilentMode);

        // Commit the edits!
        editor.commit();
    }

    public void toggleSilentMode(View view) {
        mSilentMode = mToggleButton.isChecked();
    }
}
