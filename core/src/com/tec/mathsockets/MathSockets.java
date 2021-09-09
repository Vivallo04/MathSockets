package com.tec.mathsockets;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.tec.mathsockets.states.game.GameState;

public class MathSockets extends Game {

	private final String TAG = MathSockets.class.getSimpleName();
	public static GameState gameState;
	public SpriteBatch batch;


	@Override
	public void create () {
		batch = new SpriteBatch();
		gameState = new GameState(this);
		setScreen(gameState);
	}

	@Override
	public void dispose () {
		gameState.dispose();
	}
}
