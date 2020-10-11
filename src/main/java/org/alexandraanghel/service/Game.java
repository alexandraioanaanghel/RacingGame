package org.alexandraanghel.service;

import org.alexandraanghel.controller.StdinController;
import org.alexandraanghel.controller.UserInputController;
import org.alexandraanghel.domain.Track;
import org.alexandraanghel.domain.competitor.Hulk;
import org.alexandraanghel.domain.competitor.Mobile;
import org.alexandraanghel.domain.competitor.MobileComparator;
import org.alexandraanghel.domain.competitor.vehicle.Car;
import org.alexandraanghel.domain.competitor.vehicle.Vehicle;
import org.alexandraanghel.domain.competitor.vehicle.cheater.CheatingVehicle;
import org.alexandraanghel.persistence.FileRankingRepository;
import org.alexandraanghel.persistence.RankingsRepository;

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
    private UserInputController userInputController = new StdinController();

    public void start() throws Exception {
        System.out.println("\nWelcome to the \"Racing Game\"! \uD83D\uDE97");
        System.out.println();

        initializeTracks();

        selectedTrack = getSelectedTrackFromUser();

        System.out.println("Selected track: " + selectedTrack.getName() + "\n");

        initializeCompetitors();

        loopRounds();

        processRankings();
    }

    private void processRankings()
    {
        competitors.sort(Collections.reverseOrder(new MobileComparator()));
        System.out.println("Rankings: ");
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
        System.out.println();

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
                System.out.println();
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
                System.out.println((i + 1) + ". " + tracks[i].getName() + ": " + tracks[i].getLength());
              // System.out.println((i + 1) + ". " + tracks[i].toString());
           }
       }
        System.out.println();
    }

    private void initializeCompetitors()
    {
        int playerCount = userInputController.getPlayerCount();

        for (int i =1; i<= playerCount; i++)
        {
            System.out.println("Preparing player: " + i + " for the race");
            System.out.println();

            Mobile mobile = createCompetitor();
            competitors.add(mobile);
        }

    }

    private void displayCompetitorTypes()
    {
        System.out.println("How would you like to enter the race?");
        System.out.println("1. Using a car");
        System.out.println("2. I feel lucky, I'll try Hulk");
    }

    private Mobile createCompetitor()
    {
        displayCompetitorTypes();

        int competitorType = userInputController.getCompetitorType();

        switch (competitorType)
        {
            case 0:
                CheatingVehicle cheatingVehicle = new CheatingVehicle();
                setCommonVehicleProperties(cheatingVehicle);
                return cheatingVehicle;

            case 1:
                Car car = new Car();
                setCommonVehicleProperties(car);
                return car;

            case 2:
                System.out.println("Hulk is here!");
                System.out.println();
                return new Hulk();

            default:
                System.out.println("Please select a valid option");
                return createCompetitor();
        }
    }

    private void setCommonVehicleProperties(Vehicle vehicle)
    {
        vehicle.setName(userInputController.getVehicleName());
        vehicle.setFuelLevel(100);
        vehicle.setMaxSpeed(300);
        vehicle.setMileage(ThreadLocalRandom.current().nextDouble(8,15));

        System.out.println("Fuel level for " + vehicle.getName() + ": " + vehicle.getFuelLevel());
        System.out.println("Max speed for " + vehicle.getName() + " : " + vehicle.getMaxSpeed());
        System.out.println("Mileage for " + vehicle.getName() + ": " + vehicle.getMileage());
        System.out.println();
    }

    private Track getSelectedTrackFromUser() throws Exception {
        try {
            int trackNumber = userInputController.getSelectedTrack();
            return tracks[trackNumber - 1];
        } catch (InputMismatchException e) {
            throw  new Exception("You have entered an invalid value.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("You have entered an invalid number.");
        } finally {
           // System.out.println("Finally block is always executed");
        }
    }

    private double getAccelerationSpeedFromUser()
    {
        try {
            return userInputController.getAccelerationSpeed();
        } catch (InputMismatchException e) {
            System.out.println("Invalid value. Please try again");
            //recursion
           return getAccelerationSpeedFromUser();
        }
    }

}
