package com.tec.mathsockets.states.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.tec.mathsockets.util.Utility;


public class Dice {

    private final String defaultDicePath = "dice/dice.png";
    private final String TAG = Dice.class.getSimpleName();

    private final Texture diceTexture;
    private final int[] diceNumbers;

    private Animation<TextureRegion> diceAnimation;

    public Dice(GameState state) {
        diceNumbers = new int[] {1, 2, 3, 4};
        diceTexture = new Texture(Gdx.files.internal(defaultDicePath));
    }


    public int rollDice() {
        return diceNumbers[Utility.random.nextInt(diceNumbers.length)];
    }


}
