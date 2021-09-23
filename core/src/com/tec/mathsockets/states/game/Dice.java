package com.tec.mathsockets.states.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.tec.mathsockets.util.Utility;


public class Dice {

    private final String TAG = Dice.class.getSimpleName();

    private final Sprite diceSprite;
    private final int[] diceNumbers;


    public Dice(GameState state) {
        diceNumbers = new int[] {1, 2, 3, 4};
        diceSprite = new Sprite();
    }

    public int rollDice() {
        return diceNumbers[Utility.random.nextInt(diceNumbers.length)];
    }


}
