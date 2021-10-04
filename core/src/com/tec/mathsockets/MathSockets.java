package com.tec.mathsockets;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.esotericsoftware.kryo.Kryo;
import com.tec.mathsockets.network.GClient;
import com.tec.mathsockets.network.GServer;
import com.tec.mathsockets.states.State;
import com.tec.mathsockets.states.challenge.ChallengeState;
import com.tec.mathsockets.states.game.GameState;
import com.tec.mathsockets.states.load.LoadingState;
import com.tec.mathsockets.states.menu.MainMenuState;
import com.tec.mathsockets.util.StateMachine;

import java.io.IOException;


public class MathSockets extends Game {

	//TODO: OBSERVER => REQUEST
	//      Mouse pointer sprite
	//      STATE MACHINE
	//      FACTORY METHOD
	private final String TAG = MathSockets.class.getSimpleName();
	private SpriteBatch batch;

	public static GameState gameState;
	public static LoadingState loadingState;
	public static ChallengeState challengeState;
	public static MainMenuState MainMenuState;

	public static StateMachine stateMachine;

	public State state;

	protected Kryo kryo;
	protected GServer gameServer;
	protected GClient gameClient;


	/**
	 * Initialize Kryo Server and stay open
	 * for request and responses
	 */
	public MathSockets() {
		kryo = GServer.getServerInstance().getKryo();
		kryo.register(GServer.someRequest.class);
		kryo.register(GServer.someResponse.class);
	}


	@Override
	public void create () {
		batch = new SpriteBatch();
		gameState = new GameState(this);
		loadingState = new LoadingState(this);
		MainMenuState = new MainMenuState(this);
		challengeState = new ChallengeState(this);
		setScreen(challengeState);

		try {
			gameServer = GServer.getGServerInstance();
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

}
