package com.tec.mathsockets.entity;

import com.tec.mathsockets.states.game.GameState;

public class Player extends Entity {

    private final GameState gameState;

    public Player(GameState gameState) {
        this.gameState = gameState;
    }

}
