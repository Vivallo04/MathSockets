package com.tec.mathsockets.states.load;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.tec.mathsockets.MathSockets;
import com.tec.mathsockets.states.State;
import com.tec.mathsockets.util.Utility;

public class LoadingState extends State {

    private final MathSockets game;

    private float timeSeconds = 0f;
    private float period = 30f;

    private final String logoPath = "logo.png";
    private final ShapeRenderer shapeRenderer = new ShapeRenderer();
    private Texture logo;
    private Rectangle rectangle;

    // TODO: FADE (CHANGE OPACITY)
    //       CHANGE STATE
    public LoadingState(MathSockets game) {
        this.game = game;
        Utility.loadTextureAsset(logoPath);
        logo = Utility.getTextureAsset(logoPath);
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

        timeSeconds += Gdx.graphics.getDeltaTime();
        if (timeSeconds > period) {
            timeSeconds -= period;
            System.out.println(":)");
        }

        int logoWidth = logo.getWidth();
        int logoHeight = logo.getHeight();


        game.getBatch().enableBlending();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        shapeRenderer.setColor(new Color((0 + timeSeconds) / 5, (0 + timeSeconds) / 5, (0 + timeSeconds) / 5, 1));
        shapeRenderer.end();


        game.getBatch().begin();
        game.getBatch().draw(logo, (Gdx.graphics.getWidth() - logoWidth) / 2,
                (Gdx.graphics.getHeight() - logoHeight)/2);


        Gdx.gl.glDisable(GL20.GL_BLEND);
        game.batch.end();


    }

    @Override
    public void dispose() {
        super.dispose();
        shapeRenderer.dispose();
    }
}
