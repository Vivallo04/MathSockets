package com.tec.mathsockets.states.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tec.mathsockets.states.game.tiles.StartTile;

import javax.print.attribute.standard.RequestingUserName;
import java.util.Random;

public class Board {

    public static String TAG = Board.class.getSimpleName();
    public static enum BOARD_SIZE {
        SMALL,
        MEDIUM,
        BIG
    }

    public DoublyLinkedList boardTiles;
    private Random random = new Random();
    private int totalTiles;


    public Board(BOARD_SIZE boardSize) {
        boardTiles = new DoublyLinkedList();
        if (boardSize == BOARD_SIZE.SMALL) {
            totalTiles = 16;
        } else if (boardSize == BOARD_SIZE.MEDIUM) {
            totalTiles = 25;
        } else {
            totalTiles = 36;
        }

    }




    public void populateBoard() {
        int tileCount = 0;

        int randomNumber = random.nextInt(10 - 1) + 1;
        System.out.println(randomNumber);

        for (int i = 0; i < 32; i++) {
            boardTiles.append(new StartTile());
        }

        boardTiles.printList();
    }

    public void render(SpriteBatch batch) {
        populateBoard();
        boardTiles.renderBoard(batch, this.totalTiles);
    }

    public void dispose() {

    }


}
