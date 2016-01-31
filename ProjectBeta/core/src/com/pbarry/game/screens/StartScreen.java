package com.pbarry.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.pbarry.game.MyGame;

/**
 * Created by Tom on 23/01/2016.
 */
public class StartScreen implements Screen {

    private Skin skin;
    private Stage stage;
    private MyGame myGame;
    private SpriteBatch batch;
    private Texture background = new Texture("Textures/startScreen.jpg");

    public StartScreen(MyGame myGame) {
        this.myGame = myGame;
    }

    private void createSkin() {
        //create font and add to skin
        BitmapFont font = new BitmapFont();
        skin = new Skin();
        skin.add("default", font);

        //create button texture
        Texture buttonTexture = new Texture("Textures/button1.png");
        skin.add("background", buttonTexture);

        //create a button style
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("background");
        textButtonStyle.down = skin.newDrawable("background");
        textButtonStyle.checked = skin.newDrawable("background");
        textButtonStyle.over = skin.newDrawable("background");
        textButtonStyle.font = skin.getFont("default");
        skin.add("default",textButtonStyle);
    }


    @Override
    public void show() {
        //init batch and create background texture
        batch = new SpriteBatch();

        //create skin and stage
        createSkin();
        stage = new Stage();

        //create and add startButton to stage
        Gdx.input.setInputProcessor(stage);
        TextButton startButton = new TextButton("Start", skin);
        startButton.setPosition(3*Gdx.graphics.getWidth()/8,Gdx.graphics.getHeight()/2);
        startButton.setSize(300,100);
        startButton.addListener(new ChangeListener(){
            public void changed (ChangeEvent event, Actor actor){
                myGame.setScreen(new OverworldScreen(myGame));}});
        stage.addActor(startButton);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(background,0,0,1280,720);
        batch.end();

        //render and update stage
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }

}
