package com.gguerrero.model;

import com.gguerrero.model.ifaces.VirtualPet;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pet implements VirtualPet {

    private String id;
    private String name;
    private int kind;

    @Override
    public void showStatus() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Kind: " + kind);
    }

    @Override
    public void feed() {

    }

    @Override
    public void clean() {

    }

    @Override
    public void play() {

    }
}
