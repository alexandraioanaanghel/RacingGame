package org.alexandraanghel;

public class AutoVehicle extends Vehicle {

    //"has-a" relationship (aggregation)
    private Engine engine;

    public AutoVehicle(Engine engine)
    {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
