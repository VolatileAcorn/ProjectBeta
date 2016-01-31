package com.pbarry.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.pbarry.game.levelEditor.LevelEditor;

/**
 * Created by Tom on 20/01/2016.
 */
public class LevelEditorLauncher {
    public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.height=720;
        config.width=1280;
        config.useGL30 = true;
        config.foregroundFPS = 120;
        config.vSyncEnabled = false;
        new LwjglApplication(new LevelEditor(), config);
    }
}
