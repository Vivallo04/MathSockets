package com.tec.mathsockets.states.challenge;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.tec.mathsockets.MathSockets;
import com.tec.mathsockets.states.State;


import java.awt.*;

public class ChallengeState extends State {

    private final MathSockets game;
    private ShapeRenderer shapeRenderer;
    public SpriteBatch batch;
    private BitmapFont font;
    private Skin skin;
    private Stage stage;
    Table table;

    TextField text;
    TextButton button;

    /**
     *
     * @param game
     */
    public ChallengeState(MathSockets game) {
        this.game = game;
        create();
    }

    /**
     * Create different instances
     */
    public void create() {
        shapeRenderer = new ShapeRenderer();
        font = new BitmapFont();
        batch = new SpriteBatch();
        stage = new Stage();
        skin = new Skin(Gdx.files.internal("ui_skin.json"));
        table = new Table();

    }

    /**
     * Initialize the rectangle and shows the problem
     * @param delta
     */
    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        int offset = 60;

        
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(offset / 2, offset / 2, (Gdx.graphics.getWidth() - offset), (Gdx.graphics.getHeight() - offset));
        shapeRenderer.end();

        batch.begin();
            font.draw(batch, Challenge.getProblem(), 550, 500);
        batch.end();
    }

    /**
     * Initialize the button with its function and the TextField
     */
    @Override
    public void show() {
        super.show();


        table.setFillParent(true);
        table.top();

        button = new TextButton("Verify", skin);
        button.setPosition(0,0);
        button.setSize(15, 10);


        //text = new TextField("Hola", skin);
        //text.setPosition(15,15);
        //text.setSize(300, 40);

        /**
         * Button functionality: Comparing the correct result to the one entered by the player
         */
        button.addListener(new ClickListener(){
           @Override
           public void clicked(InputEvent event, float x, float y) {
               System.out.println("Hola");
               //String userResult = text.getText(); // Getting what the player
               //boolean b = Integer.valueOf(userResult) == Challenge.getResult();
           }
       });
        table.add(button);
        stage.addActor(table);
        stage.addActor(button);
        //stage.addActor(text);
    }

    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();
        skin.dispose();

    }


}