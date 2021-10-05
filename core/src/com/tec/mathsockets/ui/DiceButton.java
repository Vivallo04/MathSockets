package com.tec.mathsockets.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.tools.flame.EventManager;
import com.tec.mathsockets.MathSockets;
import com.tec.mathsockets.states.game.GameState;
import com.tec.mathsockets.util.Utility;



public class DiceButton extends ClickListener implements EventManager.Listener {

    private final String TAG = DiceButton.class.getSimpleName();

    private final String buttonOverTexturePath = "ui/buttonOver.png";
    private final String buttonTexturePath = "ui/button.png";

    private final MathSockets game;
    private final GameState gameState;


    private Texture buttonTexture;
    private Texture buttonOverTexture;

    private String buttonLabel;
    private final int xPos;
    private final int yPos;
    private final int width;
    private final int height;



    public DiceButton(MathSockets game, GameState gameState, String buttonLabel, int xPos, int yPos, int width, int height) {
        this.game = game;
        this.gameState = gameState;
        this.buttonLabel = buttonLabel;
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        init();

    }

    public void init() {
       Utility.loadTextureAsset(buttonTexturePath);
       Utility.loadTextureAsset(buttonOverTexturePath);
       buttonTexture = Utility.getTextureAsset(buttonTexturePath);
       buttonOverTexture = Utility.getTextureAsset(buttonOverTexturePath);

       Gdx.input.setInputProcessor(new InputProcessor() {

           @Override
           public boolean keyDown(int keycode) {
               return false;
           }

           @Override
           public boolean keyUp(int keycode) {
               return false;
           }

           @Override
           public boolean keyTyped(char character) {
               return false;
           }

           @Override
           public boolean touchDown(int screenX, int screenY, int pointer, int button) {
               if (Utility.inRange(Gdx.input.getX(), xPos, xPos + width) && Utility.inRange(Gdx.input.getY(), 590, 590 + height)) {
                   gameState.player.setPlayerPosIndex(PlayerHUD.getDiceInstance().rollDice());

               }
               return false;
           }

           @Override
           public boolean touchUp(int screenX, int screenY, int pointer, int button) {
               return false;
           }

           @Override
           public boolean touchDragged(int screenX, int screenY, int pointer) {
               return false;
           }

           @Override
           public boolean mouseMoved(int screenX, int screenY) {
               return false;
           }

           @Override
           public boolean scrolled(float amountX, float amountY) {
               return false;
           }


       });
    }


    public void render() {
        if (Utility.inRange(Gdx.input.getX(), xPos, xPos + width) && Utility.inRange(Gdx.input.getY(), 590, 590 + height)) {
            game.getBatch().draw(buttonOverTexture, xPos, yPos - Utility.getSmallFont().getLineHeight(), width, height);

        } else {
            game.getBatch().draw(buttonTexture, xPos, yPos - Utility.getSmallFont().getLineHeight(), width, height);
        }
        Utility.getSmallFont().draw(game.getBatch(), buttonLabel, xPos + 25, yPos);
    }


    public void dispose() {
        Utility.unloadAsset(buttonTexturePath);
    }

    /**
     * Invoked when an action occurs.
     * @param e the event to be processed
     */
    public void actionPerformed(int e) {

    }

    @Override
    public void handle(int aEventType, Object aEventData) {

    }
}
