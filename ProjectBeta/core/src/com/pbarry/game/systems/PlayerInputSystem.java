package com.pbarry.game.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IntervalSystem;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.pbarry.game.components.PlayerInputComponent;
import com.pbarry.game.components.TransformComponent;

/**
 * Created by Tom on 14/01/2016.
 */
public class PlayerInputSystem extends IteratingSystem {

    private int upKey = Input.Keys.W;
    private int downKey = Input.Keys.S;
    private int leftKey = Input.Keys.A;
    private int rightKey = Input.Keys.D;
    private int sprintKey = Input.Keys.SHIFT_LEFT;

    //might want to set the magnitude of the velocities to 40f then scale by run multiplier
    private float walkingSpeed = 40.0f;
    private float runMultiplier = 2.0f;



    private ImmutableArray<Entity> entity;

    public PlayerInputSystem() {
        super(Family.all(TransformComponent.class,PlayerInputComponent.class).get(),0);
    }


    public int getUpKey() {
        return upKey;
    }

    public void setUpKey(int upKey) {
        this.upKey = upKey;
    }

    public int getDownKey() {
        return downKey;
    }

    public void setDownKey(int downKey) {
        this.downKey = downKey;
    }

    public int getLeftKey() {
        return leftKey;
    }

    public void setLeftKey(int leftKey) {
        this.leftKey = leftKey;
    }

    public int getRightKey() {
        return rightKey;
    }

    public void setRightKey(int rightKey) {
        this.rightKey = rightKey;
    }

    public int getSprintKey() {
        return sprintKey;
    }

    public void setSprintKey(int sprintKey) {
        this.sprintKey = sprintKey;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        TransformComponent transform = entity.getComponent(TransformComponent.class);

        transform.setVelocity(new Vector2(0,0));

        if (Gdx.input.isKeyPressed(upKey)){
            transform.setVelocity(new Vector2(0,walkingSpeed));
        }
        else if (Gdx.input.isKeyPressed(downKey)){
            transform.setVelocity(new Vector2(0, -walkingSpeed));
        }

        if (Gdx.input.isKeyPressed(rightKey)){
            transform.setVelocity(new Vector2(walkingSpeed, transform.getVelocity().y));
        }
        else if (Gdx.input.isKeyPressed(leftKey)){
            transform.setVelocity(new Vector2(-walkingSpeed, transform.getVelocity().y));
        }

        if (Gdx.input.isKeyPressed(sprintKey)){
            transform.setVelocity(transform.getVelocity().scl(runMultiplier));

        }
    }


}
