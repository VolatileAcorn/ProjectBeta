package com.pbarry.game.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Tom on 13/01/2016.
 */
public class TransformComponent implements Component {

    private Vector2 Position;
    private Vector2 Velocity;
    private Vector2 Scale;
    private float clockRotation;

    public TransformComponent(Vector2 position, Vector2 velocity, Vector2 scale, float clockRotation) {
        Position = position;
        Velocity = velocity;
        Scale = scale;
        this.clockRotation = clockRotation;
    }

    public Vector2 getPosition() {
        return Position;
    }

    public void setPosition(Vector2 position) {
        Position = position;
    }

    public Vector2 getVelocity() {
        return Velocity;
    }

    public void setVelocity(Vector2 velocity) {
        Velocity = velocity;
    }

    public Vector2 getScale() {
        return Scale;
    }

    public void setScale(Vector2 scale) {
        Scale = scale;
    }

    public float getClockRotation() {
        return clockRotation;
    }

    public void setClockRotation(float clockRotation) {
        this.clockRotation = clockRotation;
    }
}
