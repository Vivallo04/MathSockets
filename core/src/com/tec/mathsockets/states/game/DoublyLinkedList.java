package com.tec.mathsockets.states.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.tec.mathsockets.states.game.tiles.Tile;

public class DoublyLinkedList {
/*
    private final String TAG = this.getClass().getSimpleName();

    public Array<Texture> textures;

    private NTile head = null;
    private int size = 0;


    public void push(Tile tile){
        NTile newNode = new NTile(tile);
        newNode.next = head;
        newNode.previous = null;

        if (head != null) {
            head.previous = newNode;
            size++;
            return;
        }
        head = newNode;
        size++;
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
            size++;
        }
    }

    public void append(Tile new_data) {
        NTile newNode = new NTile(new_data);
        NTile last = head;
        newNode.next = null;

        if (head == null) {
            newNode.previous = null;
            head = newNode;
            size++;
            return;
        }

        while(last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        newNode.previous = last;
        size++;
    }

    public void printList() {
        NTile last = null;
        while (head != null) {
            System.out.print(head.getTile().getTileType());
            last = head;
            head = head.next;
        }
        System.out.print("List size: " + size);
    }

    public void addTileTextureToMemory() {
        if (size == 0) {
            throw new RuntimeException("The list is invalid;");
        }
        NTile last = null;

        while (head != null) {
            Texture currentTileTexture = head.getTile().getTileTexture();
            textures.add(currentTileTexture);
            head = head.next;
        }
    }

*/
}
