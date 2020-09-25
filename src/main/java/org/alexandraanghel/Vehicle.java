package org.alexandraanghel;

public class Vehicle {

    // instance variables
    String name;
    double fuelLevel;
    double mileage; //consum
    double totalTraveledDistance;
    double maxSpeed;
    boolean damaged;
    String color;

    public Vehicle()
    {

    }

    public Vehicle(String name, double fuelLevel, double mileage, double totalTraveledDistance, double maxSpeed) {
        this.name = name;
        this.fuelLevel = fuelLevel;
        this.mileage = mileage;
        this.totalTraveledDistance = totalTraveledDistance;
        this.maxSpeed = maxSpeed;
    }

    public double accelerate(double speed, double durationInHours)
    {
        if (fuelLevel <=0 || damaged)
        {
            System.out.println("You cannot accelerate.");
            return 0;
        }

        if (speed > maxSpeed)
        {
            System.out.println("Max speed exceeded");
            return 0;
        } else if (speed == maxSpeed)
        {
            System.out.println("Careful, Max speed reached");
        }
        else
        {
            System.out.println("Valid speed entered");
        }

        System.out.println(name + " is accelerating with " + speed + " km/h for " + durationInHours + " h");

        //local variable
        double distance = speed * durationInHours;

        totalTraveledDistance += distance;
        System.out.println("Total traveled distance for vehicle " + name + ": " + totalTraveledDistance);

        double mileageMultiplier = 1;

        if (speed >120)
        {
            mileageMultiplier = speed /100;
        }

        double usedFuel = distance * mileage * mileageMultiplier/ 100;

        fuelLevel -= usedFuel;
        System.out.println("Remaining fuel for vehicle " + name + ": " + fuelLevel);


        return distance;

    }
}
