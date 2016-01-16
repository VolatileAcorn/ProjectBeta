package com.pbarry.game.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.Vector2;
import com.pbarry.game.components.TransformComponent;
import com.sun.javafx.geom.Vec2d;

/**
 * Created by Tom on 14/01/2016.
 */
public class PositionFromVelocityUpdateSystem extends IteratingSystem{

    private ComponentMapper<TransformComponent> tm = ComponentMapper.getFor(TransformComponent.class);

    public PositionFromVelocityUpdateSystem() {
        super(Family.all(TransformComponent.class).get(), 1);
    }


    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        TransformComponent transform = tm.get(entity);
        transform.setPosition(transform.getPosition().add(transform.getVelocity().scl(deltaTime)));
    }
}
