package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
//		config.width  = SpaceGame.WIDTH;
//		config.height = SpaceGame.HEIGHT;
		config.setWindowedMode(TankStars.WIDTH, TankStars.HEIGHT);
//		config.setResizable(false);
		config.setTitle("My GDX Game");
		new Lwjgl3Application(new TankStars(), config);
	}
}

