package com.tec.mathsockets.states.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tec.mathsockets.states.game.tiles.StartTile;
import com.tec.mathsockets.states.game.tiles.Tile;

import java.util.ArrayList;
import java.util.Random;

public class Board {

    public static String TAG = Board.class.getSimpleName();
    private Random random = new Random();

    public enum BoardSize {
        SMALL,
        MEDIUM,
        BIG
    }

    public ArrayList<Tile> boardNodes;
    private int totalTiles;


    public Board(BoardSize boardSize) {
        boardNodes = new ArrayList<Tile>();
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
        int tileCount = 0;
        int x = 0;
        int y = 700;
        for (Tile tile: boardNodes) {
            if (tileCount % totalTiles == 0 && tileCount != 0) {
                batch.draw(tile.getTileTexture(), x, y, tileWidth, tileHeigth);
                y -= tileHeigth;
            } else {
                batch.draw(tile.getTileTexture(), x, y, tileWidth, tileHeigth);
                x += tileWidth;
            }

        }
    }

    public void dispose() {
        boardNodes.removeAll(boardNodes);
    }

}
