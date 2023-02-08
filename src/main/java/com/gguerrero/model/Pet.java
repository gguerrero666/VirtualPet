package com.gguerrero.model;

import com.gguerrero.constants.Constants;
import com.gguerrero.model.ifaces.VirtualPet;
import lombok.Data;

@Data
public class Pet implements VirtualPet {

    private String id;
    private String name;
    private int kind;
    private int health = 100;
    private int happiness = 100;

    public Pet(String id, String name, int kind) {
        this.id = id;
        this.name = name;
        this.kind = kind;
    }

    @Override
    public void showStatus() {
        System.out.println("    ID: " + id);
        System.out.println("    Name: " + name);
        System.out.println("    Kind: " + kind);
        System.out.println("    Health: " + health);
        System.out.println("    Happiness: " + happiness);
        System.out.println();
    }

    @Override
    public void feed(int points) {
        health = Math.min(health + points, Constants.maxPercent);
    }

    @Override
    public void clean() {

    }

    @Override
    public void play(int points) {
        happiness = Math.min(happiness + points, Constants.maxPercent);
        health = Math.max(health - points, Constants.minPercent);
    }

    @Override
    public void alive(int points) {
        health = Math.max(health - points, Constants.minPercent);
        happiness = Math.min(happiness - points, Constants.maxPercent);
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

}
