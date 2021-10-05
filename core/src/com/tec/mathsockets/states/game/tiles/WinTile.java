package com.tec.mathsockets.states.game.tiles;

import com.tec.mathsockets.MathSockets;
import com.tec.mathsockets.util.StateMachine;

public class WinTile extends Tile {

    public WinTile() {
        super();
        init("tiles/WinTile.png", TileType.WIN_TILE);
    }

    @Override
    public void action() {
        super.action();
        System.out.println("ON WIN TILE");
        MathSockets.stateMachine.changeState(StateMachine.StateType.WIN_STATE);
    }
}
