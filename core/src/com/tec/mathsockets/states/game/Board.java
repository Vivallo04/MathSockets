package com.tec.mathsockets.states.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tec.mathsockets.states.game.tiles.StartTile;
import com.tec.mathsockets.states.game.tiles.Tile;

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
        int currentNode = 0;
        int i = 1; // x pos
        int j = 1; // y pos
        for (Tile tile: boardNodes) {

            int x = i * tile.getWIDTH();
            int y = j * tile.getHEIGHT();

            // in-line
            if (boardNodes.size() % i == 0 && i != 1) {
                batch.draw(tile.getTileTexture(), x - 80,
                        (Gdx.graphics.getHeight() - y) - tile.getHEIGHT() / 2, tile.getWIDTH(), tile.getHEIGHT());
                currentNode++;
                tile.addCenterNode(x / 2, y / 2);
                j++;
                i = 1;
            } else {
                batch.draw(tile.getTileTexture(), x - 80,
                        (Gdx.graphics.getHeight() - y) - tile.getHEIGHT() / 2, tile.getWIDTH(), tile.getHEIGHT());
                currentNode++;
                tile.addCenterNode(x / 2, y / 2);
                i++;
            }
        }

    }


    /** Remove all the nodes of the DoublyLinkedList */
    public void dispose() {
        boardNodes.removeAll(boardNodes);
    }


}
