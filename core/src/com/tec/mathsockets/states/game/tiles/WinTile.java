package com.tec.mathsockets.states.game.tiles;

public class WinTile extends Tile {
    public WinTile() {
        super();
        init("tiles/WinTile.png", TileType.WIN_TILE);
    }

    @Override
    public void action() {
        super.action();
        System.out.println("ON WIN TILE");
    }
}
