package com.sc.game.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.sc.game.MainGame;
import com.sc.game.entity.player.PlayerCannon;
import com.sc.game.entity.player.Player;

public class EntityManager {

    private final Array<Entity> entities = new Array<Entity>();
    private final Player player;
    private final PlayerCannon playerCannon;

    public EntityManager() {
        player = new Player(new Vector2(MainGame.SCREEN_WIDTH/3, -5), new Vector2(0,0), this);
        playerCannon = new PlayerCannon(new Vector2(
                player.sprite.getX()+(MainGame.SCREEN_WIDTH/10), player.sprite.getY()+(MainGame.SCREEN_WIDTH/20)),
                new Vector2(0,0), this, player.sprite);
    }

    public void update() {
        player.update();
        playerCannon.update();
    }

    int i = 0;
    public void render(SpriteBatch sb) {
        player.render(sb);
        playerCannon.render(sb);
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
