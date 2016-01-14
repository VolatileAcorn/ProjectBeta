package com.pbarry.game.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IntervalSystem;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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

        transform.setxVel(0f);
        transform.setyVel(0f);

        if (Gdx.input.isKeyPressed(upKey)){
            transform.setyVel(walkingSpeed);
        }
        else if (Gdx.input.isKeyPressed(downKey)){
            transform.setyVel(-walkingSpeed);
        }

        if (Gdx.input.isKeyPressed(rightKey)){
            transform.setxVel(walkingSpeed);
        }
        else if (Gdx.input.isKeyPressed(leftKey)){
            transform.setxVel(-walkingSpeed);
        }

        if (Gdx.input.isKeyPressed(sprintKey)){
            transform.setxVel(transform.getxVel() * runMultiplier);
            transform.setyVel(transform.getyVel()*runMultiplier);
        }
    }


}
