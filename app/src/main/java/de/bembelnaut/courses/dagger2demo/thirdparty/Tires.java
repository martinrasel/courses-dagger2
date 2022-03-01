package de.bembelnaut.courses.dagger2demo.thirdparty;

import android.util.Log;

public class Tires {
    // we don't own this class so we can't annotate it with @Inject
    private static final String TAG = "Car";

    public void inflate() {
        Log.d(TAG, "inflate: Tires!");
    }
}
