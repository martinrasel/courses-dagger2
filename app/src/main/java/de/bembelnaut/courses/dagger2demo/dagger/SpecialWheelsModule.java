package de.bembelnaut.courses.dagger2demo.dagger;

import dagger.Module;
import dagger.Provides;
import de.bembelnaut.courses.dagger2demo.thirdparty.Rims;
import de.bembelnaut.courses.dagger2demo.thirdparty.SpecialWheels;
import de.bembelnaut.courses.dagger2demo.thirdparty.Tires;

@Module
public abstract class SpecialWheelsModule {

    @Provides
    static Rims provideRims() {
        return new Rims();
    }

    @Provides
    static Tires provideTires() {
        Tires tires = new Tires();
        tires.inflate();
        return tires;
    }

    @Provides
    static SpecialWheels provideSpecialWheels(Rims rims, Tires tires) {
        return new SpecialWheels(rims, tires);
    }
}
