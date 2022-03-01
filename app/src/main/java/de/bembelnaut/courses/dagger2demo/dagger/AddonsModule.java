package de.bembelnaut.courses.dagger2demo.dagger;

import android.util.Log;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import de.bembelnaut.courses.dagger2demo.car.Car;
import de.bembelnaut.courses.dagger2demo.thirdparty.Driver;
import de.bembelnaut.courses.dagger2demo.thirdparty.GiveAway;

@Module
public abstract class AddonsModule {
    private static final String TAG = "Car";

    // Driver instance only injected, because CarFragmentComponent is a sub component.
    // Dependencies over to components does not work, because the parent component needs to
    // define provision methods to the child components.
    @Provides
    @PerFragment
    static GiveAway provideGiveAway(Car car, Driver driver,
                                    @Named("app name") String appName,
                                    @Named("app title") String appTitle) {
        Log.d(TAG, appTitle + " provideGiveAway "+ appName +": Car " + car + "; Driver " + driver);

        GiveAway giveAway = new GiveAway();
        return giveAway;
    }
}
