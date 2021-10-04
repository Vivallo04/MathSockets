package com.tec.mathsockets.util;

import com.tec.mathsockets.MathSockets;
import com.tec.mathsockets.states.State;

public class StateMachine {

    public enum StateType {
        ABOUT_STATE,
        CHOOSE_AVATAR_STATE,
        GAME_STATE,
        HELP_STATE,
        MAIN_MENU_STATE,
        PAUSE_STATE,
        SETTINGS_STATE,
        WIN_STATE
    }

    public State changeState(StateType newState) {
        switch (newState) {
            case CHOOSE_AVATAR_STATE:
                return MathSockets.getChooseAvatarState();
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
