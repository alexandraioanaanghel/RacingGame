package org.alexandraanghel;

public class Mechanic {

    public void repair(AutoVehicle autoVehicle)
    {
       autoVehicle.engine = new Engine();
       autoVehicle.damaged = false;
    }
}
