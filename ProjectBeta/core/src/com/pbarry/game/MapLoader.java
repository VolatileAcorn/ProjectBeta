package com.pbarry.game;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

/**
 * Created by Tom on 20/01/2016.
 */
public class MapLoader {

    public MapLoader() {
    }

    public TiledMap getMap(int mapID) {
        TiledMap map = new TmxMapLoader().load("Maps/" + mapID + ".tmx");
        return map;
    }


}
