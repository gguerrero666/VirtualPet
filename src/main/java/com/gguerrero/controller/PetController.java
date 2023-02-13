package com.gguerrero.controller;

import com.gguerrero.model.Pet;
import com.gguerrero.model.ifaces.VirtualPet;
import com.gguerrero.service.ifaces.VirtualPetService;
import org.springframework.stereotype.Controller;

@Controller
public class PetController {
    VirtualPetService virtualPetService;

    VirtualPet virtualPet;

    public PetController(VirtualPetService virtualPetService){
        this.virtualPetService = virtualPetService;
    }

    public void createPet(String id, String name, int kind){
        virtualPet = new Pet(id, name, kind);
    }

    public void showStatus(){
        virtualPet.showStatus();
    }

    public void alive(int points){
        virtualPet.alive(points);
    }

    public void play(int points){
        virtualPet.play(points);
    }

    public void feed(int points){
        virtualPet.feed(points);
    }

    public boolean isAlive(){
        return virtualPet.isAlive();
    }

    public void clean(int points){
        virtualPet.clean(points);
    }

    public void care(){
        virtualPet.care();
    }

    public void makeAngry(){
        virtualPet.makeAngry();
    }
    public void calm(){
        virtualPet.calm();
    }

    public boolean isSleeping(){
        return virtualPet.isSleeping();
    }
    public void setSleep(boolean sleep){
        virtualPet.setSleep(sleep);
    }
    public boolean isSick(){
        return virtualPet.isSick();
    }

}
