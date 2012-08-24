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
        Tournament t = new Tournament(players);
        t.play();
    }
}
