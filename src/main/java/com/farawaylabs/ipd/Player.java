package com.farawaylabs.ipd;

public class Player implements Strategy {
    int points;
    public Player() {
        this.points = 0;
    }
    public int getPoints() {
        return this.points;
    }
    public void incrementScore(int points) {
        this.points += points;
    }
    public void decrementScore(int points) {
        this.points -= points;
    }

    @Override
    public boolean getPlay() {return true;}

    @Override
    public void result(boolean result) {}

    public String getPlayerName() {return "Player";}
}