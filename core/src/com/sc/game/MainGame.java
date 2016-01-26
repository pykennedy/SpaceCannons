package com.sc.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sc.game.screen.GameScreen;
import com.sc.game.screen.ScreenManager;


/*
1. move cannon body along x
2. rotate cannon
3. shoot cannon
4. move enemy cannon randomly
5. create rules for missiles
6. hit detection for projectiles on cannons
7. hit detection for projectiles on projectiles
8. reduce health on hit
9. begin and end screen.
10. advanced physics
11. advance AI
 */
public class MainGame implements ApplicationListener {
	public static int SCREEN_WIDTH, SCREEN_HEIGHT, SCALED_HEIGHT;
	public static float ASPECT_RATIO, DEFAULT_MISSILE_SPEED, DEFAULT_CANNON_SPEED;
	SpriteBatch batch;
	
	@Override
	public void create () {
		SCREEN_WIDTH = Gdx.graphics.getWidth();
		SCREEN_HEIGHT = Gdx.graphics.getHeight();
		ASPECT_RATIO = SCREEN_HEIGHT / SCREEN_WIDTH;
		SCALED_HEIGHT = (int)(SCREEN_HEIGHT * ASPECT_RATIO);
		DEFAULT_MISSILE_SPEED = SCREEN_WIDTH / 3;
		DEFAULT_CANNON_SPEED = SCREEN_WIDTH / 10;
		batch = new SpriteBatch();
		ScreenManager.setScreen(new GameScreen());
	}

	public void dispose() {
		if(ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().dispose();
		batch.dispose();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if(ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().update();

		if(ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().render(batch);
	}

	@Override
	public void resize(int width, int height) {
		if(ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().resize(SCREEN_WIDTH, SCREEN_HEIGHT);
	}

	@Override
	public void pause() {
		if(ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().pause();
	}

	@Override
	public void resume() {
		if(ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().resume();
	}
}
