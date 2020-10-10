package org.alexandraanghel.vehicles.cheater;

import org.alexandraanghel.vehicles.Vehicle;

public class CheatingVehicle extends Vehicle {

    @Override
    public double accelerate(double speed, double durationInHours) {
        System.out.println(getName() + " is accelerating with " + speed + " km/h for " + durationInHours + " h");
        System.out.println("Cheater!!!");

        double distance = speed * durationInHours *2;
        totalTraveledDistance += distance;
        System.out.println("Total traveled distance for vehicle " + getName() + ": " + totalTraveledDistance);
        return distance;
    }

    public void cheat()
    {
        totalTraveledDistance *=2;
    }

    //co-variant return type
    //method access can be more permissive than in the parent class
    @Override
    public CheatingVehicle reset() {
        super.reset();
        return this;
    }
}
