package com.farawaylabs.ipd;

import java.util.ArrayList;
import java.util.List;

public class Tournament {
    ArrayList<Player> players;
    public static final int REWARD = 3;
    public static final int SUCKER = 0;
    public static final int TEMPTATION = 5;
    public static final int PUNISHMENT = 1;
    public Tournament(ArrayList<Player> players) {
        this.players = new ArrayList<Player>(players);
    }

    public void play()  {
        for(int i = 0; i < 200; i++) {
            playRound(0,1);
        }
        displayScores();
    }

    private void playRound(int p1, int p2) {
        boolean player1 = players.get(p1).getPlay();
        boolean player2 = players.get(p2).getPlay();
        players.get(p1).result(player2);
        players.get(p2).result(player1);
        if (player1 && player2)  {
            players.get(p1).incrementScore(REWARD);
            players.get(p2).incrementScore(REWARD);
        } else if (!player1 && !player2) {
            players.get(p1).incrementScore(PUNISHMENT);
            players.get(p2).incrementScore(PUNISHMENT);
        } else if (player1) {
            players.get(p1).incrementScore(SUCKER);
            players.get(p2).incrementScore(TEMPTATION);
        } else {
            players.get(p1).incrementScore(TEMPTATION);
            players.get(p2).incrementScore(SUCKER);
        }
    }

    private void displayScores() {
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).getPlayerName() + ":  " + players.get(i).getPoints());
        }
    }
}
