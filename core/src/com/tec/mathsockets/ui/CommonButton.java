package com.tec.mathsockets.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.tools.flame.EventManager;
import com.tec.mathsockets.MathSockets;
import com.tec.mathsockets.states.State;

public class CommonButton extends ClickListener implements EventManager.Listener {

    private final MathSockets game;
    private State state;
    private int x, y;
    private int width, height;

    private Texture buttonTexture;

    public CommonButton(MathSockets game, State state, int x, int y, int width, int height) {
        this.game = game;
        this.state = state;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    private void init() {

    }

    public void render() {

    }

    @Override
    public void handle(int aEventType, Object aEventData) {

    }

    public void dispose() {

    }


}
