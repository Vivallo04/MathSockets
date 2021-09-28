package com.tec.mathsockets.states.game.tiles;

import com.tec.mathsockets.util.Utility;

public class StartTile extends Tile implements ITileAction {


    public StartTile() {
        super();
        init("tiles/StartTile.png", TileType.START_TILE);
    }


    @Override
    public void action() {

    }

    @Override
    public void executeAction() {

    }
}
