package com.tec.mathsockets.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.tec.mathsockets.states.game.GameState;
import com.tec.mathsockets.util.SpriteManager;

import javax.swing.*;

public class Player extends Entity {

    private final String TAG = Player.class.getSimpleName();
    private final GameState gameState;

    private Sprite playerSprite;
    private TextureRegion currentPLayerFrame;
    private boolean onTurn;

    private TextureRegion currentPlayerFrame;
    private Sprite currentPlayerSprite;


    public Player(GameState gameState) {
        this.gameState = gameState;

    }




}
