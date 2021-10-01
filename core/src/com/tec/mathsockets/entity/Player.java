package com.tec.mathsockets.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.tec.mathsockets.states.game.Board;
import com.tec.mathsockets.util.SpriteManager;

import java.util.UUID;

public class Player extends Entity {

    private final String TAG = Player.class.getSimpleName();
    private final String playerID = UUID.randomUUID().toString();

    private final int PLAYER_WIDTH = 128;
    private final int PLAYER_HEIGHT = 128;

    private TextureRegion currentPlayerFrame;
    private Sprite currentPlayerSprite;

    private SpriteManager spriteManager;
    private Board board;

    private Vector2 currentPlayerPosVector;
    private Vector2 previousPlayerVector;
    private Vector2 nextPlayerVector;

    private int playerPosIndex;
    private boolean onTurn;


    public Player(Board board) {
        this.board = board;
        this.spriteManager = new SpriteManager(SpriteManager.CharacterType.BLANKEY);


        playerPosIndex = 0;
        // get the first node and set it as the player's position
    }

    public void render(SpriteBatch batch) {
        int offsetX = 65;
        int offsetY = 50;

        spriteManager.addStateTime(Gdx.graphics.getDeltaTime());


        currentPlayerPosVector = new Vector2(board.boardTileNodes.get(playerPosIndex).getCenterNode().x,
                board.boardTileNodes.get(playerPosIndex).getCenterNode().y);;

        currentPlayerFrame = spriteManager.getWalkAnimation().getKeyFrame(spriteManager.getStateTime(), true);
        batch.draw(currentPlayerFrame, currentPlayerPosVector.x - offsetX, currentPlayerPosVector.y - offsetY, PLAYER_WIDTH, PLAYER_HEIGHT);
    }

    public void goToNextTile() {
        if (playerPosIndex == (board.getBoardTileNodes().size()) - 1) {
            playerPosIndex = playerPosIndex;
            board.boardTileNodes.getLast().action();
        } else {
            int newPlayerPos = playerPosIndex + 1;
            playerPosIndex = newPlayerPos;
            // previousPlayerVector = new Vector2(currentPlayerPosVector);
            currentPlayerPosVector = new Vector2(board.boardTileNodes.get(newPlayerPos).getCenterNode());
        }
        Gdx.app.debug(TAG, "Current player [" + playerID + "] at node: " + playerPosIndex +
                ". Total nodes: " + board.getBoardTileNodes().size());
    }

    public void goToPreviousTile() {
        if (playerPosIndex == 1) {
            playerPosIndex = 1;
        } else {
            int newPlayerPos = playerPosIndex - 1;
            previousPlayerVector = currentPlayerPosVector;
            currentPlayerPosVector = board.getBoardTileNodes().get(newPlayerPos).getCenterNode();
        }
        Gdx.app.debug(TAG, "Current player [" + playerID + "] at node: " + playerPosIndex +
                ". Total nodes: " + board.getBoardTileNodes().size());
    }

    public Vector2 getCurrentPlayerPosVector() {
        return currentPlayerPosVector;
    }

    public void setCurrentPlayerPosVector(Vector2 currentPlayerPosVector) {
        this.currentPlayerPosVector = currentPlayerPosVector;
    }

    public void dispose() {

    }



}