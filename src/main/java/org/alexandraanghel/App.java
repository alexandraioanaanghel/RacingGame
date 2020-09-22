package org.alexandraanghel;

public class App 
{
    public static void main( String[] args )
    {
        //o instanta a clasei Car
       Car carReference = new Car();
       carReference.name = "Dacia";
       carReference.maxSpeed = 180;
       carReference.fuelLevel = 40;
       carReference.color = "Red";
       carReference.damaged = true;
       carReference.doorCount = 4;
       carReference.mileage = 8.5;
       carReference.totalTraveledDistance = 0;

       Engine engine1 = new Engine();
       engine1.manufacturer = "Dacia";
       engine1.capacity = 3000;
       carReference.engine = engine1;

        System.out.println("Properties of car " + carReference.name);
        System.out.println("Max speed: " + carReference.maxSpeed);
        System.out.println("Fuel level: " + carReference.fuelLevel);
        System.out.println("Mileage: " + carReference.mileage);
        System.out.println("Color: " + carReference.color);
        System.out.println("Door count: " + carReference.doorCount);
        System.out.println("Total traveled distance: " + carReference.totalTraveledDistance);
        System.out.println("Damaged: " + carReference.damaged);
        System.out.println("Engine capacity: " + carReference.engine.capacity);
        System.out.println("Engine manufacturer: " + carReference.engine.manufacturer);

        engine1.capacity = 4000;
        System.out.println("Engine capacity after update: " + carReference.engine.capacity);

        System.out.println("");

        Car carReference2 = new Car();
        carReference2.name = "Audi";
        carReference2.mileage = 11.5;
        carReference2.fuelLevel = 300;

        carReference2.engine = new Engine();
        carReference2.engine.manufacturer = "Audi";
        carReference2.engine.capacity = 5000;

        System.out.println("Properties of car " + carReference2.name);
        System.out.println("Max speed: " + carReference2.maxSpeed);
        System.out.println("Fuel level: " + carReference2.fuelLevel);
        System.out.println("Mileage: " + carReference2.mileage);
        System.out.println("Color: " + carReference2.color);
        System.out.println("Door count: " + carReference2.doorCount);
        System.out.println("Total traveled distance: " + carReference2.totalTraveledDistance);
        System.out.println("Damaged: " + carReference2.damaged);

        System.out.println("");

        double distanceForCar1 = carReference.accelerate(60, 1);
        System.out.println("Distance for car1: " + distanceForCar1);

        System.out.println("");

        double distanceForCar2 = carReference2.accelerate(100,1);
        System.out.println("Distance for car2: " + distanceForCar2);

        System.out.println("");

        System.out.println("Engine name befor repair: " + carReference.engine.manufacturer);
        Mechanic mechanic = new Mechanic();
        mechanic.repair(carReference);
        System.out.println("Engine name befor repair: " + carReference.engine.manufacturer);



//        System.out.println("Initial name for car1: " + carReference.name);
//        carReference.name = "Ford";
//        System.out.println("Changed name for car1: " + carReference.name);
//
//
//        System.out.println("");
//
//        carReference = new Car();
//        System.out.println("Name of new car: " + carReference.name);
//        carReference.name = "BMW";
//
//        System.out.println("");
//
//        carReference = carReference2;
//        System.out.println("Name of car referenced from 2 variables. carReference:  " + carReference.name);
//        System.out.println("Name of car referenced from 2 variables. carReference2: " + carReference2.name);
//
//        System.out.println("");
//
//        carReference2.name = "Opel";
//        System.out.println("Updated of car referenced from 2 variables. carReference:  " + carReference.name);
//        System.out.println("Updated of car referenced from 2 variables. carReference2: " + carReference2.name);
//
//       // carReference2 = null; //nu afecteaza si carReference
//       // System.out.println(carReference.name);

    }
}
