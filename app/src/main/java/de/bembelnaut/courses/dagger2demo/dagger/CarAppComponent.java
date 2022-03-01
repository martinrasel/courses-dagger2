package de.bembelnaut.courses.dagger2demo.dagger;

import javax.inject.Singleton;

import dagger.Component;
import de.bembelnaut.courses.dagger2demo.thirdparty.Driver;

@Singleton
@Component(modules = DriverModule.class)
public interface CarAppComponent {
    Driver getDriver();
}
