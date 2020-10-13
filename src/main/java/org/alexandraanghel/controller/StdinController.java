package org.alexandraanghel.controller;

import org.alexandraanghel.controller.utils.ScannerUtils;

public class StdinController implements UserInputController {

    @Override
    public int getPlayerCount() {
        System.out.println("Please enter number of players:");
        return ScannerUtils.nextIntAndMoveToNextLine();
    }

    @Override
    public String getVehicleName() {
        System.out.println("Please enter vehicle name:");
        return ScannerUtils.nextLine();
    }

    @Override
    public int getSelectedTrack() {
        System.out.println("Please select a track: ");
        return ScannerUtils.nextIntAndMoveToNextLine();
    }

    @Override
    public double getAccelerationSpeed() {
        System.out.println("Please enter acceleration speed: ");
        return ScannerUtils.nextDoubleAndMoveToNextLine();
    }

    @Override
    public int getCompetitorType() {
        return ScannerUtils.nextIntAndMoveToNextLine();
    }
}
