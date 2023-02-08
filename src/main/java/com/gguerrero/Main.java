package com.gguerrero;

import com.gguerrero.controller.PetController;
import com.gguerrero.thread.ThreadAlive;
import com.gguerrero.thread.ThreadUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

        // TODO: IU to configure setup of pet:
        petController.createPet("1", "my first pet", 1);
        LOG.info(petController.toString());

        // Main Threads
        ThreadUser threadUser = new ThreadUser(petController);
        ThreadAlive threadAlive = new ThreadAlive(petController);

        // Start Main Threads
        threadUser.start();
        threadAlive.start();

    }
}