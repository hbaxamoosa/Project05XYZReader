package com.example.xyzreader.application;

import android.app.Application;
import android.content.Context;

import com.example.xyzreader.BuildConfig;
import com.facebook.stetho.Stetho;

import timber.log.Timber;

public class XYZReaderApplication extends Application {

    private static Context context;

    public static Context getAppContext() {
        return XYZReaderApplication.context;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        XYZReaderApplication.context = getApplicationContext();

        //Including Jake Wharton's Timber logging library
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            Timber.v("Timber.plant(new Timber.DebugTree());");
        } else {
            // Timber.plant(new CrashReportingTree());
        }

        // Facebook Stetho
        Stetho.initializeWithDefaults(this);
    }
}