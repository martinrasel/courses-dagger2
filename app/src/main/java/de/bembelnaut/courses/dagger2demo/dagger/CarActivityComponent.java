package de.bembelnaut.courses.dagger2demo.dagger;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;
import de.bembelnaut.courses.dagger2demo.MainActivity;
import de.bembelnaut.courses.dagger2demo.car.Car;

// different scopes for app and activity components.
@PerActivity
@Component (
        dependencies = CarAppComponent.class,
        modules = {SpecialWheelsModule.class, PetrolEngineModule.class})
public interface CarActivityComponent {

    Car getCar();

    // this is a factory method.
    // all modules of the sub component without an default constructor or not abstract classes
    // must passed as arguments
    CarFragmentComponent.Builder getCatFragmentComponentBuilder();

    // inject only works for a single activity
    void inject(MainActivity mainActivity);

    // Builder must implement *ALL* methods, to provide all information in the module / component
    // i.e. if there is a constructor with values, the builder must provide a method to provide a
    // specific instance
    @Component.Builder
    interface Builder {
        // -> Only for ElectroEngineModule

        // must be defined, because the constructor of ElectroEngineModule has a argument.
        // @BindsInstance will throw an exception at this definition, because dagger try to
        // bind all instances of this type, and it doesn't have to provide in the module.
        // but its finally the module itself, so it crashed

        // Builder electroEngineModule(ElectroEngineModule electroEngineModule);

        /* This will crash, because String-type is provided already in the ElectroEngineModule
        @BindsInstance
        Builder engineName(String engineName);*/

        // -> End

        // because the dependency AND the builder interface
        Builder catAppComponent(CarAppComponent carAppComponent);

        // Provide this int-Type by a builder.
        // Important: in the module, the @Provide method for this int-Type must not available.
        // Otherwise dagger throw a exception that the value is provided multiple times
        @BindsInstance
        Builder horsePower(@Named("horse power") int horsePower);

        // use @Named to specify the type
        @BindsInstance
        Builder engineCapacity(@Named("engine capacity") int engineCapacity);

        CarActivityComponent build();
    }

}
