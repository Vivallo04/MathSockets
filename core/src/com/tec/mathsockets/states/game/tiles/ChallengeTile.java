package com.tec.mathsockets.states.game.tiles;

import com.tec.mathsockets.MathSockets;
import com.tec.mathsockets.util.StateMachine;

public class ChallengeTile extends Tile {
    public ChallengeTile() {
        super();
        init("tiles/ChallengeTile.png", TileType.CHALLENGE_TILE);
    }


    @Override
    public void action() {
        super.action();

        //MathSockets.stateMachine.changeState(StateMachine.StateType.CHALLENGE_STATE);
        System.out.println("ON CHALLENGE TILE");
    }
}
