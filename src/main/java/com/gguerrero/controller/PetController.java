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

    public void feed(){
        virtualPet.feed();
    }

}
