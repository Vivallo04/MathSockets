package com.tec.mathsockets.states.load;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.tec.mathsockets.MathSockets;
import com.tec.mathsockets.states.State;
import com.tec.mathsockets.util.Utility;

public class LoadingState extends State {

    private final MathSockets game;

    private float timeSeconds = 3f;
    private float period = 0.003f;
    private float alpha = 0.1f;

    private final String logoPath = "design/logo.png";
    private final Texture logoAsset;
    private final Sprite displayLogo;


    public LoadingState(MathSockets game) {
        this.game = game;
        Utility.loadTextureAsset(logoPath);
        logoAsset = Utility.getTextureAsset(logoPath);
        displayLogo = new Sprite(logoAsset);
    }


    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glEnable(GL20.GL_ARRAY_BUFFER_BINDING);

        timeSeconds += Gdx.graphics.getDeltaTime();
        if (timeSeconds > period) {
            alpha += period;
            timeSeconds -= period;
        }

        game.getBatch().begin();
        displayLogo.draw(game.getBatch());

        // set logo position X and Y
        displayLogo.setX((Gdx.graphics.getWidth() - displayLogo.getWidth()) / 2f);
        displayLogo.setY((Gdx.graphics.getHeight() - displayLogo.getHeight()) / 2f);

        game.getBatch().end();
        displayLogo.setAlpha(alpha);
    }


    @Override
    public void dispose() {
        super.dispose();
        Utility.unloadAsset(logoPath);
    }
}
