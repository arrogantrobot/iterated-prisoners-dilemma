package com.farawaylabs.ipd;

import java.util.*;

public class Tournament {
    ArrayList<Player> players;
    Map<String, Float> scores;
    private int roundsPerMatch= 2000000;
    private int matchesPerCycle = 100;
    public static final int REWARD = 3;
    public static final int SUCKER = 0;
    public static final int TEMPTATION = 5;
    public static final int PUNISHMENT = 1;
    public Tournament(ArrayList<Player> players) {
        this.players = new ArrayList<Player>(players);
        initializeScores();
    }

    public void play()  {
        for (int i = 0; i < players.size() ; i++) {
            int p2 = getRandomPlayer();
            for(int j = 0; j < getRoundsPerMatch(); j++) {
                playRound(i,p2);

            }
            updateScores();
        }
        displayScores();
    }

    public void playRandom()  {
        for (int i = 0; i < players.size() * getMatchesPerCycle(); i++) {
            int p1 = getRandomPlayer();
            int p2 = getRandomPlayer();
            for(int j = 0; j < getRoundsPerMatch(); j++) {
                playRound(p1,p2);

            }
            updateScores();
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
        float defaultScore = (float)1 / (float)players.size();
        for (Player p : players) {
            scores.put(p.getPlayerName(), defaultScore);
            System.out.println(p.getPlayerName() + ": " + Float.valueOf((float)defaultScore).toString());
        }
    }

    protected void updateScores() {
        int totalScore = 0;
        for (Player p : players) {
            totalScore += p.getPoints();
        }
        for (Player p : players) {
            scores.put(p.getPlayerName(), Float.valueOf((float)p.getPoints() / (float)totalScore));
        }
    }

    protected void playRound(int p1, int p2) {
        boolean player1 = players.get(p1).getPlay();
        boolean player2 = players.get(p2).getPlay();
        players.get(p1).result(player2);
        players.get(p2).result(player1);
        //System.out.println(Boolean.valueOf(player1).toString()+"\t"+Boolean.valueOf(player2).toString());
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

    protected void displayScores() {
        System.out.println("\n\n================\n\n");
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).getPlayerName() + ":  " + scores.get(players.get(i).getPlayerName()));
        }
    }

    public void setRoundsPerMatch(int roundsPerMatch) {
        this.roundsPerMatch = roundsPerMatch;
    }

    public int getRoundsPerMatch() {
        return this.roundsPerMatch;
    }

    public void setMatchesPerCycle(int matchesPerCycle) {
        this.matchesPerCycle = matchesPerCycle;
    }

    public int getMatchesPerCycle() {
        return this.matchesPerCycle;
    }
}

