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

    public State getState(StateType state) {
        return changeState(state);
    }

    public State changeState(StateType newState) {
        switch (newState) {
            case LOADING_STATE:
                return MathSockets.getLoadingState();
            case CHOOSE_AVATAR_STATE:
                return MathSockets.getChooseAvatarState();
            case CHALLENGE_STATE:
                return MathSockets.getChallengeState();
            case MAIN_MENU_STATE:
                return MathSockets.getMainMenuState();
            case GAME_STATE:
                return MathSockets.getGameState();
            case WIN_STATE:
                return MathSockets.getWinState();
            case PAUSE_STATE:
                return MathSockets.getPauseState();
            case SETTINGS_STATE:
                return MathSockets.getSettingsState();
            case HELP_STATE:
                return MathSockets.getHelpState();
            case ABOUT_STATE:
                return MathSockets.getAboutState();
            default:
                throw new IllegalStateException("No new State has been selected");
        }
    }
}
