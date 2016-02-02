package com.pbarry.game.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.pbarry.game.levelEditor.LevelEditor;
import com.pbarry.game.MapLoader;
import com.pbarry.game.levelEditor.LevelEditorController;
import com.pbarry.game.levelEditor.LevelFile;

/**
 * Created by Tom on 20/01/2016.
 */
public class LevelEditorScreen implements Screen {


    public final static int VIEWPORT_WIDTH = 384;
    public final static int VIEWPORT_HEIGHT = 216;

    private LevelEditor levelEditor;
    private LevelFile levelFile;

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
        /*
        this.levelEditor = levelEditor;
        levelFile = new LevelFile();

        mapLoader = new MapLoader();
        mapRenderer = new OrthogonalTiledMapRenderer(mapLoader.getMap(1));
        mapCamera = new OrthographicCamera(VIEWPORT_WIDTH,VIEWPORT_HEIGHT);
        mapRenderer.setView(mapCamera);

        batch = new SpriteBatch();
        */
    }


    @Override
    public void show() {
        stage = new Stage();
        createSkin();
        Gdx.input.setInputProcessor(stage);
        showLoadLevelGUI();
        /*
        engine = new Engine();
        levelEditorController = new LevelEditorController(mapCamera);

        */
    }

    @Override
    public void render(float delta) {

        //clear screen
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        /*
        //update camera
        levelEditorController.update();
        mapRenderer.setView(mapCamera);
        //draw map
        mapRenderer.render();

        //draw entities
        batch.begin();
        engine.update(delta);
        batch.end();
        */
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
        skin.add("default", textButtonStyle);

        //create text field style
        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.background = skin.newDrawable("background");
        textFieldStyle.fontColor = new Color(1.0f,1.0f,1.0f,1.0f);
        textFieldStyle.font = new BitmapFont(new FileHandle("Fonts/gamefont.fnt"));
        skin.add("default", textFieldStyle);

    }


    private void showLoadLevelGUI() {
        //need to create a listener which will check which levelID has been entered and check if exists + valid then removes loadLevelGUI and load Engine

        TextField levelDirectoryField = new TextField("Enter LevelID...", skin,"default");
        levelDirectoryField.setMaxLength(3);

        //only accept numbers as inputs
        levelDirectoryField.setTextFieldFilter(new TextField.TextFieldFilter() {
            @Override
            public boolean acceptChar(TextField textField, char c) {
                return Character.isDigit(c);
            }
        });
        levelDirectoryField.setAlignment(1);
        levelDirectoryField.setSize(600,200);
        levelDirectoryField.setPosition(640,360);
        stage.addActor(levelDirectoryField);
    }
}
