package com.tec.mathsockets;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.esotericsoftware.kryo.Kryo;
import com.tec.mathsockets.network.GClient;
import com.tec.mathsockets.network.GServer;
import com.tec.mathsockets.states.game.GameState;

import java.io.IOException;


public class MathSockets extends Game {

	private final String TAG = MathSockets.class.getSimpleName();
	public static GameState gameState;
	public SpriteBatch batch;

	Kryo kryo;
	GServer gameServer;
	GClient gameClient;


	public MathSockets() {
		kryo = GServer.getServer().getKryo();
		kryo.register(GServer.someRequest.class);
		kryo.register(GServer.someResponse.class);
	}


	@Override
	public void create () {
		batch = new SpriteBatch();
		gameState = new GameState(this);
		setScreen(gameState);

		try {
			gameServer = new GServer();
			gameClient = new GClient();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void dispose () {
		//terminate server and clients
		gameState.dispose();
	}
}
