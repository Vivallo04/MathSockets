package com.tec.mathsockets.states.game.tiles;

import com.badlogic.gdx.math.Vector2;
import com.tec.mathsockets.util.Utility;

public class StartTile extends Tile {

    public StartTile(int width, int height) {
        super(width, height);
        String tileTexturePath = "board/TunnelTile.png";
        Utility.loadTextureAsset(tileTexturePath);
        tileTexture = Utility.getTextureAsset(tileTexturePath);
        this.tileType = TileType.START_TILE;
        centerPos = new Vector2();
    }

    @Override
    public void action() {

    }
}
