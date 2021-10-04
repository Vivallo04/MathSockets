package com.tec.mathsockets;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.esotericsoftware.kryo.Kryo;
import com.tec.mathsockets.network.GClient;
import com.tec.mathsockets.network.GServer;
import com.tec.mathsockets.states.ChooseAvatarState;
import com.tec.mathsockets.states.State;
import com.tec.mathsockets.states.challenge.ChallengeState;
import com.tec.mathsockets.states.game.GameState;
import com.tec.mathsockets.states.load.LoadingState;
import com.tec.mathsockets.states.menu.MainMenuState;
import com.tec.mathsockets.states.menu.about.AboutState;
import com.tec.mathsockets.states.menu.help.HelpState;
import com.tec.mathsockets.states.menu.pause.PauseState;
import com.tec.mathsockets.states.menu.settings.SettingsState;
import com.tec.mathsockets.states.win.WinState;
import com.tec.mathsockets.util.StateMachine;

import java.io.IOException;


public class MathSockets extends Game {

	//TODO: OBSERVER => REQUEST
	//      Mouse pointer sprite
	//      STATE MACHINE
	//      FACTORY METHOD
	private final String TAG = MathSockets.class.getSimpleName();
	private SpriteBatch batch;

	private static GameState gameState;
	private static LoadingState loadingState;
	private static ChallengeState challengeState;
	private static MainMenuState mainMenuState;
	private static ChooseAvatarState chooseAvatarState;
	private static PauseState pauseState;
	private static WinState winState;
	private static SettingsState settingsState;
	private static HelpState helpState;
	private static AboutState aboutState;

	public static StateMachine stateMachine;

	public static State currentState;

	protected Kryo kryo;
	protected GServer gameServer;
	protected GClient gameClient;


	/**
	 * Initialize Kryo Server and stay open
	 * for request and responses
	 */
	public MathSockets() {
		stateMachine = new StateMachine();
		kryo = GServer.getServerInstance().getKryo();
		kryo.register(GServer.someRequest.class);
		kryo.register(GServer.someResponse.class);
	}


	@Override
	public void create () {
		batch = new SpriteBatch();
		gameState = new GameState(this);
		loadingState = new LoadingState(this);
		mainMenuState = new MainMenuState(this);
		challengeState = new ChallengeState(this);
		currentState = stateMachine.changeState(StateMachine.StateType.GAME_STATE);

		setScreen(currentState);

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


	public static GameState getGameState() {
		return gameState;
	}

	public static LoadingState getLoadingState() {
		return loadingState;
	}

	public static ChallengeState getChallengeState() {
		return challengeState;
	}

	public static MainMenuState getMainMenuState() {
		return mainMenuState;
	}

	public static ChooseAvatarState getChooseAvatarState() {
		return chooseAvatarState;
	}

	public static PauseState getPauseState() {
		return pauseState;
	}

	public static WinState getWinState() {
		return winState;
	}

	public static SettingsState getSettingsState() {
		return settingsState;
	}

	public static HelpState getHelpState() {
		return helpState;
	}

	public static AboutState getAboutState() {
		return aboutState;
	}

	/**
	 * Terminate server, clients and remove current currentState assets.
	 */
	@Override
	public void dispose () {
		gameState.dispose();
		gameClient.dispose();
		gameServer.dispose();
	}

}
