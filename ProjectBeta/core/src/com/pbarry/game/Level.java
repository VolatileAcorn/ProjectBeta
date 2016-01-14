package com.pbarry.game;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

/**
 * Created by Tom on 13/01/2016.
 */
public class Level {

    private Engine engineState;
    private int levelID;
    private TiledMap tiledMap;
    private String engineStatePath;

    public Level(String tiledMapPath, int levelID){
        this.tiledMap = new TmxMapLoader().load(tiledMapPath);
        this.levelID = levelID;
        //load engineState json for
    }

    public Engine getEngineState(){
        return this.engineState;
    }

    public TiledMap getTiledMap(){
        return tiledMap;
    }


}
