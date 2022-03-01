package de.bembelnaut.courses.dagger2demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import javax.inject.Inject;

import de.bembelnaut.courses.dagger2demo.car.Car;
import de.bembelnaut.courses.dagger2demo.car.TestDriver;
import de.bembelnaut.courses.dagger2demo.dagger.CarActivityComponent;
import de.bembelnaut.courses.dagger2demo.dagger.CarAppComponent;
import de.bembelnaut.courses.dagger2demo.dagger.CarFragmentComponent;
import de.bembelnaut.courses.dagger2demo.dagger.DaggerCarActivityComponent;
import de.bembelnaut.courses.dagger2demo.dagger.YetAnotherModule;
import de.bembelnaut.courses.dagger2demo.thirdparty.GiveAway;

public class MainActivity extends AppCompatActivity {

    @Inject
    Car car1, car2;

    GiveAway giveAway;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Call component injection if no class injection available, like in an activity class.
        // If there are no Constructors with arguments this method can be used
        // CarComponent carComponent = DaggerCarComponent.create();

        // get the application wide component
        CarAppComponent appComponent = ((ExampleApp) getApplication()).getAppComponent();

        // ... otherwise a builder must be called to create an instance
        // CarActivityComponent is a per activity scoped dagger component, witch needs a
        // CarAppComponent, a app scoped dagger component.
        CarActivityComponent carComponent = DaggerCarActivityComponent.builder()
                .horsePower(12)
                .engineCapacity(1400)
                .catAppComponent(appComponent)
                .build();

        // provision method by component, instead of using @Inject on the field
        //car = carComponent.getCar();

        // field injection of car
        // use this for infect multiple fields into a class
        carComponent.inject(this);

        // could be also annotated as @Inject, so the method is called automatically
        car1.drive();
        car2.drive();

        CarFragmentComponent carFragmentComponent = carComponent
                .getCatFragmentComponentBuilder()
                .create(new YetAnotherModule("Hello World!"),"Foo Bar");

        giveAway = carFragmentComponent.getAGiveAway();
    }

    // method injection also available, but only if the component is called. And
    // the order is again: first fields, then method
    @Inject public void enableTestDriver(TestDriver testDriver) {
        testDriver.callAgent("Steve");
    }
}