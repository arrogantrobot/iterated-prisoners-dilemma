package com.farawaylabs.ipd;

import java.util.*;

public class Tournament {
    ArrayList<Player> players;
    Map<String, Float> scores;
    public static final int REWARD = 3;
    public static final int SUCKER = 0;
    public static final int TEMPTATION = 5;
    public static final int PUNISHMENT = 1;
    public Tournament(ArrayList<Player> players) {
        this.players = new ArrayList<Player>(players);
        initializeScores();
    }

    public void play()  {
        //System.out.println("P1\tP2");
        for (int i = 0; i < players.size(); i++) {
            int p1 = getRandomPlayer();
            int p2 = getRandomPlayer();
            for(int j = 0; j < 200; j++) {
                playRound(p1,p2);
            }
        }
        displayScores();
    }

    private int getRandomPlayer() {
        float chosen = (float) Math.random();
        float runningTotal = 0;
        for (Player p : players) {
            runningTotal += scores.get(p.getPlayerName());
            if (runningTotal >= chosen) {
                return players.indexOf(p);
            }
        }
        return -1; // this is in place to maintain appearances..
    }

    private void initializeScores() {
        scores = new HashMap<String, Float>();
        float defaultScore = 1 / players.size();
        for (Player p : players) {
            scores.put(p.getPlayerName(), defaultScore);
        }
    }

    private void updateScores() {
        int totalScore = 0;
        for (Player p : players) {
            totalScore += p.getPoints();
        }
        for (Player p : players) {
            scores.put(p.getPlayerName(), Float.valueOf(p.getPoints() / totalScore));
        }
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
            System.out.println(players.get(i).getPlayerName() + ":  " + scores.get(players.get(i).getPlayerName()));
        }
    }
}
