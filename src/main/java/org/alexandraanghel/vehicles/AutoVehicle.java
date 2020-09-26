package org.alexandraanghel.vehicles;

import org.alexandraanghel.Engine;

public class AutoVehicle extends Vehicle {

    //"has-a" relationship (aggregation)
    private Engine engine;

    //constructor overloading - supraincarcare
    public AutoVehicle()
    {
        //this.engine = new Engine();

        //apelare alt constructor;
        this(new Engine());
    }

    public AutoVehicle(Engine engine)
    {
        this.engine = engine;
        System.out.println("Custom constructor");
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
