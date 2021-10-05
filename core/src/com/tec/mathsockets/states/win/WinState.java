package com.tec.mathsockets.states.win;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.tec.mathsockets.MathSockets;
import com.tec.mathsockets.states.State;
import com.tec.mathsockets.util.Utility;

public class WinState extends State {

    private final MathSockets game;

    private final String backgroundPath = "ui/winBackground.png";
    private Texture background;


    public WinState(MathSockets game) {
        this.game = game;
        init();
        background = Utility.getTextureAsset(backgroundPath);
    }

    private void init() {
        Utility.loadTextureAsset(backgroundPath);
    }


    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        game.getBatch().begin();
        game.getBatch().draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        game.getBatch().end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
