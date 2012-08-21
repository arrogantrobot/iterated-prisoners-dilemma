package com.farawaylabs.ipd;

class TitForTat extends Player {

    private boolean lastPlay = true;

    public TitForTat() {}

    @Override
    public boolean getPlay() {return this.lastPlay;}

    @Override
    public void result(boolean result) {this.lastPlay = result;}

    public String getPlayerName() {return "TitForTat";}
}