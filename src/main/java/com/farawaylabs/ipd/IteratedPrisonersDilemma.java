package com.farawaylabs.ipd;

import java.util.ArrayList;
import java.util.List;

public class IteratedPrisonersDilemma {
    public static void main( String[] args ) {
        IteratedPrisonersDilemma ipd = new IteratedPrisonersDilemma();

    }

    public IteratedPrisonersDilemma() {
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new TitForTat());
        //players.add(new Random());
        players.add(new Saint());
        players.add(new Demon());
        players.add(new Griefer());
        RoundRobin tournament = new RoundRobin(players);
        tournament.play();
    }
}
