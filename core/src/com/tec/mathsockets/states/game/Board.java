package com.tec.mathsockets.states.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tec.mathsockets.states.game.tiles.*;
import com.tec.mathsockets.util.Utility;

import java.util.LinkedList;
import java.util.Random;

public class Board {

    public static String TAG = Board.class.getSimpleName();

    public static enum BoardSize {
        SMALL,
        MEDIUM,
        BIG
    }


    private LinkedList<Tile> boardNodes;
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


    /**
     * Add random tiles to @boardNodes until the tile count
     * is equal totalTiles
     */
    public void populateBoard() {
        int tileCount = 0;

        while(tileCount < totalTiles) {
            int rNum = Utility.random.nextInt(50 + 1);
            if (tileCount == 0) {
                boardNodes.add(new StartTile());
                tileCount++;
            }
            if (tileCount == totalTiles - 1) {
                boardNodes.add(new WinTile());
                Gdx.app.debug(TAG, "Board has been populated with: " + boardNodes.size() + " nodes");
                return;
            }

            if (Utility.inRange(rNum, 0, 25)){
                boardNodes.add(new ChallengeTile());
            } else if (Utility.inRange(rNum, 26, 38)) {
                boardNodes.add(new TunnelTile());
            } else {
                boardNodes.add(new TrapTile());
            }
            tileCount++;
        }
    }


    public void render(SpriteBatch batch) {
        int currentNode = 0;
        int offset = 80;
        int i = 1; // x pos
        int j = 1; // y pos
        for (Tile tile: boardNodes) {
            int x = i * tile.getWIDTH();
            int y = j * tile.getHEIGHT();

            // in-line
            if (boardNodes.size() % i == 0 && i != 1) {
                batch.draw(tile.getTileTexture(), x - offset, (Gdx.graphics.getHeight() - y) - tile.getHEIGHT() / 2,
                        tile.getWIDTH(), tile.getHEIGHT());
                tile.addCenterNode((x - offset) + (tile.getWIDTH() / 2) , y / 2);
                currentNode++;
                j++;
                i = 1;
            } else {
                batch.draw(tile.getTileTexture(), x - offset, (Gdx.graphics.getHeight() - y) - tile.getHEIGHT() / 2,
                        tile.getWIDTH(), tile.getHEIGHT());
                tile.addCenterNode((x - offset) + (tile.getWIDTH() / 2), y / 2);
                currentNode++;
                i++;
            }
        }
    }


    /** Remove all the nodes of the DoublyLinkedList */
    public void dispose() {
        boardNodes.removeAll(boardNodes);
    }


}
