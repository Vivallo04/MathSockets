package com.tec.mathsockets.states.game.tiles;

import com.badlogic.gdx.graphics.Texture;

public class Tile {

    enum TileType {
        START_TILE,
        CHALLENGE_TILE,
        TRAP_TILE,
        TUNNEL_TILE,
        WIN_TILE
    }

    protected TileType tileType;
    protected Texture tileTexture;
    protected int xPos;
    protected int yPos;

    public Tile() {

    }

    public void action() {

    }




}
