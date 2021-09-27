package com.tec.mathsockets.entity;

import com.badlogic.gdx.Gdx;
import com.tec.mathsockets.states.game.GameState;

import javax.swing.*;

public class Player extends Entity {

    private final String TAG = Player.class.getSimpleName();
    private final GameState gameState;

    static enum CharacterType {
        BALLOONEY,
        BLANKEY,
        LIL_WIZ,
        MR_CIRCUIT,
        ROACH,
        ROBO_RETRO,
        SLIME
    }

    private CharacterType playerCharacterSprite;

    private int FRAME_COLS;
    private int FRAME_ROWS;

    public Player(GameState gameState, CharacterType playerSprite) {
        this.gameState = gameState;
        playerCharacterSprite = playerSprite;
        setSpriteSheetDimensions(playerSprite);
    }

    private void setSpriteSheetDimensions(CharacterType characterType) {
        switch (characterType) {
            case BALLOONEY:
                FRAME_COLS = 1;
                FRAME_ROWS = 2;
                break;
            case BLANKEY:
                break;
            case LIL_WIZ:
                break;
            case MR_CIRCUIT:
                break;
            case ROACH:
                break;
            case ROBO_RETRO:
                break;
            case SLIME:
                break;
            default:
                try {
                    throw new IllegalAccessException("Unable to set sprite sheet dimensios");
                } catch (IllegalAccessException e) {
                    Gdx.app.debug(TAG, String.valueOf(e));
                    e.printStackTrace();
                }
        }
    }

}
