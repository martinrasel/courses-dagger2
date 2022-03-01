package de.bembelnaut.courses.dagger2demo.dagger;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import de.bembelnaut.courses.dagger2demo.car.ElectroEngine;
import de.bembelnaut.courses.dagger2demo.car.Engine;

@Module
public class ElectroEngineModule {

    private final String name;

    public ElectroEngineModule(String name) {
        this.name = name;
    }

    @Provides
    @Named("engine name")
    String provideEngineName() {
        return name;
    }

    // Method cannot be static, because fields are created by constructor
    @Provides
    Engine provideEngine(ElectroEngine electroEngine) {
        return electroEngine;
    }

    // static @Provides methods could be also created here, BUT NOT instance methods, because
    // dagger do not create any code.
}
