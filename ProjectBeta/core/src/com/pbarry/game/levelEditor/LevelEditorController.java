package com.pbarry.game.levelEditor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;


/**
 * Created by Tom on 31/01/2016.
 */
public class LevelEditorController {

    private OrthographicCamera levelEditorCamera;
    private Vector2 previousMousePosition;


    public LevelEditorController(final OrthographicCamera levelEditorCamera) {
        this.levelEditorCamera = levelEditorCamera;
        this.previousMousePosition = new Vector2(Gdx.input.getX(), Gdx.input.getY());
    }

    public void update() {

        //handles camera movement, later should check if the overworld is in focus or if we are going through menu buttons
        if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) {
            this.levelEditorCamera.translate((previousMousePosition.x - Gdx.input.getX())/4, -(previousMousePosition.y - Gdx.input.getY())/4);
            this.levelEditorCamera.update();


        }
        previousMousePosition.set(Gdx.input.getX(), Gdx.input.getY());

    }

}
