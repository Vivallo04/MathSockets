package com.tec.mathsockets.states.menu;

import com.tec.mathsockets.MathSockets;
import com.tec.mathsockets.states.State;

public class MainMenuState extends State {

    private MathSockets game;

    public MainMenuState(MathSockets game) {
        this.game = game;
     }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        game.getBatch().begin();

        game.getBatch().end();


    }
}
