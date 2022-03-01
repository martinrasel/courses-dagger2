package de.bembelnaut.courses.dagger2demo.dagger;

import dagger.Binds;
import dagger.Module;
import de.bembelnaut.courses.dagger2demo.car.Engine;
import de.bembelnaut.courses.dagger2demo.car.PetrolEngine;

@Module
public abstract class PetrolEngineModule {

    // use binds whenever a implementation is "bind" to an interface; not @Provide, because in this
    // case it's not necessary; @Binds is just a mapping so dagger can use it
    @Binds
    abstract Engine bindEngine(PetrolEngine petrolEngine);

    // static @Provides methods could be also created here, BUT NOT instance methods, because
    // dagger do not create any code.
}
