package org.alexandraanghel.domain.competitor.vehicle;

// "is-a" relationship (inheritance)
public class Car extends AutoVehicle {

    private int doorCount;

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

    @Override
    public String toString() {
        return "Car{" +
                "doorCount=" + doorCount +
                "} " + super.toString();
    }

}
