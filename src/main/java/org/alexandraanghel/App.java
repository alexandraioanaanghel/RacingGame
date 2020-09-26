package org.alexandraanghel;

public class App
{
    public static void main( String[] args )
    {

       Game game = new Game();
       game.start();

//       //example invoking overloaded methods and constructors
//       Engine engine = new Engine();
//       engine.setCapacity(1400);
//       engine.setManufacturer("Dacia");
//       AutoVehicle autoVehicle = new AutoVehicle(engine);
//
//       AutoVehicle autoVehicle2 = new AutoVehicle();
//
//       Car c1 = new Car();
//
//       autoVehicle.accelerate(100);
//       autoVehicle2.accelerate(100,3);
//
//       autoVehicle.accelerate(10);
//
//        System.out.println("Engine capacity " + engine.getCapacity());
//        System.out.println(engine.getCapacity());
//        System.out.println(engine);



//        Vehicle vehicle1 = new Vehicle();
//        vehicle1.setName("Dacia");
//
//        Vehicle vehicle2 = new Vehicle();
//        vehicle2.setName("Audi");
//
//        System.out.println("Total count from vehicle" + vehicle1.getName() + ": " + vehicle1.getTotalVehicleCount());
//        System.out.println("Total count from vehicle" + vehicle2.getName() + ": " + vehicle2.getTotalVehicleCount());
//        System.out.println("Total count from Vehicle class: " + Vehicle.getTotalVehicleCount());
//
//
//        Engine autoVhicleEngine = new Engine();
//        autoVhicleEngine.manufacturer ="VW";
//        autoVhicleEngine.capacity = 3000;
//        AutoVehicle autoVehicle = new AutoVehicle(autoVhicleEngine);
//
//        Engine engine1 = new Engine();
//        engine1.manufacturer = "Dacia";
//        engine1.capacity = 1000;
//
//        //o instanta a clasei Car
//       Car carReference = new Car(engine1);
//       carReference.setName("Dacia");
//       carReference.setMaxSpeed(180);
//       carReference.setFuelLevel(70);
//       carReference.setColor("Red");
//       carReference.setDamaged(false);
//       carReference.setDoorCount(4);
//       carReference.setMileage(10);
//       carReference.setTotalTraveledDistance(0);
//
//        System.out.println("Properties of car " + carReference.getName());
//        System.out.println("Max speed: " + carReference.getMaxSpeed());
//        System.out.println("Fuel level: " + carReference.getFuelLevel());
//        System.out.println("Mileage: " + carReference.getMileage());
//        System.out.println("Color: " + carReference.getColor());
//        System.out.println("Door count: " + carReference.getDoorCount());
//        System.out.println("Total traveled distance: " + carReference.getTotalTraveledDistance());
//        System.out.println("Damaged: " + carReference.isDamaged());
//        System.out.println("Engine capacity: " + carReference.getEngine().capacity);
//        System.out.println("Engine manufacturer: " + carReference.getEngine().manufacturer);
//
//        engine1.capacity = 4000;
//        System.out.println("Engine capacity after update: " + carReference.getEngine().capacity);
//
//        System.out.println("");
//
//        Car carReference2 = new Car(new Engine());
//        carReference2.setName("Audi");
//        carReference2.setMileage(11.5);
//        carReference2.setFuelLevel(80);
//        carReference2.setMaxSpeed(300);
//        carReference2.setDamaged(false);
//
//
//        //carReference2.engine = new Engine();
//        carReference2.getEngine().manufacturer = "Audi";
//        carReference2.getEngine().capacity = 5000;
//
//        System.out.println("Properties of car " + carReference2.getName());
//        System.out.println("Max speed: " + carReference2.getMaxSpeed());
//        System.out.println("Fuel level: " + carReference2.getFuelLevel());
//        System.out.println("Mileage: " + carReference2.getMileage());
//        System.out.println("Color: " + carReference2.getColor());
//        System.out.println("Door count: " + carReference2.getDoorCount());
//        System.out.println("Total traveled distance: " + carReference2.getTotalTraveledDistance());
//        System.out.println("Damaged: " + carReference2.isDamaged());
//
//        System.out.println("");
//
//        double distanceForCar1 = carReference.accelerate(130, 1);
//        System.out.println("Distance for car1: " + distanceForCar1);
//
//        System.out.println("");
//
//        double distanceForCar2 = carReference2.accelerate(100,1);
//        System.out.println("Distance for car2: " + distanceForCar2);
//
//        System.out.println("");
//
//        System.out.println("Engine manufacturer before repair: " + carReference.getEngine().manufacturer);
//        Mechanic mechanic = new Mechanic();
//        mechanic.repair(carReference);
//        System.out.println("Engine manufacture after repair: " + carReference.getEngine().manufacturer);
//
//
//
//        System.out.println("Initial name for car1: " + carReference.getName());
//        carReference.setName("Ford");
//        System.out.println("Changed name for car1: " + carReference.getName());
//
//
//        System.out.println("");
//
//        carReference = new Car(engine1);
//        System.out.println("Name of new car: " + carReference.getName());
//        carReference.setName("BMW");
//
//        System.out.println("");
//
//        carReference = carReference2;
//        System.out.println("Name of car referenced from 2 variables. carReference:  " + carReference.getName());
//        System.out.println("Name of car referenced from 2 variables. carReference2: " + carReference2.getName());
//
//        System.out.println("");
//
//        carReference2.setName("Opel");
//        System.out.println("Updated of car referenced from 2 variables. carReference:  " + carReference.getName());
//        System.out.println("Updated of car referenced from 2 variables. carReference2: " + carReference2.getName());
//
//       // carReference2 = null; //nu afecteaza si carReference
//       // System.out.println(carReference.name);
//
//
//        System.out.println("");
//
//        System.out.println("Modulo example: ");
//        //restul impartirii
//        System.out.println(4 % 2);
//        System.out.println(4 % 3);
//
//        int a = 4;
//
//        if (a % 2 ==0)
//        {
//            System.out.println("a is an even number");
//        }
//        else
//        {
//            System.out.println("a is an odd number");
//        }
    }
}
