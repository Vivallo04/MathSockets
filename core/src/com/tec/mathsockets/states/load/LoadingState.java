package com.tec.mathsockets.states.load;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.tec.mathsockets.MathSockets;
import com.tec.mathsockets.states.State;
import com.tec.mathsockets.util.Utility;

public class LoadingState extends State {

    private final MathSockets game;

    private float timeSeconds = 0f;
    private float period = 0.1f;

    private final String logoPath = "design/logo.png";
    private final ShapeRenderer shapeRenderer = new ShapeRenderer();
    private final Texture logoAsset;
    private final Sprite displayLogo;
    private final Rectangle rectangle;


    public LoadingState(MathSockets game) {
        this.game = game;
        Utility.loadTextureAsset(logoPath);
        logoAsset = Utility.getTextureAsset(logoPath);
        displayLogo = new Sprite(logoAsset);
        rectangle = new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }


    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(255, 255, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glEnable(GL20.GL_ARRAY_BUFFER_BINDING);

        int logoWidth = logoAsset.getWidth();
        int logoHeight = logoAsset.getHeight();

        timeSeconds += Gdx.graphics.getDeltaTime();
        if (timeSeconds > period) {
            timeSeconds -= period;
            System.out.println(":)");
        }

        /*shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        shapeRenderer.setColor(new Color((0 + timeSeconds) / 2, (0 + timeSeconds) / 2, (0 + timeSeconds) / 2, 1));
        shapeRenderer.end();

        game.getBatch().draw(displayLogo, (Gdx.graphics.getWidth() - logoWidth) /2f,
                (Gdx.graphics.getHeight() - logoHeight) /2f);*/

        game.getBatch().begin();
        displayLogo.draw(game.getBatch());
        displayLogo.setX((Gdx.graphics.getWidth() - displayLogo.getWidth())/2f);
        displayLogo.setY((Gdx.graphics.getHeight() - displayLogo.getHeight())/2f);

        game.getBatch().end();
        displayLogo.setAlpha(1);
    }


    @Override
    public void dispose() {
        super.dispose();
        Utility.unloadAsset(logoPath);
        shapeRenderer.dispose();
    }
}
