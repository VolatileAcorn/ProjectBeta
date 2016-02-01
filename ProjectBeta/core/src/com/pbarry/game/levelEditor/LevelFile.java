package com.pbarry.game.levelEditor;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;


/**
 * Created by Tom on 01/02/2016.
 */
public class LevelFile {

    private Json json;
    private final String ENGINE_PATHS = "EngineStates/";
    private final String MAP_PATHS = "Maps/";

    public LevelFile() {
    }


    /**
     * Will create a new engine json for the specified levelID, any previous files will be overwritten
     * If the corresponding tmx does not exist then false will be returned and no engine file will be made
     * The file is completely empty and does not contain any systems or entities, save method must be used.
     * @param levelID levelId of the engine file wished to be created
     * @return true if tmx exists, false otherwise
     */
    public Boolean createNewLevel(int levelID){
        if (new FileHandle(MAP_PATHS + levelID + ".tmx").exists()) {
            json.toJson(new Engine(), Engine.class, new FileHandle(ENGINE_PATHS + levelID + ".json"));
            return true;
        }
        return false;
    }

    /**
     * Loads a json with engine data in it. If the json doesn't exist null is returned and must be dealt with
     * @param levelID LevelID of json being loaded
     * @return engine of corresponding levelID json or null if doesn't exist
     */
    public Engine loadLevel(int levelID){
        if (new FileHandle(ENGINE_PATHS + levelID + ".tmx").exists()){
            return json.fromJson(Engine.class, ENGINE_PATHS + levelID + ".json");
        }
        return null;
    }

    /**
     * Saves the engine state to a json file to be read later
     * @param engine engine to be saved as a json
     * @param levelID levelid of engine being saved
     * @return returns true if file exists and saved, false if unsuccessful
     */
    public boolean saveLevel(Engine engine, int levelID){
        if (new FileHandle(MAP_PATHS + levelID + ".tmx").exists()) {
            json.toJson(engine, Engine.class, new FileHandle(ENGINE_PATHS + levelID + ".json"));
            return true;
        }
        return false;
    }

}
