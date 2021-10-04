package com.tec.mathsockets.states.challenge;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.tec.mathsockets.MathSockets;
import com.tec.mathsockets.states.State;
import com.tec.mathsockets.util.Utility;
import org.graalvm.compiler.core.common.util.Util;


public class ChallengeState extends State {

    private final MathSockets game;

    private ShapeRenderer shapeRenderer;
    public SpriteBatch batch;
    Table table;

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
        batch = new SpriteBatch();
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

        button = new TextButton("Verify", Utility.UI_Skin);
        button.setPosition(0,0);
        button.setSize(15, 10);


        //text = new TextField("Hello", Utility.UI_Skin);
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
        super.addActor(table);
        super.addActor(button);
        //super.addActor(text);
    }

    @Override
    public void dispose() {
        super.dispose();
    }


}