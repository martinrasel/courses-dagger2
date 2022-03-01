package de.bembelnaut.courses.dagger2demo.dagger;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Subcomponent;
import de.bembelnaut.courses.dagger2demo.thirdparty.GiveAway;

@PerFragment
@Subcomponent(modules = {AddonsModule.class, YetAnotherModule.class})
public interface CarFragmentComponent {

    // provision method: API to retrieve e.g. @Provide objects.
    GiveAway getAGiveAway();

    // the method for the dependency is generated, when no component builder is defined

    // factories are compile time safe. Builder pattern could throw an exception, if
    // some configuration is missed. Builder are suitable for optional configuration.
    @Subcomponent.Factory
    interface Builder {
        CarFragmentComponent create(YetAnotherModule yetAnotherModule,
                                    @BindsInstance @Named("app title") String appTitle);
    }
}
