package com.farawaylabs.ipd;

import java.util.*;

public class RoundRobin extends Tournament {
    private int roundsPerMatch= 2000000;
    private int matchesPerCycle = 100;

    public RoundRobin(ArrayList<Player> players) {
        super(players);
    }
    
    @Override
    public void play()  {
        for (int i = 0; i < players.size() ; i++) {
            for(int j = 0; j < players.size(); j++) {
                playRound(i,j);
            }
            updateScores();
        }
        displayScores();
    }
}

