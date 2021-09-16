package com.tec.mathsockets.states.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tec.mathsockets.states.game.tiles.StartTile;
import com.tec.mathsockets.states.game.tiles.Tile;
import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Board {

    public static String TAG = Board.class.getSimpleName();
    private Random random = new Random();

    public int offsetY = 5;

    public enum BoardSize {
        SMALL,
        MEDIUM,
        BIG
    }

    public LinkedList<Tile> boardNodes;
    private int totalTiles;


    public Board(BoardSize boardSize) {
        boardNodes = new LinkedList<Tile>();
        if (boardSize.equals(BoardSize.SMALL)) {
            totalTiles = 16;
        } else if (boardSize.equals(BoardSize.MEDIUM)) {
            totalTiles = 25;
        } else {
            totalTiles = 36;
        }
        populateBoard();
    }


    public void populateBoard() {
        int tileCount = 0;

        while(tileCount < totalTiles) {
            boardNodes.add(new StartTile());
            tileCount++;
        }
        Gdx.app.debug(TAG, "Board has been populated");
    }


    public void render(SpriteBatch batch) {
        int tileWidth = 64;
        int tileHeigth = 64;
        int currentNode = 0;
        int i = 1; // x  pos
        int j = 2;
        for (Tile tile: boardNodes) {
            // in-line
            if (boardNodes.size() % i == 0 && i != 1) {
                batch.draw(boardNodes.element().getTileTexture(), (i * tileWidth), Gdx.graphics.getHeight() - (j * tileHeigth), tileWidth, tileHeigth);
                currentNode++;
                j++;
                i = 1;
            } else {
                batch.draw(boardNodes.element().getTileTexture(), (i * tileWidth), Gdx.graphics.getHeight() - (j * tileHeigth), tileWidth, tileHeigth);
                currentNode++;
                i++;
            }
        }

    }


    public void dispose() {
        boardNodes.removeAll(boardNodes);
    }

}
