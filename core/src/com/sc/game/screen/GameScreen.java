package com.sc.game.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sc.game.entity.EntityManager;
import com.sc.game.entity.player.Player;

public class GameScreen extends Screen {

    private OrthographicCamera camera;
    private EntityManager entityManager;

    private Player player;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false); // set to false to flip the display to not be mirrored
        entityManager = new EntityManager();

    }

    @Override
    public void update() {
        camera.update();
        entityManager.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        entityManager.render(sb);
        sb.end();
    }

    @Override
    public void resize(int width, int height) {
        camera.update();
    }

    @Override
    public void dispose() {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
}
