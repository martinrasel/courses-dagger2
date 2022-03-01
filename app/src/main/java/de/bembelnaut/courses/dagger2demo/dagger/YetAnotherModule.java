package de.bembelnaut.courses.dagger2demo.dagger;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class YetAnotherModule {

    private final String name;

    public YetAnotherModule(String name) {
        this.name = name;
    }

    @Provides
    @Named("app name")
    public String getName() {
        return this.name;
    }

}
