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
        System.out.println("P1\tP2");

        for(int i = 0; i < 2000; i++) {
            playRound(0,1);
        }
        displayScores();
    }

    private void playRound(int p1, int p2) {
        boolean player1 = players.get(p1).getPlay();
        boolean player2 = players.get(p2).getPlay();
        players.get(p1).result(player2);
        players.get(p2).result(player1);
        //System.out.println(Boolean.valueOf(player1).toString()+"\t"+Boolean.valueOf(player2).toString());
        if (player1 && player2)  {
            players.get(p1).incrementScore(REWARD);
            players.get(p2).incrementScore(REWARD);
            //System.out.println("Cooperated");
        } else if (!player1 && !player2) {
            players.get(p1).incrementScore(PUNISHMENT);
            players.get(p2).incrementScore(PUNISHMENT);
            //System.out.println("Dual defection");
        } else if (player1) {
            players.get(p1).incrementScore(SUCKER);
            players.get(p2).incrementScore(TEMPTATION);
            //System.out.println(players.get(p1).getPlayerName()+" was the sucker.");
        } else {
            players.get(p1).incrementScore(TEMPTATION);
            players.get(p2).incrementScore(SUCKER);
            //System.out.println(players.get(p2).getPlayerName()+" was the sucker.");
        }
    }

    private void displayScores() {
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).getPlayerName() + ":  " + players.get(i).getPoints());
        }
    }
}
