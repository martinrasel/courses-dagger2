package de.bembelnaut.courses.dagger2demo.thirdparty;

public class SpecialWheels {
    // we don't own this class so we can't annotate it with @Inject

    private Rims rims;
    private Tires tires;

    public SpecialWheels(Rims rims, Tires tires) {
        this.rims = rims;
        this.tires = tires;
    }
}
