package de.bembelnaut.courses.dagger2demo.car;

import android.util.Log;

import javax.inject.Inject;

public class ElectroEngine implements Engine {
    private static final String TAG = "Car";

    private int horsePower;
    private String engineName;

    @Inject
    public ElectroEngine(int horsePower, String engineName) {
        this.horsePower = horsePower;
        this.engineName = engineName;
    }

    @Override
    public void start() {
        Log.d(TAG, "ElectroEngine "+ engineName +" start. PS: " + this.horsePower);
    }
}
