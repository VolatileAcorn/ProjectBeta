package com.pbarry.game;

import com.badlogic.gdx.Game;
import com.pbarry.game.screens.OverworldScreen;

public class MyGame extends Game {

	private MapLoader mapLoader;
	OverworldScreen overworldScreen;
	private int currentMapID;
	private SaveManager saveManager;


	@Override
	public void create () {
		currentMapID = 1;
		mapLoader = new MapLoader();
		overworldScreen = new OverworldScreen(this);
		setScreen(overworldScreen);
	}

	@Override
	public void render () {
		super.render();
	}

	public int getCurrentMapID() {
		return currentMapID;
	}
}

