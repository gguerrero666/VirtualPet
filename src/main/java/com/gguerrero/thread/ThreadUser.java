package com.gguerrero.thread;

import com.gguerrero.constants.Constants;
import com.gguerrero.controller.PetController;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class ThreadUser extends Thread{

    PetController petController;

    public ThreadUser(PetController petController){
        this.petController = petController;
    }
    @Override
    public void run() {
        try {
            do {
                switch (showMenu()) {
                    case 1:
                        petController.showStatus();
                        break;
                    case 2:
                        petController.play(Constants.pointsPlay);
                        break;
                    case 3:
                        petController.feed(Constants.pointsFeed);
                        break;
                    case 4:
                        petController.clean(Constants.pointsClean);
                        break;
                    case 5:
                        petController.care();
                        break;
                    case 6:
                        petController.makeAngry();
                        break;
                    case 7:
                        petController.calm();
                        break;
                    case 8:
                        petController.setSleep(!petController.isSleeping());
                        break;
                    case 9:
                        this.interrupt();
                }
            } while (!Thread.currentThread().isInterrupted());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        petController.kill();
        log.info(Constants.deadMsj);
    }

    public int showMenu() {
        Scanner s = new Scanner(System.in);
        int selected = 0;

        System.out.println("1. status");
        System.out.println("2. play");
        System.out.println("3. feed");
        System.out.println("4. clean");
        System.out.println("5. care");
        System.out.println("6. make angry");
        System.out.println("7. calm");
        System.out.println("8. sleep / awake");
        System.out.println("9. exit");

        while (!s.hasNextInt()) {
            System.out.println("Please enter an integer.");
            s.next();
        }
        return s.nextInt();
    }
}
