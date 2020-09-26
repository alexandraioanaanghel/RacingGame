package org.alexandraanghel.vehicles;

import org.alexandraanghel.Engine;

// "is-a" relationship (inheritance)
public class Car extends AutoVehicle {

    private int doorCount;

    //a apela constructorl din AutoVehicle
    public Car() {
        super();
    }

    public Car(Engine engine) {
        super(engine);
    }

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }
}
