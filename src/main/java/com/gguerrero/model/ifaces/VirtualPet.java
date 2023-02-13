package com.gguerrero.model.ifaces;

public interface VirtualPet {

    void showStatus();
    void feed(int points);
    void clean(int points);
    void play(int points);
    void alive(int points);
    boolean isAlive();
    void care();
    void makeAngry();
    void calm();
    boolean isSleeping();
    void setSleep(boolean sleep);

}
