package com.tec.mathsockets.states.game.tiles;

public class TrapTile extends Tile {

    public TrapTile() {
        super();
        init("tiles/TrapTile.png", TileType.TRAP_TILE);
    }

    @Override
    public void action() {
        super.action();
        System.out.println("ON TRAP TILE");
    }
}
