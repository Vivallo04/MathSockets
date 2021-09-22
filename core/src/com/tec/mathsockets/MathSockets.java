package com.tec.mathsockets;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.esotericsoftware.kryo.Kryo;
import com.tec.mathsockets.network.GClient;
import com.tec.mathsockets.network.GServer;
import com.tec.mathsockets.states.challenge.ChallengeState;
import com.tec.mathsockets.states.game.GameState;
import com.tec.mathsockets.states.load.LoadingState;

import java.io.IOException;


public class MathSockets extends Game {

	// TODO: DOCUMENTATION
	private final String TAG = MathSockets.class.getSimpleName();
	public static GameState gameState;
	public static LoadingState loadingState;
	public SpriteBatch batch;
	public static ChallengeState challengeState;

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
		loadingState = new LoadingState(this);
		challengeState = new ChallengeState(this);

		setScreen(loadingState);

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

	public SpriteBatch getBatch() {
		return this.batch;
	}
}
