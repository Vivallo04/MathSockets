package com.tec.mathsockets.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.tec.mathsockets.MathSockets;
import com.tec.mathsockets.states.game.Dice;
import com.tec.mathsockets.states.game.GameState;
import com.tec.mathsockets.util.Utility;

public class PlayerHUD  {

    public final String TAG = PlayerHUD.class.getSimpleName();
    private final MathSockets game;
    private final GameState gameState;

    private final String logoTexturePath = "design/logo.png";
    private final String dashboardTexturePath = "ui/dashboard.png";
    private final String playeLabelPath = "";
    private final Texture logoTexture;

    private Texture dashboard;
    private Texture playerTag;
    private static Dice Dice;

    private int xPos;
    private int yPos;

    private final int WIDTH = Gdx.graphics.getWidth() / 3;
    private final int HEIGHT = Gdx.graphics.getHeight();

    private Vector2 rollDicePositionVector;
    private final DiceButton rollDiceBUtton;

    public PlayerHUD(MathSockets game, GameState gameState, int xPos, int yPos) {
        this.game = game;
        this.gameState = gameState;
        this.xPos = xPos;
        this.yPos = yPos;

        initHUD();
        logoTexture = Utility.getTextureAsset(logoTexturePath);
        dashboard = Utility.getTextureAsset(dashboardTexturePath);
        Dice = new Dice(this);

        rollDicePositionVector = new Vector2((xPos - 55) + (WIDTH/2),Gdx.graphics.getHeight() - 600);
        rollDiceBUtton = new DiceButton(game, gameState,"Roll", (int) rollDicePositionVector.x,
                (int) rollDicePositionVector.y, 128, 64);
    }

    private void initHUD() {
        Utility.loadTextureAsset(logoTexturePath);
        Utility.loadTextureAsset(dashboardTexturePath);

    }

    public void render() {
        game.getBatch().draw(dashboard, xPos, yPos, WIDTH, HEIGHT);
        game.getBatch().draw(logoTexture, xPos + (logoTexture.getWidth()/20),
                Gdx.graphics.getHeight() - (logoTexture.getHeight()/1.5f) - 20,
                logoTexture.getWidth() / 1.5f, logoTexture.getHeight()/1.5f);
        Dice.render();
        rollDiceBUtton.render();
    }

    public Batch getGameBatch() {
        return game.getBatch();
    }

    public static Dice getDiceInstance() {
        return Dice;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public void dispose() {

    }
}
