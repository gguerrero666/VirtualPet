package com.gguerrero.model.ifaces;

public interface VirtualPet {

    void showStatus();
    void feed(int points);
    void clean();
    void play(int points);
    void alive(int points);
    boolean isAlive();
    void care();
}
