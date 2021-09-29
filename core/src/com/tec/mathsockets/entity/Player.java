package com.tec.mathsockets.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.tec.mathsockets.states.game.Board;
import com.tec.mathsockets.util.SpriteManager;

public class Player extends Entity {

    private final String TAG = Player.class.getSimpleName();

    private TextureRegion currentPLayerFrame;
    private Sprite playerSprite;
    private boolean onTurn;

    private final int PLAYER_WIDTH = 128;
    private final int PLAYER_HEIGHT = 128;

    private TextureRegion currentPlayerFrame;
    private Sprite currentPlayerSprite;

    private SpriteManager spriteManager;
    private Board board;

    private int initialX;
    private int initialY;

    public Player(Board board) {
        this.board = board;
        this.spriteManager = new SpriteManager(SpriteManager.CharacterType.BLANKEY);


    }

    public void render(SpriteBatch batch) {
        int offsetX = 65;
        int offsetY = 50;

        initialX = (int) board.boardNodes.getFirst().getCenterNode().x;
        initialY = (int) board.boardNodes.getFirst().getCenterNode().y;

        spriteManager.addStateTime(Gdx.graphics.getDeltaTime());
        currentPlayerFrame = spriteManager.getWalkAnimation().getKeyFrame(spriteManager.getStateTime(), true);
        batch.draw(currentPlayerFrame, initialX - offsetX,initialY - offsetY, PLAYER_WIDTH, PLAYER_HEIGHT);
    }

    public void dispose() {

    }



}