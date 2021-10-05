package com.tec.mathsockets.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.tec.mathsockets.entity.Entity;
import com.tec.mathsockets.states.game.Dice;
import com.tec.mathsockets.states.game.GameState;
import com.tec.mathsockets.util.Utility;

public class PlayerHUD  {

    public final String TAG = PlayerHUD.class.getSimpleName();

    private final String logoTexturePath = "design/logo.png";
    private final String dashboardTexturePath = "ui/dashboard.png";
    private final String playeLabelPath = "";
    private final Texture logoTexture;

    private Texture dashboard;
    private Texture playerTag;
    private Dice gameDice;

    private int xPos;
    private int yPos;

    private final int WIDTH = Gdx.graphics.getWidth() / 3;
    private final int HEIGHT = Gdx.graphics.getHeight();
    private final GameState gameState;

    public PlayerHUD(GameState gameState, int xPos, int yPos) {
        this.gameState = gameState;
        this.xPos = xPos;
        this.yPos = yPos;

        initHUD();
        logoTexture = Utility.getTextureAsset(logoTexturePath);
        dashboard = Utility.getTextureAsset(dashboardTexturePath);

    }

    private void initHUD() {
        Utility.loadTextureAsset(logoTexturePath);
        Utility.loadTextureAsset(dashboardTexturePath);
    }

    public void render() {
        gameState.getBatch().begin();
        gameState.getBatch().draw(dashboard, xPos, yPos, WIDTH, HEIGHT);
        gameState.getBatch().draw(logoTexture, xPos + (logoTexture.getWidth()/20),
                Gdx.graphics.getHeight() - (logoTexture.getHeight()/1.5f) - 20,
                logoTexture.getWidth() / 1.5f, logoTexture.getHeight()/1.5f);
        gameState.getBatch().end();
    }

    public void dispose() {

    }
}
