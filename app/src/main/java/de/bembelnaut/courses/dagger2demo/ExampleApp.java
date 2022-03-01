package de.bembelnaut.courses.dagger2demo;

import android.app.Application;

import de.bembelnaut.courses.dagger2demo.dagger.CarAppComponent;
import de.bembelnaut.courses.dagger2demo.dagger.DaggerCarAppComponent;

public class ExampleApp extends Application {

    private CarAppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        // Call component injection if no class injection available, like in an activity class.
        // If there are no Constructors with arguments this method can be used
        component = DaggerCarAppComponent.create();
    }

    public CarAppComponent getAppComponent() {
        return component;
    }

}
