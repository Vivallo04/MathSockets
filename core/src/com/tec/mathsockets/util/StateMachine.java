package com.tec.mathsockets.util;

import com.tec.mathsockets.MathSockets;
import com.tec.mathsockets.states.State;

public class StateMachine {

    public static enum StateType {
        ABOUT_STATE,
        CHOOSE_AVATAR_STATE,
        CHALLENGE_STATE,
        GAME_STATE,
        HELP_STATE,
        LOADING_STATE,
        MAIN_MENU_STATE,
        PAUSE_STATE,
        SETTINGS_STATE,
        WIN_STATE
    }

    private final MathSockets game;
    public StateMachine(MathSockets game) {
        this.game = game;
    }

    public void changeState(StateType newState) {
        switch (newState) {
            case LOADING_STATE:
                game.setScreen(MathSockets.getLoadingState());
                return;
            case CHOOSE_AVATAR_STATE:
                game.setScreen(MathSockets.getChooseAvatarState());
                return;
            case CHALLENGE_STATE:
                game.setScreen(MathSockets.getChallengeState());
                return;
            case MAIN_MENU_STATE:
                game.setScreen(MathSockets.getMainMenuState());
                return;
            case GAME_STATE:
                game.setScreen(MathSockets.getGameState());
                return;
            case WIN_STATE:
                game.setScreen(MathSockets.getWinState());
                return;
            case PAUSE_STATE:
                game.setScreen(MathSockets.getPauseState());
                return;
            case SETTINGS_STATE:
                game.setScreen(MathSockets.getSettingsState());
                return;
            case HELP_STATE:
                game.setScreen(MathSockets.getHelpState());return;

            case ABOUT_STATE:
                game.setScreen(MathSockets.getAboutState());
                return;
            default:
                throw new IllegalStateException("No new State has been selected");
        }
    }
}
