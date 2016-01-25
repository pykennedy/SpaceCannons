package com.sc.game.entity.player;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.sc.game.MainGame;
import com.sc.game.entity.Entity;
import com.sc.game.entity.EntityManager;
import com.sc.game.graphics.TextureManager;

public class PlayerCannon extends Entity {

    private EntityManager entityManager;
    public Sprite player;

    public PlayerCannon (Vector2 pos, Vector2 direction, EntityManager entityManager, Sprite player) {
        super(TextureManager.CANNON_BARREL, pos, direction, 20, 20);
        this.entityManager = entityManager;
        this.player = player;
    }

    @Override
    public void update() {
        pos.set((player.getX() + ((MainGame.SCREEN_WIDTH / 10)/2)-(sprite.getWidth()/2)),
                (player.getY()+((MainGame.SCREEN_WIDTH/20)/2))-(sprite.getHeight()/10));
    }
}
