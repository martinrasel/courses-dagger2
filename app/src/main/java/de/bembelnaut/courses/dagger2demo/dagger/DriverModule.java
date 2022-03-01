package de.bembelnaut.courses.dagger2demo.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.bembelnaut.courses.dagger2demo.thirdparty.Driver;

@Module
public abstract class DriverModule {

    @Provides
    @Singleton
    static Driver provideDriver() {
        return new Driver();
    }
}
