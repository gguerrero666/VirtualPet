package com.gguerrero.thread;

import com.gguerrero.constants.Constants;
import com.gguerrero.controller.PetController;

public class ThreadAlive extends Thread {

    PetController petController;

    public ThreadAlive(PetController petController) {
        this.petController = petController;
    }

    @Override
    public void run() {
        try {
            do {
                Thread.sleep(Constants.sleepMillisThreadAlive);
                petController.alive(Constants.pointsThreadAlive);
//              petController.showStatus();
            }
            while (petController.isAlive());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
