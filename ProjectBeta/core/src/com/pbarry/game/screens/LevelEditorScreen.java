package com.pbarry.game.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.pbarry.game.levelEditor.LevelEditor;
import com.pbarry.game.MapLoader;
import com.pbarry.game.levelEditor.LevelEditorController;

/**
 * Created by Tom on 20/01/2016.
 */
public class LevelEditorScreen implements Screen {


    public final static int VIEWPORT_WIDTH = 384;
    public final static int VIEWPORT_HEIGHT = 216;

    private LevelEditor levelEditor;

    private final Vector2 GUI_BUTTON_SIZES = new Vector2(210,70);

    private MapLoader mapLoader;
    private MapRenderer mapRenderer;
    private OrthographicCamera mapCamera;
    private LevelEditorController levelEditorController;
    private Skin skin;
    private Stage stage;

    private SpriteBatch batch;

    private Engine engine;

    public LevelEditorScreen(LevelEditor levelEditor) {
        this.levelEditor = levelEditor;

        mapLoader = new MapLoader();
        mapRenderer = new OrthogonalTiledMapRenderer(mapLoader.getMap(1));
        mapCamera = new OrthographicCamera(VIEWPORT_WIDTH,VIEWPORT_HEIGHT);
        mapRenderer.setView(mapCamera);

        batch = new SpriteBatch();
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

    private void createStage(){
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        //make createEntityButton
        TextButton createEntityButton = new TextButton("Create Entity", skin);
        createEntityButton.setPosition(Gdx.graphics.getWidth() - GUI_BUTTON_SIZES.x - 5,Gdx.graphics.getHeight() - (GUI_BUTTON_SIZES.y + 5) * 1);
        createEntityButton.setSize(GUI_BUTTON_SIZES.x, GUI_BUTTON_SIZES.y);
        createEntityButton.addListener(new ChangeListener(){
            public void changed (ChangeEvent event, Actor actor){
                //create dialog which will have a chain of events to create different types of entities (static, enemy etc.)
            } } );
        stage.addActor(createEntityButton);

        //make LoadNewLevelButton
        TextButton LoadLevelButton = new TextButton("Load Level", skin);
        LoadLevelButton.setPosition(Gdx.graphics.getWidth() - GUI_BUTTON_SIZES.x - 5,Gdx.graphics.getHeight() - (GUI_BUTTON_SIZES.y + 5) * 2);
        LoadLevelButton.setSize(GUI_BUTTON_SIZES.x, GUI_BUTTON_SIZES.y);
        LoadLevelButton.addListener(new ChangeListener(){
            public void changed (ChangeEvent event, Actor actor){
                //create dialog which will have a chain of events to load a level (map and engine state)
            } } );
        stage.addActor(LoadLevelButton);

        //make CreateNewLevelButton
        TextButton createLevelButton = new TextButton("Create New Level", skin);
        createLevelButton.setPosition(Gdx.graphics.getWidth() - GUI_BUTTON_SIZES.x - 5,Gdx.graphics.getHeight() - (GUI_BUTTON_SIZES.y + 5) * 3);
        createLevelButton.setSize(GUI_BUTTON_SIZES.x, GUI_BUTTON_SIZES.y);
        createLevelButton.addListener(new ChangeListener(){
            public void changed (ChangeEvent event, Actor actor){
                //create dialog which will have a chain of events to create new level
            } } );
        stage.addActor(createLevelButton);

    }

    @Override
    public void show() {
        engine = new Engine();
        levelEditorController = new LevelEditorController(mapCamera);
        createSkin();
        createStage();
    }

    @Override
    public void render(float delta) {

        //clear screen
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //update camera
        levelEditorController.update();
        mapRenderer.setView(mapCamera);
        //draw map
        mapRenderer.render();
        //draw entities
        batch.begin();
        engine.update(delta);
        batch.end();

        //draw gui
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

    }
}
