package com.pbarry.game.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pbarry.game.components.SpriteComponent;
import com.pbarry.game.components.TransformComponent;

/**
 * Created by Tom on 14/01/2016.
 */
public class RenderSystem extends IteratingSystem {


    private ComponentMapper<TransformComponent> tm = ComponentMapper.getFor(TransformComponent.class);
    private ComponentMapper<SpriteComponent> sm = ComponentMapper.getFor(SpriteComponent.class);
    SpriteBatch batch;

    public RenderSystem(SpriteBatch batch) {
        super(Family.all(TransformComponent.class, SpriteComponent.class).get(), 1000);
        this.batch = batch;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        TransformComponent transform = tm.get(entity);
        SpriteComponent sprite = sm.get(entity);
        batch.draw(sprite.texture,transform.getPosition().x,transform.getPosition().y);
    }
}
