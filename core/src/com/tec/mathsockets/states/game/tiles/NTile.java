package com.tec.mathsockets.states.game.tiles;

public class NTile {

    private static int pos = 0;
    private Tile tile;

    public NTile previous;
    public NTile next;

    public NTile(Tile tile) {
        this.tile = tile;
        pos++;
    }


    public Tile getTile() {
        return this.tile;
    }

}
