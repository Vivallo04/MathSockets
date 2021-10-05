package com.tec.mathsockets;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.esotericsoftware.kryo.Kryo;
import com.tec.mathsockets.entity.Player;
import com.tec.mathsockets.network.GClient;
import com.tec.mathsockets.network.GServer;
import com.tec.mathsockets.network.GameServer;
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
import io.socket.client.IO;
import io.socket.client.Socket;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

import static com.tec.mathsockets.util.StateMachine.StateType.*;


public class MathSockets extends Game {

	private final String TAG = MathSockets.class.getSimpleName();
	private SpriteBatch batch;

	private Pixmap pixmap;

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

	public static final StateMachine stateMachine = new StateMachine();

	public StateMachine.StateType currentState;

	public static HashMap<String, Player> connectedPLayers;



	public MathSockets() {
		currentState = StateMachine.StateType.GAME_STATE;
	}


	@Override
	public void create() {
		batch = new SpriteBatch();
		connectedPLayers = new HashMap<>();

		// game states
		gameState = new GameState(this);
		loadingState = new LoadingState(this);
		mainMenuState = new MainMenuState(this);
		challengeState = new ChallengeState(this);
		pixmap = new Pixmap(Gdx.files.internal("ui/cursor.png"));


		Gdx.app.debug(TAG, "Current state: " + currentState);
		Gdx.graphics.setCursor(Gdx.graphics.newCursor(pixmap, 0, 0));

		setScreen(stateMachine.getState(GAME_STATE));
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
		pixmap.dispose();
		loadingState.dispose();
	}

}
