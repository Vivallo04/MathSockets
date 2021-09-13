package com.tec.mathsockets.states.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.tec.mathsockets.MathSockets;
import com.tec.mathsockets.entity.Entity;
import com.tec.mathsockets.states.State;
import com.tec.mathsockets.util.Utility;

public class GameState extends State {

    private static final String TAG = GameState.class.getSimpleName();
    private MathSockets game;

    private static class VIEWPORT {
        static float viewportWidth;
        static float viewportHeight;
        static float virtualWidth;
        static float virtualHeight;
        static float physicalWidth;
        static float physicalHeight;
        static float aspectRatio;
    }

    private TextureRegion currentPlayerFrame;
    private Sprite currentPlayerSprite;

    private final OrthogonalTiledMapRenderer mapRenderer = null;
    private OrthographicCamera camera = null;

    private static Board board;

    private final Texture background;
    private int backgroundX = 0;


    private final String defaultBackgroundPath = "backgrounds/background1.png";
    private static Entity player;


    /**
     * Constructor
     */
    public GameState(MathSockets game) {
        this.game = game;

        // load textures
        Utility.loadTextureAsset(defaultBackgroundPath);
        background = Utility.getTextureAsset(defaultBackgroundPath);

        board = new Board(Board.BOARD_SIZE.BIG);
    }


    /**
     * Called when this screen becomes the current screen for a {@link Game}.
     */
    @Override
    public void show() {
        // camera setup
        setupViewport(10, 10);

        // get the current size
        camera = new OrthographicCamera();
        camera.setToOrtho(false, VIEWPORT.viewportWidth, VIEWPORT.viewportHeight);
    }

    /**
     * Called when the screen should render itself.
     *
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        int backgroundY = 0;
        game.batch.draw(background, backgroundX, backgroundY, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //game.batch.draw(background, backgroundX + Gdx.graphics.getWidth(), backgroundY, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        //nt backgroundVelocity = 1;
        //backgroundX -= backgroundVelocity;

        //if ((backgroundX  + Gdx.graphics.getWidth()) == 0)
           // backgroundX = 0;


        board.render(game.batch);
        game.batch.end();
    }


    public void setupViewport(int with, int height) {

    }


    @Override
    public void resize(int width, int height) {

    }


    /**
     *  Pause the game
     */
    @Override
    public void pause() {

    }


    /**
     * Go back to the previous state when paused
     */
    @Override
    public void resume() {

    }


    /**
     * Called when this screen is no longer the current screen for a {@link Game}.
     */
    @Override
    public void hide() {

    }


    /**
     * Called when this screen should release all resources.
     */
    @Override
    public void dispose() {
        //Utility.unloadAsset(defaultBackgroundPath);
    }
}
