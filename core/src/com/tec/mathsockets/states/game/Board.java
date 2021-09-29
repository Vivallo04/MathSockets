package com.tec.mathsockets.states.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.tec.mathsockets.entity.Player;
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

    public LinkedList<Tile> boardNodes;
    private int totalTiles;

    private ShapeRenderer shapeRenderer;
    private Player player;


    /**
     * Generate the game board according the selected size
     * @param boardSize integer (small, medium, big)
     */
    public Board(BoardSize boardSize) {
        boardNodes = new LinkedList<Tile>();
        shapeRenderer = new ShapeRenderer();
        player = new Player(this);

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

    /**
     * Interface for rendering all the Board's components
     * @param batch GameState's sprite batch
     */
    public void render(SpriteBatch batch) {
        renderGraphics(batch);
        player.render(batch);
    }

    /**
     * Render the board with pseudo-random tiles on the GameState Screen
     * @param batch Game's sprite batch
     */
    public void renderGraphics(SpriteBatch batch) {
        int currentNode = 0;
        int offsetX = 80;
        int offsetY = 65;
        int i = 1; // x pos
        int j = 1; // y pos
        for (Tile tile: boardNodes) {
            int x = i * tile.getWIDTH();
            int y = Gdx.graphics.getHeight() - (j * tile.getHEIGHT());

            // in-line
            if (boardNodes.size() % i == 0 && i != 1) {
                batch.draw(tile.getTileTexture(), x - offsetX, y - (tile.getHEIGHT() / 2),
                        tile.getWIDTH(), tile.getHEIGHT());

                tile.addCenterNode((x - offsetX) + (tile.getWIDTH() / 2) , (y - offsetY) + (tile.getHEIGHT()/ 2));
                currentNode++;
                i = 1;
                j++;
            } else {
                batch.draw(tile.getTileTexture(), x - offsetX, y - (tile.getHEIGHT() / 2),
                        tile.getWIDTH(), tile.getHEIGHT());

                tile.addCenterNode((x - offsetX) + (tile.getWIDTH() / 2),(y - offsetY) + (tile.getWIDTH() / 2));
                currentNode++;
                i++;
            }
        }
    }

    /**
     * Render center nodes for debugging purposes
     */
    private void renderCenterNodes() {
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for (Tile tile: boardNodes) {
            int x = (int) tile.getCenterNode().x;
            int y = (int) tile.getCenterNode().y;
            shapeRenderer.circle(x, y, 12);
        }
        shapeRenderer.end();

    }

    /** Remove all the nodes of the DoublyLinkedList */
    public void dispose() {
        boardNodes.removeAll(boardNodes);
        player.dispose();
    }


}
