package org.alexandraanghel;

import org.alexandraanghel.utils.ScannerUtils;

public class Game {

    //ScannerUtils scannerUtils = new ScannerUtils();

    private Track[] tracks = new Track[3];

    public void start()
    {
        System.out.println("Welcome to the Racing Game!");

        initializeTracks();

        int playerCount = getPlayerCountFromUser();
        System.out.println("Player count: " +playerCount);


        String vehicleName = getVehicleNameFromUser();
        System.out.println("Vehicle Name: " + vehicleName);

    }

    private void initializeTracks()
    {
        Track track1 = new Track();
        track1.setName("Highway");
        track1.setLength(200);

        tracks[0] = track1;

        Track track2 = new Track();
        track2.setName("Street circuit");
        track2.setLength(100);

        tracks[1] = track2;

        displayTracks();
    }

    private void displayTracks()
    {
        // classic for
       for (int i =0; i< tracks.length; i++)
       {
           if (tracks[i] != null)
           {
               // System.out.println((i + 1) + ". " + tracks[i].getName() + ": " + tracks[i].getLength());
               System.out.println((i + 1) + ". " + tracks[i].toString());
           }
       }
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
