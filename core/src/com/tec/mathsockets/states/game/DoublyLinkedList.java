package com.tec.mathsockets.states.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tec.mathsockets.states.game.tiles.NTile;
import com.tec.mathsockets.states.game.tiles.Tile;

public class DoublyLinkedList {

    private final String TAG = this.getClass().getSimpleName();
    private NTile head = null;


    public void push(Tile tile){
        NTile newNode = new NTile(tile);
        newNode.next = head;
        newNode.previous = null;

        if (head != null) {
            head.previous = newNode;
        }
        head = newNode;
    }


    public void insertAfter(NTile previousNode, Tile tile) throws Exception {
        if (previousNode == null) {
            throw new Exception("Previous node cannot be null");
        }

        NTile newNode = new NTile(tile);
        newNode.next = previousNode.next;
        previousNode.next = newNode;
        newNode.previous = previousNode;

        if (newNode.next != null) {
            newNode.next.previous = newNode;
        }
    }


    public void append(Tile new_data) {
        NTile newNode = new NTile(new_data);
        NTile last = head;
        newNode.next = null;

        if (head == null) {
            newNode.previous = null;
            head = newNode;
            return;
        }

        while(last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        newNode.previous = last;
    }


    public void printList() {
        NTile last = null;
        while (head != null) {
            System.out.print(head.getTile().getTileType());
            last = head;
            head = head.next;
        }
    }

    public void renderBoard(SpriteBatch batch, int totalTiles) {
        NTile last = null;
        int xPos = 50;
        int yPos = 50;

        while (head != null) {
            if ((head.getTile().getTileCount() % totalTiles == 0) && totalTiles != 0) {
                head.getTile().setxPos(yPos + head.getTile().getHeight());
            }
            batch.draw(head.getTile().getTileTexture(), xPos, yPos, 32, 32);
            last = head;
            head = head.next;
        }
    }


}
