package de.bembelnaut.courses.dagger2demo.car;

import android.util.Log;

import javax.inject.Inject;

public class TestDriver {
    private static final String TAG = "Car";

    @Inject
    public TestDriver() {
    }

    public void callAgent(String name) {
        Log.d(TAG, "TestDriver callAgent: " + name);
    }
}
