package com.pbarry.game.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import com.pbarry.game.components.CameraTargetComponent;
import com.pbarry.game.components.PlayerInputComponent;
import com.pbarry.game.components.SpriteComponent;
import com.pbarry.game.components.TransformComponent;

/**
 * Created by Tom on 20/01/2016.
 */
public class Player extends Entity{

    public Player(String spritePath, Vector2 position) {
        super();
        this.add(new SpriteComponent(spritePath));
        this.add(new PlayerInputComponent());
        this.add(new TransformComponent(position, new Vector2(0f,0f),new Vector2(1f,1f),0f));
        this.add(new CameraTargetComponent());
    }
}
