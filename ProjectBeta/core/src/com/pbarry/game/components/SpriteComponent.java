package com.pbarry.game.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Tom on 13/01/2016.
 */
public class SpriteComponent implements Component {
    public Texture texture;

    public SpriteComponent(String internalPath) {
        this.texture = new Texture(internalPath);
    }
}
