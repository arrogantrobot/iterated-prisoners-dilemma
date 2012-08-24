package com.farawaylabs.ipd;

class Griefer extends Player {

    private boolean lastPlay = true;

    public Griefer() {}

    @Override
    public boolean getPlay() {return this.lastPlay;}

    @Override
    public void result(boolean result) {
        if (! result) {
            this.lastPlay = false;
        }
    }

    public String getPlayerName() {return "Griefer";}
}
