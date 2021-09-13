package com.tec.mathsockets.states.game.tiles;


import com.badlogic.gdx.graphics.Texture;
import com.tec.mathsockets.util.Utility;

public class StartTile extends Tile {

    private final String tileTexturePath = "board/TunnelTile.png";

    public StartTile() {
        super();

        Utility.loadTextureAsset(tileTexturePath);
        tileTexture = Utility.getTextureAsset(tileTexturePath);
        this.tileType = TileType.START_TILE;
        xPos = 0;
        yPos = 0;
    }


    @Override
    public void action() {
        super.action();

    }
}
