package com.pbarry.game.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.pbarry.game.components.CameraTargetComponent;
import com.pbarry.game.components.TransformComponent;


/**
 * Created by Tom on 16/01/2016.
 */
public class CameraUpdateSystem extends EntitySystem {

    private Entity currentTarget;
    private OrthographicCamera currentCamera;
    private MapRenderer mapRenderer;

    public CameraUpdateSystem(OrthographicCamera currentCamera,MapRenderer mapRenderer) {
        super(999);
        this.currentCamera = currentCamera;
        this.mapRenderer = mapRenderer;
    }

    public void setCamera(OrthographicCamera camera){
        this.currentCamera = camera;
    }

    public void setTarget(Entity target){
        if (!(target.getComponent(TransformComponent.class) == null) && !(target.getComponent(CameraTargetComponent.class) == null)){
            this.currentTarget = target;
        }
    }

    @Override
    public void update(float deltaTime) {
        Vector2 currentTargetPos = currentTarget.getComponent(TransformComponent.class).getPosition();
        currentCamera.translate(currentTargetPos.x - currentCamera.position.x, currentTargetPos.y - currentCamera.position.y);
        currentCamera.update();
        mapRenderer.setView(currentCamera);
    }
}
