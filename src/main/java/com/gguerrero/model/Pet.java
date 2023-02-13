package com.gguerrero.model;

import com.gguerrero.constants.Constants;
import com.gguerrero.model.ifaces.VirtualPet;
import com.gguerrero.util.Util;
import lombok.Data;

@Data
public class Pet implements VirtualPet {

    private String id;
    private String name;
    private int kind;
    private int health = 100;
    private int happiness = 100;
    private int poop = 0;
    private boolean sick = false;
    private int angry = 0;
    private boolean sleep = false;

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
        System.out.println("    Poop: " + poop);
        System.out.println("    Sick: " + sick);
        System.out.println("    Angry: " + angry);
        System.out.println("    Sleep: " + sleep);

        System.out.println();
    }

    @Override
    public void feed(int points) {
        health = Math.min(health + points, Constants.maxPercent);
    }

    @Override
    public void clean(int points) {
        poop = Math.max(poop - points, Constants.minPercent);
    }

    @Override
    public void play(int points) {
        happiness = Math.min(happiness + (points * 2), Constants.maxPercent);
        health = Math.max(health - points, Constants.minPercent);
    }

    @Override
    public void alive(int points) {
        health = Math.max(health - points, Constants.minPercent);
        happiness = Math.max(happiness - points, Constants.minPercent);

        poop = Math.min(poop + Util.getIntProb(Constants.poopProb), Constants.maxPercent);
        sick = sick || Util.getBooleanProb(poop);
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public void care() {
        sick = false;
    }

    @Override
    public void makeAngry() {
        angry = Util.getRandom(1, 100);
    }

    @Override
    public void calm() {
        angry = 0;
    }

    @Override
    public boolean isSleeping() {
        return sleep;
    }

    @Override
    public void setSleep(boolean sleep) {
        this.sleep = sleep;
    }


}
