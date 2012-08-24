package com.farawaylabs.ipd;

class Saint extends Player {

    private boolean lastPlay = true;

    public Saint() {}

    @Override
    public boolean getPlay() {return true;}

    @Override
    public void result(boolean result) { }

    public String getPlayerName() {return "Saint";}
}