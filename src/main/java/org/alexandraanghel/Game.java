package org.alexandraanghel;

import org.alexandraanghel.utils.ScannerUtils;

public class Game {

    //ScannerUtils scannerUtils = new ScannerUtils();

    public void start()
    {
        System.out.println("Welcome to the Racing Game!");

        int playerCount = getPlayerCountFromUser();
        System.out.println("Player count: " +playerCount);


        String vehicleName = getVehicleNameFromUser();
        System.out.println("Vehicle Name: " + vehicleName);
    }

    private int getPlayerCountFromUser()
    {
        System.out.println("Please enter number of players:");
        //return scannerUtils.nextIntAndMoveToNextLine();
        return ScannerUtils.nextIntAndMoveToNextLine();
    }

    private String getVehicleNameFromUser()
    {
        System.out.println("Please enter vehicle name:");
       // return scannerUtils.nextLine();
        return ScannerUtils.nextLine();
    }

}
