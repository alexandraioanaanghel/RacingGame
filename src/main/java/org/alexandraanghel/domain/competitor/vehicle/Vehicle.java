package org.alexandraanghel.domain.competitor.vehicle;

import org.alexandraanghel.domain.competitor.Mobile;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Vehicle implements Mobile {

    //class variable/ static variable
    private static int totalVehicleCount;
    
    // instance variables
    private String name;
    private double fuelLevel;
    private double mileage;
    protected double totalTraveledDistance;
    //package private -default
    double maxSpeed;
    private boolean damaged;
    private String color;

    private LocalDate manufacturingDate = LocalDate.now().minusWeeks(2).plusDays(5);

    public Vehicle()
    {
        totalVehicleCount++;
    }

    public Vehicle(String name, double fuelLevel, double mileage, double totalTraveledDistance, double maxSpeed) {
        this.name = name;
        this.fuelLevel = fuelLevel;
        this.mileage = mileage;
        this.totalTraveledDistance = totalTraveledDistance;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public boolean canMove() {
        return fuelLevel >0 && !damaged;
    }

    //method overloading
    public  double accelerate(double speed)
    {
        return accelerate(speed, 1);
    }

    public double accelerate(double speed, double durationInHours)
    {
        if (!canMove())
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
           // System.out.println("Valid speed entered");
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

        System.out.println();

        return distance;

    }

    protected Vehicle reset()
    {
        totalTraveledDistance = 0;
        damaged = false;
        return this;
    }

    public void setName(String name)
    {
        //sterge spatiile de la inceput si de la sf trim
        this.name = name.trim();
    }

    public String getName()
    {
        return this.name;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getTotalTraveledDistance() {
        return totalTraveledDistance;
    }

    public void setTotalTraveledDistance(double totalTraveledDistance) {
        this.totalTraveledDistance = totalTraveledDistance;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean isDamaged() {
        return damaged;
    }

    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    //read-only
    public static int getTotalVehicleCount() {
        return totalVehicleCount;
    }

    //overriding
    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", fuelLevel=" + fuelLevel +
                ", mileage=" + mileage +
                ", totalTraveledDistance=" + totalTraveledDistance +
                ", maxSpeed=" + maxSpeed +
                ", damaged=" + damaged +
                ", color='" + color + '\'' +
                ", manufacturingDate=" + manufacturingDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(vehicle.fuelLevel, fuelLevel) == 0 &&
                Double.compare(vehicle.mileage, mileage) == 0 &&
                Double.compare(vehicle.totalTraveledDistance, totalTraveledDistance) == 0 &&
                Double.compare(vehicle.maxSpeed, maxSpeed) == 0 &&
                damaged == vehicle.damaged &&
                Objects.equals(name, vehicle.name) &&
                Objects.equals(color, vehicle.color) &&
                Objects.equals(manufacturingDate, vehicle.manufacturingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, fuelLevel, mileage, totalTraveledDistance, maxSpeed, damaged, color, manufacturingDate);
    }
}
