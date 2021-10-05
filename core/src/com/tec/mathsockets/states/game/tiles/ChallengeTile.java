package com.tec.mathsockets.states.game.tiles;

public class ChallengeTile extends Tile {
    public ChallengeTile() {
        super();
        init("tiles/ChallengeTile.png", TileType.CHALLENGE_TILE);
    }

    @Override
    public void action() {
        super.action();
        System.out.println("ON CHALLENGE TILE");
    }
}
