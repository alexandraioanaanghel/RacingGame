package org.alexandraanghel.competitor.vehicle;

import org.alexandraanghel.competitor.Mobile;

import java.time.LocalDate;

//final in fata clasei nu ne mai permite sa mostenim acea clasa
public abstract class Vehicle implements Mobile {

    //class variable/ static variable = o sg val in toata app
    private static int totalVehicleCount;
    
    // instance variables
    private String name;
    private double fuelLevel;
    private double mileage; //consum
    //accesibil si din orice sub clasa chiar daca nu e in pachetul respectiv
    protected double totalTraveledDistance;
    //package private -default accesibil in tot pachetul
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

    // final la metoda acea medota nu va mai putea fi suprascrisa
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
}
