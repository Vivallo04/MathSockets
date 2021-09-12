package com.tec.mathsockets.util;

import com.tec.mathsockets.MathSockets;
import com.tec.mathsockets.states.State;

public class StateMachine {

    public enum StateType {
        ConnectState,
        ChooseAvatarState,
        SelectPortState,
        MainMenuState,
        GameState,
        WinState,
        PauseState,
        SettingsState,
        HowToPlayState,
        AboutState
    }


    public State changeState(StateType state) {
        switch (state) {
            case ConnectState:
                return MathSockets.gameState;
            case ChooseAvatarState:
                return MathSockets.gameState;
            case SelectPortState:
                return MathSockets.gameState;
            case MainMenuState:
                return MathSockets.gameState;
            case GameState:
                return MathSockets.gameState;
            case WinState:
                return MathSockets.gameState;
            case PauseState:
                return MathSockets.gameState;
            case SettingsState:
                return MathSockets.gameState;
            case HowToPlayState:
                return MathSockets.gameState;
            case AboutState:
                return MathSockets.gameState;
            default:
                return MathSockets.gameState;
        }
    }

}
