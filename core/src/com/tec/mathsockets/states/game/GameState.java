package com.tec.mathsockets.states.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.tec.mathsockets.MathSockets;
import com.tec.mathsockets.entity.Entity;
import com.tec.mathsockets.entity.Player;
import com.tec.mathsockets.states.State;
import com.tec.mathsockets.util.Utility;


public class GameState extends State {

    // TODO: ADD SPRITES & ANIMATIONS || IMPLEMENT SPRITESHEET WITH ANIMATIONS
    //       ADD PLAYERS TO GAME
    //       PARSE JSON FILES
    //       ADD PLAYER'S INFO


    private final String defaultBackgroundPath = "backgrounds/background1.png";
    private static final String TAG = GameState.class.getSimpleName();

    private final MathSockets game;

    private static class VIEWPORT {
        static float viewportWidth;
        static float viewportHeight;
        static float virtualWidth;
        static float virtualHeight;
        static float physicalWidth;
        static float physicalHeight;
        static float aspectRatio;
    }


    private final OrthogonalTiledMapRenderer mapRenderer = null;
    private OrthographicCamera camera = null;

    private static Board board;

    private final Texture background;
    private int backgroundX = 0;

    private Player player;


    /**
     * Load textures and initialize the game Board
     * @author Andrés Vivallo
     */
    public GameState(final MathSockets game) {
        this.game = game;

        // Load textures
        Utility.loadTextureAsset(defaultBackgroundPath);
        background = Utility.getTextureAsset(defaultBackgroundPath);
        board = new Board(Board.BoardSize.MEDIUM);
        player = new Player();
    }


    /**
     * Called when this screen becomes the current screen for a {@link Game}.
     */
    @Override
    public void show() {
        // camera setup
        setupViewport(20, 20);

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

        game.getBatch().begin();

        game.getBatch().draw(background, backgroundX, 0,
                Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.getBatch().draw(background, backgroundX + Gdx.graphics.getWidth(), 0,
                Gdx.graphics.getWidth(), Gdx.graphics.getHeight());


        // Scrolling Background
        int backgroundVelocity = 1;
        backgroundX -= backgroundVelocity;
        if ((backgroundX + Gdx.graphics.getWidth()) == 0) backgroundX = 0;

        board.render(game.getBatch());
        player.render(game.getBatch(), 50, 50);
        game.getBatch().end();
    }


    public void setupViewport(int with, int height) {

    }


    public SpriteBatch getGameStateBatch() {
        return this.game.getBatch();
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
        Utility.unloadAsset(defaultBackgroundPath);
        board.dispose();
    }

}
