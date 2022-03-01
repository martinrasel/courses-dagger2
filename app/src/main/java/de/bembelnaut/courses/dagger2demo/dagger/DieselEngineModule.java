package de.bembelnaut.courses.dagger2demo.dagger;

import dagger.Module;
import dagger.Provides;
import de.bembelnaut.courses.dagger2demo.car.DieselEngine;
import de.bembelnaut.courses.dagger2demo.car.Engine;

@Module
public class DieselEngineModule {

    private int horsePower;

    public DieselEngineModule(int horsePower) {
        this.horsePower = horsePower;
    }

    @Provides
    int provideHorsePower() {
        return horsePower;
    }

    // Method cannot be static, because fields are created by constructor
    @Provides
    Engine provideEngine(DieselEngine dieselEngine) {
        return dieselEngine;
    }

    // static @Provides methods could be also created here, BUT NOT instance methods, because
    // dagger do not create any code.
}
