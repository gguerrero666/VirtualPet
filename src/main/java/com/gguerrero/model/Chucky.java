package com.gguerrero.model;

import com.gguerrero.constants.Constants;
import com.gguerrero.util.Util;

public class Chucky extends Pet {

    int angry = 0;

    public Chucky(String id, String name, int kind) {
        super(id, name, kind);
    }

    @Override
    public void alive(int points) {
        super.alive(points);
        angry = Math.min(angry + Util.getIntProb(Constants.angryProb), Constants.maxPercent);
    }

    @Override
    public void showStatus() {
        super.showStatus();
        System.out.println("    Angry: " + angry);
        System.out.println();
    }

    public void scrub(){
        angry = 0;
    }

}
