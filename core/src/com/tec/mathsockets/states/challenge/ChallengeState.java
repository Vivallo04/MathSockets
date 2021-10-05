package com.tec.mathsockets.states.challenge;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.tec.mathsockets.MathSockets;
import com.tec.mathsockets.states.State;
import com.tec.mathsockets.util.Utility;

import java.util.Random;

import static com.tec.mathsockets.states.challenge.Challenge.getProblem;
import static com.tec.mathsockets.states.challenge.Challenge.getResult;
import static com.tec.mathsockets.util.Utility.UI_Skin;


public class ChallengeState extends State {

    private final MathSockets game;

    private ShapeRenderer shapeRenderer;
    public SpriteBatch batch;
    private BitmapFont font;
    private BitmapFont font2;
    private Table table;
    private Label math_challenge;
    private TextButton button;
    private TextField text;
    TextButton button1;
    TextButton button2;
    //Challenge challenge;


    private int obtener(){
        int decision = (int) (Math.random() * 2 + 1);
        return decision;

    }


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
        font2 = new BitmapFont();
        batch = new SpriteBatch();
        table = new  Table();
        //challenge = new Challenge();



    }

    /**
     * Initialize the rectangle and shows the problem
     * @param delta
     */
    @Override
    public void render(float delta) {
        super.render(delta);
        int offset = 60;


       // String backgroungPath = "backgrounds/backgroundChallenge.png";
       // Utility.loadTextureAsset(backgroungPath);
       // Texture background = Utility.getTextureAsset(backgroungPath);

        table.setFillParent(true);
        table.setPosition(0,0);
        table.setHeight((Gdx.graphics.getHeight() - offset));
        table.setWidth(Gdx.graphics.getWidth() - offset);
        super.addActor(table);

        String hji = getProblem();
        game.getBatch().begin();
        batch.begin();
        font.draw(batch, "El problema a resolver es: " + hji, 200, 700);
        font.setColor(Color.BLUE);
        font.getData().setScale(2,2);
        batch.end();
        game.getBatch().end();




    }

    @Override
    public void show() {
        super.show();

        final int num = obtener();
        if (num == 1){
            button1 = new TextButton("El resultado es "+ getResult(), UI_Skin);
            button2 = new TextButton("El resultado es " + (getResult() + (int) (Math.random() * 10 + 1)), UI_Skin);

        }else{
            button1 = new TextButton("El resultado es " + (getResult() - (int) (Math.random() * 10 + 1)), UI_Skin);
            button2 = new TextButton("El resultado es "+ getResult(), UI_Skin);


        }
        button1.setPosition(500,500);
        button1.setSize(15, 10);
        button2.setPosition(500,450);
        button2.setSize(15, 10);
        super.addActor(button1);
        super.addActor(button2);

        /**
         * DiceButton functionality: Comparing the correct result to the one entered by the player
         */
        button1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (num == 1){
                    System.out.println("Puedes avanzar una casilla");
                }else{
                    System.out.println("Te debes quedar donde estás");
                }
            }
        });

        button2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (num == 2){
                    System.out.println("Puedes avanzar una casilla");
                }else{
                    System.out.println("Te debes quedar donde estás");
                }

            }
        });
    }



    @Override
    public void dispose() {
        super.dispose();
    }


}