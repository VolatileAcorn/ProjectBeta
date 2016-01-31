package com.pbarry.game.levelEditor;

import com.badlogic.gdx.Game;
import com.pbarry.game.screens.LevelEditorScreen;

/**
 * Created by Tom on 20/01/2016.
 */
public class LevelEditor extends Game {

    LevelEditorScreen levelEditorScreen;

    @Override
    public void create() {
        levelEditorScreen = new LevelEditorScreen(this);
        setScreen(levelEditorScreen);
    }
}
