package org.alexandraanghel;

import org.alexandraanghel.competitor.Mobile;
import org.alexandraanghel.competitor.MobileComparator;
import org.alexandraanghel.competitor.vehicle.Car;
import org.alexandraanghel.competitor.vehicle.Vehicle;
import org.alexandraanghel.persistence.FileRankingRepository;
import org.alexandraanghel.persistence.RankingsRepository;
import org.alexandraanghel.utils.ScannerUtils;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

    //ScannerUtils scannerUtils = new ScannerUtils();

    private Track[] tracks = new Track[3];
    private List<Mobile> competitors = new ArrayList<>();
    private boolean winnerNotKnown = true;
    private Track selectedTrack;
    private Set<Mobile> outOfRaceCompetitors = new HashSet<>();

    private RankingsRepository rankingsRepository = new FileRankingRepository();

    public void start() throws Exception {
        System.out.println("Welcome to the Racing Game!");

        initializeTracks();

        selectedTrack = getSelectedTrackFromUser();

        System.out.println("Selected track: " + selectedTrack.toString());

        initializeCompetitors();

        loopRounds();

        processRankings();
    }

    private void processRankings()
    {
        competitors.sort(Collections.reverseOrder(new MobileComparator()));
        System.out.println("Rakings: ");
        for (int i =0; i < competitors.size(); i++)
        {
            System.out.println((i+1) + ". " + competitors.get(i).getName() + ": " + competitors.get(i).getTotalTraveledDistance() + " km");
            rankingsRepository.addRankingItem(i+1, competitors.get(i).getName(), competitors.get(i).getTotalTraveledDistance());
        }
        rankingsRepository.close();
    }

    private void loopRounds()
    {
        while (winnerNotKnown && outOfRaceCompetitors.size() < competitors.size())
        {
            playOneRound();
        }

        //do while
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
        for (Mobile competitor : competitors)
        {
            System.out.println("It's " + competitor.getName() + "'s turn");

            if (!competitor.canMove())
            {
                System.out.println("Sorry you cannot continue the race...");
                outOfRaceCompetitors.add(competitor);
                continue;
            }

            double speed = getAccelerationSpeedFromUser();
            competitor.accelerate(speed, 1);

            if (competitor.getTotalTraveledDistance() >= selectedTrack.getLength() )
            {
                System.out.println("The winner is: " + competitor.getName());
                winnerNotKnown = false;
                break;
            }
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

    private Track getSelectedTrackFromUser() throws Exception {
        System.out.println("Please select a track: ");
        try {
            int trackNumber = ScannerUtils.nextIntAndMoveToNextLine();
            return tracks[trackNumber - 1];
        } catch (InputMismatchException e) {
            throw  new Exception("You have entered an invalid value.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("You have entered an invalid number.");
        } finally {
            System.out.println("Finally block is always executed");
        }
    }

    private double getAccelerationSpeedFromUser()
    {
        System.out.println("Please enter acceleration speed: ");
        try {
            return ScannerUtils.nextDoubleAndMoveToNextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid value. Please try again");
            //recursion
           return getAccelerationSpeedFromUser();
        }
    }

}
