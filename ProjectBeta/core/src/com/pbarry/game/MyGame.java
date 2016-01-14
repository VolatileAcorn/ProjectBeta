package com.pbarry.game;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pbarry.game.screens.OverworldScreen;

public class MyGame extends Game {

	GameState currentGameState;
	OverworldScreen overworldScreen;

	
	@Override
	public void create () {
		overworldScreen = new OverworldScreen();
		setScreen(overworldScreen);
	}

	@Override
	public void render () {
		super.render();
	}

	public enum GameState{
		OVERWORLD, BATTLE, MAINMENU, PAUSED
	}
}
