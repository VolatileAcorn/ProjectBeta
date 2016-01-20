package com.pbarry.game.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import com.pbarry.game.components.SpriteComponent;
import com.pbarry.game.components.TransformComponent;

/**
 * Created by Tom on 20/01/2016.
 */
public class StaticGameObject extends Entity {

    //will have a spritesheet then use a UV position to get from some place in the spritesheet
    public StaticGameObject(Vector2 position) {
        this.add(new SpriteComponent("TestSprite.png"));
        this.add(new TransformComponent(position, new Vector2(0f,0f), new Vector2(1f,1f), 0f));
    }
}
