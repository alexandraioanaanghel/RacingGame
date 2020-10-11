package org.alexandraanghel.competitor.vehicle;

public class Engine {

    String manufacturer;
    int capacity;

    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "manufacturer='" + manufacturer + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}