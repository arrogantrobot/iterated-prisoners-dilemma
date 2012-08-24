package com.farawaylabs.ipd;

class Demon extends Player {

    private boolean lastPlay = true;

    public Demon() {}

    @Override
    public boolean getPlay() {return false;}

    @Override
    public void result(boolean result) { }

    public String getPlayerName() {return "Demon";}
}
