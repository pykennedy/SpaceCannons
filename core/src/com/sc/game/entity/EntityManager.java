package com.sc.game.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.sc.game.MainGame;
import com.sc.game.entity.enemy.Enemy;
import com.sc.game.entity.player.Player;

public class EntityManager {

    private final Array<Entity> entities = new Array<Entity>();
    private final Player player;
    private final Enemy enemy;

    public EntityManager() {
        player = new Player(new Vector2(MainGame.SCREEN_WIDTH/2, -MainGame.SCREEN_HEIGHT/15), new Vector2(0,0), this);
        enemy = new Enemy(new Vector2(MainGame.SCREEN_WIDTH/3, MainGame.SCREEN_HEIGHT-MainGame.SCREEN_HEIGHT/13),
                new Vector2(0,0), this);
    }

    public void update() {
        player.update();
        enemy.update();
    }

    int i = 0;
    public void render(SpriteBatch sb) {
        player.render(sb);
        enemy.render(sb);
    }

    private void checkCollisions() {
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }
/*
    private Array<Enemy> getEnemies() {
    }

    private Array<Missile> getMissiles() {
    }
*/
    public boolean gameOver() {
        return false;
    }
}
