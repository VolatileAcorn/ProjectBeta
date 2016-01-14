package com.pbarry.game.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import com.pbarry.game.Level;
import com.pbarry.game.components.PlayerInputComponent;
import com.pbarry.game.components.SpriteComponent;
import com.pbarry.game.components.TransformComponent;
import com.pbarry.game.systems.PlayerInputSystem;
import com.pbarry.game.systems.PositionFromVelocityUpdateSystem;
import com.pbarry.game.systems.RenderSystem;

/**
 * Created by Tom on 13/01/2016.
 */
public class OverworldScreen implements Screen {

    SpriteBatch batch;
    Level currentLevel;
    MapRenderer mapRenderer;
    OrthographicCamera mapCamera;
    Engine engine;
    Entity player;


    @Override
    public void show() {
        mapCamera = new OrthographicCamera(384,216);
        mapCamera.translate(mapCamera.viewportWidth/2, mapCamera.viewportHeight/2);
        mapCamera.update();
        batch = new SpriteBatch();
        currentLevel = new Level("test01.tmx",1);
        mapRenderer = new OrthogonalTiledMapRenderer(currentLevel.getTiledMap(), batch);
        mapRenderer.setView(mapCamera);
        engine = new Engine();
        player = new Entity();
        player.add(new PlayerInputComponent());
        player.add(new TransformComponent(50f,50f,0f,0f,1f,1f,0f));
        player.add(new SpriteComponent("Duck1.png"));
        engine.addEntity(player);
        engine.addSystem(new PlayerInputSystem());
        engine.addSystem(new PositionFromVelocityUpdateSystem());
        engine.addSystem(new RenderSystem(batch));

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
