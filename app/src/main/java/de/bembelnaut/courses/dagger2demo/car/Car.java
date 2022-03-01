package de.bembelnaut.courses.dagger2demo.car;

import android.util.Log;

import javax.inject.Inject;

import de.bembelnaut.courses.dagger2demo.dagger.PerActivity;
import de.bembelnaut.courses.dagger2demo.thirdparty.Driver;
import de.bembelnaut.courses.dagger2demo.thirdparty.SpecialWheels;

@PerActivity
public class Car {
    private static final String TAG = "Car";

    private Engine engine;
    private SpecialWheels wheels;
    private Driver driver;

    // Field injection only triggered if a class injection exists. Also method injection!
    // Order is: Constructor, then fields, then methods
    @Inject
    TestDriver testDriver;

    // All fields are injected in this constructor, but they have to provided or got an @Inject
    // on their constructor
    @Inject
    public Car(Engine engine, SpecialWheels wheels, Driver driver) {
        this.engine = engine;
        this.wheels = wheels;
        this.driver = driver;
    }

    //@Inject
    public void drive() {
        engine.start();
        Log.d(TAG, "drive: driving... driver " + driver + " \n" + "car: " + this);
    }

    // best use case of method injection is, when passing an instance of itself to an dependency
    @Inject
    public void enableRemote(Remote remote) {
        remote.setListener(this);
    }
}
