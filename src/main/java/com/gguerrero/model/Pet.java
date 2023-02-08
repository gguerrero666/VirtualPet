package com.gguerrero.model;

import com.gguerrero.model.ifaces.VirtualPet;
import lombok.Data;

@Data
public class Pet implements VirtualPet {

    private String id;
    private String name;
    private int kind;
    private int health = 100;

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
        System.out.println();
    }

    @Override
    public void feed() {
        health = Math.min(health + 10, 100);
    }

    @Override
    public void clean() {

    }

    @Override
    public void play(int points) {
        health = health - points;
    }

    @Override
    public void alive(int points) {
        health = health - points;
    }


}
