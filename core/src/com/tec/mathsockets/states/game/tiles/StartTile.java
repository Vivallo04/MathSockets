package com.tec.mathsockets.states.game.tiles;

import com.tec.mathsockets.util.Utility;

public class StartTile extends Tile {

    public StartTile() {
        super();
        String tileTexturePath = "board/TunnelTile.png";
        Utility.loadTextureAsset(tileTexturePath);
        tileTexture = Utility.getTextureAsset(tileTexturePath);
        this.tileType = TileType.START_TILE;
    }


    @Override
    public void action() {

    }
}
