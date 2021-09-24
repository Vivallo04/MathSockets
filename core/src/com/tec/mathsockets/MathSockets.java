package com.tec.mathsockets;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.esotericsoftware.kryo.Kryo;
import com.tec.mathsockets.network.GClient;
import com.tec.mathsockets.network.GServer;
import com.tec.mathsockets.states.challenge.ChallengeState;
import com.tec.mathsockets.states.game.GameState;
import com.tec.mathsockets.states.load.LoadingState;
import com.tec.mathsockets.util.StateMachine;

import java.io.IOException;


public class MathSockets extends Game {


	private final String TAG = MathSockets.class.getSimpleName();
	private SpriteBatch batch;

	public static GameState gameState;
	public static LoadingState loadingState;
	public static ChallengeState challengeState;

	public static StateMachine stateMachine;

	protected Kryo kryo;
	protected GServer gameServer;
	protected GClient gameClient;



	public MathSockets() {
		kryo = GServer.getServerInstance().getKryo();
		kryo.register(GServer.someRequest.class);
		kryo.register(GServer.someResponse.class);
	}

	/*public challenge(){
		ChallengeState x = new ChallengeState(this);
		return;

	}*/



	@Override
	public void create () {
		batch = new SpriteBatch();
		gameState = new GameState(this);
		loadingState = new LoadingState(this);
		challengeState = new ChallengeState(this);
		setScreen(gameState);

		try {
			gameServer = new GServer();
			gameClient = new GClient();

		} catch (IOException e) {
			Gdx.app.debug(TAG, "Unable to initialize client and/or server " + e);
			e.printStackTrace();
		}
	}


	/**
	 * Get game's SpriteBatch
	 * @return MathSockets SpriteBatch
	 */
	public SpriteBatch getBatch() {
		return this.batch;
	}


	/**
	 * Terminate server, clients and remove current state assets.
	 */
	@Override
	public void dispose () {
		gameState.dispose();
		gameClient.dispose();
		gameServer.dispose();
	}

	public static void main(String[] args) {
		MathSockets uno = new MathSockets();
	}

}
