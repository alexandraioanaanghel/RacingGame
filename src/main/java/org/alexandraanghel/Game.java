package org.alexandraanghel;

import org.alexandraanghel.utils.ScannerUtils;
import org.alexandraanghel.vehicles.Car;
import org.alexandraanghel.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

    //ScannerUtils scannerUtils = new ScannerUtils();

    private Track[] tracks = new Track[3];
    private List<Vehicle> competitors = new ArrayList<>();

    public void start()
    {
        System.out.println("Welcome to the Racing Game!");

        initializeTracks();

        Track selectedTrack = getSelectedTrackFromUser();

        System.out.println("Selected track: " + selectedTrack.toString());

        initializeCompetitors();

        playOneRound();
    }

    private void playOneRound()
    {
        System.out.println("New round.");

//        for (int i =0; i <competitors.size(); i++)
//        {
//            Vehicle competitor = competitors.get(i);
//            System.out.println("It's " + competitor.getName() + "'s turn");
//            competitor.accelerate(100);
//        }

        //enhanced for (for-each)
        for (Vehicle competitor : competitors)
        {
            System.out.println("It's " + competitor.getName() + "'s turn");
            double speed = getAccelerationSpeedFromUser();
            competitor.accelerate(speed);
        }
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
        System.out.println("Available tracks");
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

    private void initializeCompetitors()
    {
        int playerCount = getPlayerCountFromUser();

        for (int i =1; i<= playerCount; i++)
        {
            System.out.println("Preparing player: " + i + " for the race");
            Vehicle vehicle = new Car();
            vehicle.setName(getVehicleNameFromUser());
            vehicle.setFuelLevel(30);
            vehicle.setMaxSpeed(300);
            vehicle.setMileage(ThreadLocalRandom.current().nextDouble(8,15));

            System.out.println("Fuel level for " + vehicle.getName() + ": " + vehicle.getFuelLevel());
            System.out.println("Max speed for " + vehicle.getName() + " : " + vehicle.getMaxSpeed());
            System.out.println("Mileage for " + vehicle.getName() + ": " + vehicle.getMileage());
            System.out.println();

            competitors.add(vehicle);
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

    private Track getSelectedTrackFromUser()
    {
        System.out.println("Please select a track: ");
        int trackNumber = ScannerUtils.nextIntAndMoveToNextLine();

        return tracks[trackNumber-1];
    }

    private double getAccelerationSpeedFromUser()
    {
        System.out.println("Please enter acceleration speed: ");
        return ScannerUtils.nextDoubleAndMoveToNextLine();
    }

}
