package com.pbarry.game.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.pbarry.game.LevelEditor;
import com.pbarry.game.MapLoader;
import com.pbarry.game.MyGame;
import com.pbarry.game.entities.Player;

/**
 * Created by Tom on 20/01/2016.
 */
public class LevelEditorScreen implements Screen {

    private LevelEditor levelEditor;

    private MapLoader mapLoader;
    private MapRenderer mapRenderer;
    private OrthographicCamera mapCamera;

    private SpriteBatch batch;

    private Engine engine;

    public LevelEditorScreen(LevelEditor levelEditor) {
        this.levelEditor = levelEditor;

        mapLoader = new MapLoader();
        mapRenderer = new OrthogonalTiledMapRenderer(mapLoader.getMap(1));
        mapCamera = new OrthographicCamera();

        batch = new SpriteBatch();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mapRenderer.render();
        batch.begin();
        engine.update(delta);
        batch.end();
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
