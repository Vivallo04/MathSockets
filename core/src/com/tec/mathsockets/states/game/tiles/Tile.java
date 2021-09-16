package com.tec.mathsockets.states.game.tiles;

import com.badlogic.gdx.graphics.Texture;

public abstract class Tile {

    protected enum TileType {
        START_TILE,
        CHALLENGE_TILE,
        TRAP_TILE,
        TUNNEL_TILE,
        WIN_TILE
    }

    protected Texture tileTexture;
    protected TileType tileType;
    protected final String tileTexturePath = null;

    protected int xPos;
    protected int yPos;

    protected int width;
    protected int height;

    protected int tileCount;


    public Tile() {
        tileCount++;
    }

    public int getTileCount() {
        return this.tileCount;
    }

    public TileType getTileType() {
        return this.tileType;
    }

    public Texture getTileTexture() {
        return tileTexture;
    }

    public void action() {

    }


    //Getters & Setters --------------------------------------------------------
    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}
