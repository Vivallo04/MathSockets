package com.tec.mathsockets.desktop;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.tec.mathsockets.MathSockets;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "MathSockets";
		config.useGL30 = false;
		config.width = 1280;
		config.height = 720;
		config.forceExit = false;
		config.foregroundFPS = 144;

		Application app = new LwjglApplication(new MathSockets(), config);
		Gdx.app = app;
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
	}

}
