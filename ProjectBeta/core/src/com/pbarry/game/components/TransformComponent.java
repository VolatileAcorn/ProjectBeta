package com.pbarry.game.components;

import com.badlogic.ashley.core.Component;

/**
 * Created by Tom on 13/01/2016.
 */
public class TransformComponent implements Component {

    private float xPos;
    private float yPos;
    private float xVel;
    private float yVel;
    private float xScale;
    private float yScale;
    private float clockRotation;

    public TransformComponent(float xPos, float yPos, float xVel, float yVel, float xScale, float yScale, float clockRotation) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.xVel = xVel;
        this.yVel = yVel;
        this.xScale = xScale;
        this.yScale = yScale;
        this.clockRotation = clockRotation;
    }

    public float getxPos() {
        return xPos;
    }

    public void setxPos(float xPos) {
        this.xPos = xPos;
    }

    public float getyPos() {
        return yPos;
    }

    public void setyPos(float yPos) {
        this.yPos = yPos;
    }

    public float getxVel() {
        return xVel;
    }

    public void setxVel(float xVel) {
        this.xVel = xVel;
    }

    public float getyVel() {
        return yVel;
    }

    public void setyVel(float yVel) {
        this.yVel = yVel;
    }

    public float getxScale() {
        return xScale;
    }

    public void setxScale(float xScale) {
        this.xScale = xScale;
    }

    public float getyScale() {
        return yScale;
    }

    public void setyScale(float yScale) {
        this.yScale = yScale;
    }

    public float getClockRotation() {
        return clockRotation;
    }

    public void setClockRotation(float clockRotation) {
        this.clockRotation = clockRotation;
    }
}
