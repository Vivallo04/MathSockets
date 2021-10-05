package com.tec.mathsockets.states.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.tec.mathsockets.MathSockets;
import com.tec.mathsockets.states.State;
import com.tec.mathsockets.util.StateMachine;
import com.tec.mathsockets.util.Utility;

public class MainMenuState extends State {

    private final String defaultBackgroundPath = "backgrounds/background1.png";

    private MathSockets game;
    private Skin skin;
    private Stage stage;
    private TextureAtlas textureAtlas;

    private final OrthogonalTiledMapRenderer mapRenderer = null;
    private OrthographicCamera camera = null;

    private Texture[] backgroundParallaxTexturesArray = new Texture[5];
    private final Texture background;

    private int backgroundX = 0;

    public MainMenuState(MathSockets game) {
        this.game = game;

        textureAtlas = new TextureAtlas(Gdx.files.internal("uiskin.atlas"));

        loadBackgroundSprites();

        Utility.loadTextureAsset(defaultBackgroundPath);
        background = Utility.getTextureAsset(defaultBackgroundPath);


     }

    @Override
    public void show() {
        super.show();

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        game.getBatch().begin();

        //renderParallaxBackground();

        Table table = new Table();
        table.setPosition(0,0);

        table.setFillParent(true);
        table.setHeight(500);
        table.setHeight(500);
        super.addActor(table);

        Label Welcome_message = new Label("WELCOM TO MENU", getSkin());
        Welcome_message.setPosition(620, 600);
        Welcome_message.setWidth(200);
        Welcome_message.setHeight(40);

        table.addActor(Welcome_message);

        // Botón para ir el juego
        TextButton Play_button = new TextButton("Jugar", getSkin());
        Play_button.setPosition(600, 500);
        Play_button.setWidth(200);
        Play_button.setHeight(40);
        // acción
        Play_button.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                game.currentState = StateMachine.StateType.GAME_STATE;
                System.out.println("Estado actual: " + game.currentState);

                return false;
            }
        });

        table.addActor(Play_button);

        // Botón para ingresar a la sección de ayuda
        TextButton Help_button = new TextButton("Ayuda", getSkin());
        Help_button.setPosition(600, 400);
        Help_button.setWidth(200);
        Help_button.setHeight(40);
        // acción
        Help_button.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                game.currentState = StateMachine.StateType.HELP_STATE;
                System.out.println("Estado actual: " + game.currentState);

                return false;
            }
        });

        table.addActor(Help_button);

        // Botón para ingresar a los ajustes
        TextButton Settings_button = new TextButton("Ajustes", getSkin());
        Settings_button.setPosition(600, 300);
        Settings_button.setWidth(200);
        Settings_button.setHeight(40);
        // acción
        Settings_button.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                game.currentState = StateMachine.StateType.SETTINGS_STATE;
                System.out.println("Estado actual: " + game.currentState);

                return false;
            }
        });

        table.addActor(Settings_button);

        // Botón para ingresar al about
        TextButton About_button = new TextButton("About", getSkin());
        About_button.setPosition(600, 200);
        About_button.setWidth(200);
        About_button.setHeight(40);
        // acción
        About_button.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                game.currentState = StateMachine.StateType.ABOUT_STATE;
                System.out.println("Estado actual: " + game.currentState);

                return false;
            }
        });

        table.addActor(About_button);

        game.getBatch().end();


    }

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

    protected Skin getSkin(){

        if (skin == null){
            skin = new Skin(Gdx.files.internal("uiskin.json"),textureAtlas);

        }
        return skin;
    }
}
