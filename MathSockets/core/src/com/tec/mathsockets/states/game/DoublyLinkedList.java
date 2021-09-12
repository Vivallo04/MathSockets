package com.tec.mathsockets.states.game;

import com.tec.mathsockets.states.game.tiles.NTile;
import com.tec.mathsockets.states.game.tiles.Tile;

public class DoublyLinkedList {

    private NTile head = null;
    private NTile tail = null;

    public void addTile(Tile tile) {
        NTile newTile = new NTile(tile);

        if (head == null) {
            head = newTile;
            tail = head;
            head.previous = null;
        } else {
            tail.next = newTile;
            newTile.previous = tail;
            tail = newTile;
        }
        tail.next = null;
    }

    public void printNTiles() {
        NTile current = head;

        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        while (head != null) {
            System.out.println(current.getTile());
        }
    }


}
