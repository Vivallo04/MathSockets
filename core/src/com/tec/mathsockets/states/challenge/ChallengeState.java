package com.tec.mathsockets.states.challenge;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.tec.mathsockets.MathSockets;
import com.tec.mathsockets.states.State;

import java.awt.*;

public class ChallengeState extends State {

    private final MathSockets game;
    private ShapeRenderer shapeRenderer;
    public SpriteBatch batch;
    private BitmapFont font;
    private TextField text;

    private Stage stage;


    public ChallengeState(MathSockets game) {
        this.game = game;
        create();

    }

    public void create() {

        shapeRenderer = new ShapeRenderer();
        font = new BitmapFont();
        batch = new SpriteBatch();
        stage = new Stage();
        //TextButton verifButton = new TextButton("Hola");
        //verification.setPosition(x, x);
        //verification.setSize(x, x);

        text = new TextField("");
        //text.setPosition(x, x);
        //text.setSize(x, x);
    }


    @Override
    public void render(float delta) { //Aquí se crea la nueva ventana y se le agregan los datos
        super.render(delta); //Heredo el método render de State
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        int offset = 60;

        //Crear el rectángulo con la pregunta y el campo para ingresar los datos
        //después verifica si el resultado es el correcto y procede con el juego
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(offset / 2, offset / 2, (Gdx.graphics.getWidth() - offset), (Gdx.graphics.getHeight() - offset));
        shapeRenderer.end();
        batch.begin();
            //font.draw(batch, problem, 550, 500);
            //font.draw(batch, "Número 1: "+ numeros.getNum1(), 500, 530);
            //font.draw(batch, "Número 2: "+ numeros.getNum2(), 550, 530);
        batch.end();
        //Agregarlo en la ventana, sobre el rectángulo.
        //Agregar aquí el TextField y comprobar con el métdodo Challenge
        //add verifButton
        //add text, obtener el dato (creo que pasarlo a int) y comprarlo con el método Challenge de la clase Challenge
    }


    @Override
    public void show() {
        super.show();
    }

    @Override
    public void dispose() { // Una manera de manejar memoria
        super.dispose();

    }

    public static void main(String[] args) {
        new Challenge();
    }

}
