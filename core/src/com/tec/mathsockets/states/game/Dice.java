package com.tec.mathsockets.states.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.tec.mathsockets.ui.PlayerHUD;
import com.tec.mathsockets.util.Utility;


public class Dice {

    private final String defaultDiceTexturePath = "dice/dice.png";
    private final String TAG = Dice.class.getSimpleName();

    private final Texture diceTexture;
    private final int[] diceNumbers;

    private Animation<TextureRegion> diceAnimation;

    private final PlayerHUD playerHUD;

    private int XPOS;
    private int YPOS;

    public Dice(PlayerHUD playerHUD, int xPos, int yPos) {
        init();
        this.playerHUD = playerHUD;
        this.XPOS = xPos;
        this.XPOS = yPos;
        diceNumbers = new int[] {1, 2, 3, 4};
        diceTexture = Utility.getTextureAsset(defaultDiceTexturePath);
    }

    public void init() {
        Utility.loadTextureAsset(defaultDiceTexturePath);
    }

    public int rollDice() {
        return diceNumbers[Utility.random.nextInt(diceNumbers.length)];
    }

    public void render() {

    }

    public void dispose() {

    }

}
