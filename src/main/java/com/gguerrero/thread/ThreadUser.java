package com.gguerrero.thread;

import com.gguerrero.constants.Constants;
import com.gguerrero.controller.PetController;

import java.util.InputMismatchException;
import java.util.Scanner;

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
                        petController.feed(Constants.pointFeed);
                        break;
                    case 4:
                        petController.clean();
                        break;
                    case 5:
                        petController.scrub();
                        break;
                    case 9:
                        return;
                }
            } while (petController.isAlive());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println(Constants.deadMsj);
    }

    public int showMenu() {
        Scanner s = new Scanner(System.in);
        int selected = 0;

        System.out.println("1. status");
        System.out.println("2. play");
        System.out.println("3. feed");
        System.out.println("4. clean");
        System.out.println("5. scrub");
        System.out.println("9. exit");


        try {
            selected = s.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selected;
    }
}
