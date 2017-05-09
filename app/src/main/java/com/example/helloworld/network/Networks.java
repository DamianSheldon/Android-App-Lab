package com.example.helloworld.network;

/**
 * Created by meiliang on 06/05/2017.
 */

public enum Networks {
    HttpsURLConnection, Volley, Settings;

    @Override
    public String toString() {
        return this.name();
    }

    public Class<?> mappedClass() {
        Class<?> mappedClass = null;

        switch (this) {
            case HttpsURLConnection:
                mappedClass = NetworkActivity.class;
                break;

            case Settings:
                mappedClass = SettingsActivity.class;
                break;
        }

        return mappedClass;
    }
}
