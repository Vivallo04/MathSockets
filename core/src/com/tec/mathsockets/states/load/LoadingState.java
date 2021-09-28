package com.tec.mathsockets.states.load;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.tec.mathsockets.MathSockets;
import com.tec.mathsockets.states.State;
import com.tec.mathsockets.states.game.GameState;
import com.tec.mathsockets.states.menu.MainMenuState;
import com.tec.mathsockets.util.Utility;

public class LoadingState extends State {

    private final MathSockets game;

    public static GameState gameState;
    private float timeSeconds = 0f;
    private float period = 0.003f;
    private float alpha = 0f;

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

        //Gdx.gl.glEnable(GL20.GL_ARRAY_BUFFER_BINDING);
        game.getBatch().begin();
        displayLogo.draw(game.getBatch());

        // set logo position X and Y
        displayLogo.setX((Gdx.graphics.getWidth() - displayLogo.getWidth()) / 2f);
        displayLogo.setY((Gdx.graphics.getHeight() - displayLogo.getHeight()) / 2f);

        game.getBatch().end();
        displayLogo.setAlpha(alpha);

        timeSeconds += Gdx.graphics.getDeltaTime();
        System.out.println(timeSeconds);
        if (timeSeconds > period) {
            alpha += period;
            timeSeconds -= period;

            if (alpha >= 1) {
                alpha = 1f;
                if(timeSeconds >= 7){
                    System.out.println("tiempo de espera terminó");
                    game.setScreen(new MainMenuState(game));
                    dispose();
                }
            }
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        Utility.unloadAsset(logoPath);
    }
}
