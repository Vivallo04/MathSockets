package com.tec.mathsockets.states.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.tec.mathsockets.ui.PlayerHUD;
import com.tec.mathsockets.util.Utility;


public class Dice extends ClickListener {

    public static enum DiceState {
        STATIC,
        ROLLING
    }

    private final String defaultDiceTexturePath = "dice/diceSpriteSheet.png";
    private final String TAG = Dice.class.getSimpleName();

    private static final int FRAME_COLS = 4;
    private static final int FRAME_ROWS = 1;

    private final int[] diceNumbers;

    private Animation<TextureRegion> diceAnimation;
    private boolean isRolling = false;

    private final Texture diceTextureSheet;
    private TextureRegion[][] temp;

    private TextureRegion currentFrame;
    TextureRegion[] rollingDiceFrames;

    private final PlayerHUD playerHUD;
    public float stateTime;

    private final int DICE_WIDTH = 75;
    private final int DICE_HEIGHT = 75;
    private int X_POS;
    private int Y_POS;

    private DiceState currentDiceState = DiceState.STATIC;

    public Dice(PlayerHUD playerHUD) {
        this.playerHUD = playerHUD;
        diceNumbers = new int[] {1, 2, 3, 4};
        Utility.loadTextureAsset(defaultDiceTexturePath);
        diceTextureSheet = Utility.getTextureAsset(defaultDiceTexturePath);
        init();
    }

    public void init() {
        temp = TextureRegion.split(diceTextureSheet, diceTextureSheet.getWidth() / FRAME_COLS,
                                                    diceTextureSheet.getHeight()/FRAME_ROWS);

        rollingDiceFrames = new TextureRegion[FRAME_ROWS * FRAME_COLS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                rollingDiceFrames[index++] = temp[i][j];
            }
        }
        diceAnimation = new Animation<TextureRegion>(0.025f, rollingDiceFrames);
        stateTime = 0f;
    }


    public void rollDice() {
        if (currentDiceState == DiceState.STATIC) {
            currentDiceState = DiceState.ROLLING;
            isRolling = true;
        } else {
            currentDiceState = DiceState.STATIC;
            isRolling = false;
            int newNum = getRandomNUmber();
        }
    }

    public int getRandomNUmber() {
        return diceNumbers[Utility.random.nextInt(diceNumbers.length)];
    }

    public void render() {
        stateTime += Gdx.graphics.getDeltaTime();
        currentFrame = diceAnimation.getKeyFrame(stateTime, isRolling);

        playerHUD.getGameBatch().draw(currentFrame, playerHUD.getxPos() + (playerHUD.getWIDTH() / 2 - 30) , Gdx.graphics.getHeight() / 4,
                                                                                DICE_WIDTH, DICE_HEIGHT);

    }

    public void dispose() {
        Utility.unloadAsset(defaultDiceTexturePath);
    }

}
