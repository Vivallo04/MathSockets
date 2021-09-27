package com.tec.mathsockets.states.game.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.tec.mathsockets.util.Utility;

public abstract class Tile {

    protected enum TileType {
        START_TILE,
        CHALLENGE_TILE,
        TRAP_TILE,
        TUNNEL_TILE,
        WIN_TILE
    }

    protected String tileTexturePath;
    protected Texture tileTexture;
    protected TileType tileType;
    protected Vector2 centerNode;

    protected int xPos;
    protected int yPos;

    protected final int WIDTH = 128;
    protected final int HEIGHT = 128;

    protected int tileCount;

    public Tile() {
        tileCount++;
    }

    protected void init(String tileTexturePath, TileType tileType) {
        setTileTexturePath(tileTexturePath);
        Utility.loadTextureAsset(getTileTexturePath());
        tileTexture = Utility.getTextureAsset(tileTexturePath);
        this.tileType = tileType;
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

    public void addCenterNode(int x, int y) {
        centerNode = new Vector2(x, y);
    }

    public Vector2 getCenterNode() {
        return centerNode;
    }

    public void setTileTexturePath(String path) {
        tileTexturePath = path;
    }

    public String getTileTexturePath() {
        return tileTexturePath;
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

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }



}
