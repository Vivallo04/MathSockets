package com.tec.mathsockets.states.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tec.mathsockets.states.game.tiles.StartTile;

import javax.print.attribute.standard.RequestingUserName;
import java.util.Random;

public class Board {

    public static String TAG = Board.class.getSimpleName();
    private Random random = new Random();

    public enum BOARD_SIZE {
        SMALL,
        MEDIUM,
        BIG
    }

    public DoublyLinkedList boardTiles;
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

        while(tileCount < totalTiles) {
            boardTiles.append(new StartTile());
            tileCount++;
        }
        boardTiles.printList();
    }


    public void render() {
        populateBoard();
        boardTiles.renderBoard(this.totalTiles);
    }


    public void dispose() {

    }


}
