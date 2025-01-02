package com.gguerrero.thread;

import com.gguerrero.constants.Constants;
import com.gguerrero.controller.PetController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
                if (!petController.isSleeping()) {
                    petController.alive(petController.isSick() ? Constants.pointsThreadAliveSick : Constants.pointsThreadAlive);
                }
                if(!petController.isAlive()){
                    this.interrupt();
                }
            }
            while (!Thread.currentThread().isInterrupted());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
