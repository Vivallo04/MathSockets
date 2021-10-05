package com.tec.mathsockets.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
//import sun.awt.X11.XPopupMenuPeer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends ClickListener implements ActionListener {

    private final int xPos;
    private final int yPos;
    private final int width;
    private final int height;

    private String buttonLabel;
    private Texture buttonTexture;

    public Button(String buttonLabel, int xPos, int yPos, int width, int height) {
        this.buttonLabel = buttonLabel;
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
    }

    public Button(Texture texture, int xPos, int yPos, int width, int height) {
        this.buttonTexture = texture;
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
    }

    public void render() {

    }

    public void dispose() {

    }

    /**
     * Invoked when an action occurs.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
