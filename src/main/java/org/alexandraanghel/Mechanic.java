package org.alexandraanghel;

import org.alexandraanghel.vehicles.AutoVehicle;

public class Mechanic {

    public void repair(AutoVehicle autoVehicle)
    {
       autoVehicle.setEngine(new Engine());
       autoVehicle.setDamaged(false);
       autoVehicle.setTotalTraveledDistance(autoVehicle.getTotalTraveledDistance()-100);
    }
}
