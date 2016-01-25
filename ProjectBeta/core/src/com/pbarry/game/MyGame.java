package com.pbarry.game;

import com.badlogic.gdx.Game;
import com.pbarry.game.screens.OverworldScreen;
import com.pbarry.game.screens.StartScreen;

public class MyGame extends Game {

	private MapLoader mapLoader;
	OverworldScreen overworldScreen;
	StartScreen startScreen;
	private int currentMapID;
	private SaveManager saveManager;


	@Override
	public void create () {
		currentMapID = 1;
		mapLoader = new MapLoader();
		startScreen = new StartScreen(this);
		setScreen(startScreen);
	}

	@Override
	public void render () {
		super.render();
	}

	public int getCurrentMapID() {
		return currentMapID;
	}
}

