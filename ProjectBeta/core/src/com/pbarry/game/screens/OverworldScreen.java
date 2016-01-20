package com.pbarry.game.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;
import com.pbarry.game.MapLoader;
import com.pbarry.game.MyGame;
import com.pbarry.game.components.CameraTargetComponent;
import com.pbarry.game.components.PlayerInputComponent;
import com.pbarry.game.components.SpriteComponent;
import com.pbarry.game.components.TransformComponent;
import com.pbarry.game.entities.Player;
import com.pbarry.game.systems.CameraUpdateSystem;
import com.pbarry.game.systems.PlayerInputSystem;
import com.pbarry.game.systems.PositionFromVelocityUpdateSystem;
import com.pbarry.game.systems.RenderSystem;

/**
 * Created by Tom on 13/01/2016.
 */
public class OverworldScreen implements Screen {

    public final static int VIEWPORT_WIDTH = 384;
    public final static int VIEWPORT_HEIGHT = 216;

    private MapLoader mapLoader;
    private MapRenderer mapRenderer;
    private OrthographicCamera mapCamera;

    private SpriteBatch batch;

    private Engine engine;
    private Player player;

    private MyGame game;

    public OverworldScreen(MyGame myGame) {
        this.game = myGame;
        this.mapLoader = new MapLoader();
    }


    @Override
    public void show() {
        mapCamera = new OrthographicCamera(VIEWPORT_WIDTH,VIEWPORT_HEIGHT);
        batch = new SpriteBatch();
        mapRenderer = new OrthogonalTiledMapRenderer(mapLoader.getMap(game.getCurrentMapID()), batch);
        mapRenderer.setView(mapCamera);
        engine = new Engine();
        player = new Player("Duck1.png",new Vector2(100,100));
        engine.addEntity(player);
        engine.addSystem(new PlayerInputSystem());
        engine.addSystem(new PositionFromVelocityUpdateSystem());
        engine.addSystem(new RenderSystem(batch));
        CameraUpdateSystem cameraUpdateSystem = new CameraUpdateSystem(mapCamera, mapRenderer);
        cameraUpdateSystem.setTarget(player);
        engine.addSystem(cameraUpdateSystem);

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
