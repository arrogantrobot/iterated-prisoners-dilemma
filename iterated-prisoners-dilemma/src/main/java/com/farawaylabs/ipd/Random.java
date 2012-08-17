package com.farawaylabs.ipd;

public class Random extends Player {
    public Random() {}

    @Override
    public boolean getPlay() {
        return Math.random() > 0.5;
    }

    @Override
    public void result(boolean result){}

    public String getPlayerName() {return "Random";}
}