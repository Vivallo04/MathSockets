package com.tec.mathsockets.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.tec.mathsockets.states.game.GameState;
import com.tec.mathsockets.util.SpriteManager;

import javax.swing.*;

public class Player extends Entity {

    private final String TAG = Player.class.getSimpleName();

    private Sprite playerSprite;
    private TextureRegion currentPLayerFrame;
    private boolean onTurn;


    private TextureRegion currentPlayerFrame;
    private Sprite currentPlayerSprite;

    SpriteManager spriteManager;


    public Player() {
        this.spriteManager = new SpriteManager(SpriteManager.CharacterType.BLANKEY);
    }

    public void render(SpriteBatch batch, int x, int y) {
        spriteManager.addStateTime(Gdx.graphics.getDeltaTime());
        currentPlayerFrame = spriteManager.getWalkAnimation().getKeyFrame(spriteManager.getStateTime(), true);
        batch.draw(currentPlayerFrame, x, y, 128, 128);
    }

    public void dispose() {

    }



}
