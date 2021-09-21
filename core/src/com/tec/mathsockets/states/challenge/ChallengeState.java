package com.tec.mathsockets.states.challenge;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.tec.mathsockets.MathSockets;
import com.tec.mathsockets.states.State;

import java.awt.*;

import static com.tec.mathsockets.states.challenge.Challenge.problem;

public class ChallengeState extends State {

    private final MathSockets game;
    //Challenge numeros = new Challenge();
    ShapeRenderer rectangle;
    public SpriteBatch batch;
    private BitmapFont font;
    private TextField text;
    int x = 200;
    int y = 200;

    public ChallengeState(MathSockets game) {
        this.game = game;

    }

    public void create() {

        rectangle = new ShapeRenderer();
        font = new BitmapFont();
        //TextButton verifButton = new TextButton("Verficar resultado");
        //verification.setPosition(x, x);
        //verification.setSize(x, x);

        text = new TextField("");
        //text.setPosition(x, x);
        //text.setSize(x, x);
    }


    @Override
    public void render(float delta) { //Aquí se crea la nueva ventana y se le agregan los datos
        super.render(delta); //Heredo el método render de State

        //Crear el rectángulo con la pregunta y el campo para ingresar los datos
        //después verifica si el resultado es el correcto y procede con el juego
        rectangle.begin(ShapeRenderer.ShapeType.Filled);
        rectangle.rect(x, y,1200, 602 );
        batch.begin();
            font.draw(batch, problem, 550, 500);
            //font.draw(batch, "Número 1: "+ numeros.getNum1(), 500, 530);
            //font.draw(batch, "Número 2: "+ numeros.getNum2(), 550, 530);
        batch.end();
        //Agregar aquí el TextField y comprobar con el métdodo Challenge
        //add verifButton
        //add text, obtener el dato (creo que pasarlo a int) y comprarlo con el método Challenge de la clase Challenge


        rectangle.end();




    }

    @Override
    public void dispose() { // Una manera de manejar memoria
        super.dispose();
    }

}
