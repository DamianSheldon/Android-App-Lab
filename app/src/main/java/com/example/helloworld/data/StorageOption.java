package com.example.helloworld.data;

/**
 * Created by meiliang on 13/05/2017.
 */

public enum StorageOption {
    SharedPreferences, InternalStorage, ExternalStorage, SQLiteDatabase, GreenDAO;

    @Override
    public String toString() {
        return this.name();
    }

    public Class<?> mappedClass() {
        Class<?> mappedClass = null;

        switch (this) {
            case SharedPreferences:
                mappedClass = SharedPreferenceActivity.class;
                break;
        }

        return mappedClass;
    }
}
