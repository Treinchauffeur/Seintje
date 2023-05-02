package org.treinchauffeur.seintje.ui;

import android.app.Application;

import com.google.android.material.color.DynamicColors;

public class SeintjeApplication extends Application {

    @Override
    public void onCreate() {
        DynamicColors.applyToActivitiesIfAvailable(this);
        super.onCreate();
    }

}
