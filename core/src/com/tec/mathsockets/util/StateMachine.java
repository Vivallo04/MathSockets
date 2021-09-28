package com.tec.mathsockets.util;

import com.tec.mathsockets.MathSockets;
import com.tec.mathsockets.states.State;

public class StateMachine {

    public enum StateType {
        ABOUT_STATE,
        CHOOSE_AVATAR_STATE,
        CONNECT_STATE,
        GAME_STATE,
        HOW_TO_PLAY_STATE,
        MAIN_MENU_STATE,
        PAUSE_STATE,
        SELECT_PORT_STATE,
        SETTINGS_STATE,
        WIN_STATE
    }

    public State switchState(StateType newState) {
        switch (newState) {
            case CONNECT_STATE:
                return MathSockets.gameState;
            case CHOOSE_AVATAR_STATE:
                return MathSockets.gameState;
            case SELECT_PORT_STATE:
                return MathSockets.gameState;
            case MAIN_MENU_STATE:
                return MathSockets.gameState;
            case GAME_STATE:
                return MathSockets.gameState;
            case WIN_STATE:
                return MathSockets.gameState;
            case PAUSE_STATE:
                return MathSockets.gameState;
            case SETTINGS_STATE:
                return MathSockets.gameState;
            case HOW_TO_PLAY_STATE:
                return MathSockets.gameState;
            case ABOUT_STATE:
                return MathSockets.gameState;
            default:
                throw new IllegalStateException("No newState has been selected");
        }
    }
}
