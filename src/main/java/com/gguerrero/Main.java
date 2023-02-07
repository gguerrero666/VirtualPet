package com.gguerrero;

import com.gguerrero.controller.PetController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    @Autowired
    PetController petController;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {

        petController.createPet("1", "my first pet", 1);
        do {
            switch (showMenu()) {
                case 1:
                    petController.showStatus();
                    break;
                case 2:
                    petController.play();
                    break;
                case 3:
                    petController.feed();
                    break;
                case 9:
                    return;
            }
        } while (true);
    }

    public int showMenu() {
        System.out.println("1. status");
        System.out.println("2. play");
        System.out.println("3. feed");
        System.out.println("4. clean");
        System.out.println("9. exit");

        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }
}