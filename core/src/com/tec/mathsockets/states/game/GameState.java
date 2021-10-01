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

import java.io.IOException;
import java.util.HashMap;


public class GameState extends State {

    // TODO: PLAYER TRAVERSE GAME BOARD => Dice
    //       CHANGE FIELD'S NAMES
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

    // Parallax background sprites
    private Texture[] backgroundParallaxTexturesArray = new Texture[5];
    private final Texture background;
    private int backgroundX = 0;


    /**
     * Load textures and initialize the game Board
     * @author Andrés Vivallo
     */
    public GameState(final MathSockets game) {
        this.game = game;

        loadBackgroundSprites();

        Utility.loadTextureAsset(defaultBackgroundPath);
        background = Utility.getTextureAsset(defaultBackgroundPath);
        board = new Board(Board.BoardSize.MEDIUM);
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
        super.render(delta);
        game.getBatch().begin();

        renderParallaxBackground();
        board.render(game.getBatch());

        game.getBatch().end();
    }

    // ---------------------------------- PARALLAX BACKGROUND -----------------------------
    public void loadBackgroundSprites() {
        String skyPath = "backgrounds/sky.png";
        String clouds1Path = "backgrounds/clouds_bg.png";
        String clouds2Path = "backgrounds/clouds_mg_3.png";
        String clouds3Path = "backgrounds/clouds_mg_2.png";
        String clouds4Path = "backgrounds/clouds_mg_1.png";
        String mountainsPath = "backgrounds/glacial_mountains.png";
        // Load textures
        Utility.loadTextureAsset(skyPath);
        Utility.loadTextureAsset(clouds1Path);
        Utility.loadTextureAsset(clouds2Path);
        Utility.loadTextureAsset(clouds3Path);
        Utility.loadTextureAsset(clouds4Path);
        Utility.loadTextureAsset(mountainsPath);
    }

    public void renderParallaxBackground() {
        game.getBatch().draw(background, backgroundX, 0,
                Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.getBatch().draw(background, backgroundX + Gdx.graphics.getWidth(), 0,
                Gdx.graphics.getWidth(), Gdx.graphics.getHeight());


        // Scrolling Background
        int backgroundVelocity = 1;
        backgroundX -= backgroundVelocity;
        if ((backgroundX + Gdx.graphics.getWidth()) == 0) backgroundX = 0;
    }


    //----------------------------------------------------------------------------
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
        Utility.unloadAsset(defaultBackgroundPath);
        board.dispose();
    }

}
