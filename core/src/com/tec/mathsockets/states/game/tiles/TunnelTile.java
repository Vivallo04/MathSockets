package com.tec.mathsockets.states.game.tiles;

public class TunnelTile extends Tile {

    public TunnelTile() {
        super();
        init("tiles/TunnelTile.png", TileType.TUNNEL_TILE);
    }

    @Override
    public void action() {
        super.action();
        System.out.println("TUNNEL TILE");
    }
}
