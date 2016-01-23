package com.pbarry.game;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;
import com.pbarry.game.entities.Player;
import com.pbarry.game.systems.CameraUpdateSystem;
import com.pbarry.game.systems.PlayerInputSystem;
import com.pbarry.game.systems.PositionFromVelocityUpdateSystem;
import com.pbarry.game.systems.RenderSystem;

import java.io.File;

/**
 * Created by Tom on 20/01/2016.
 */
public class EngineLoader {

    private final String defaultSaveFilePath = "Saves/DefaultSaveFiles";
    private Json json;

    public EngineLoader() {
        json = new Json();
    }

    /**
     * This method will be used to load in the systems and entities for a given level specified by it's id
     * @param levelID the levelID of the level being loaded, corresponds to the mapID
     * @return returns an Engine with systems and entities for the given level
     */
    public Engine getEngineforLevel(int levelID) {
        String path = "EngineStates/" + levelID + ".json";
        return json.fromJson(Engine.class, path);
    }

    /**
     * This method should be used only when editing levels in a level editor
     * @param levelID the levelID of the level being saved, corresponds to the mapID
     */
    public void saveEngineforLevel(int levelID) {
        String path = "EngineStates/" + levelID + ".json";
        json.toJson(Engine.class, new FileHandle(path));
    }

}
