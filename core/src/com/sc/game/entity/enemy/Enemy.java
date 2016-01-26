package com.sc.game.entity.enemy;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.sc.game.MainGame;
import com.sc.game.entity.Entity;
import com.sc.game.entity.EntityManager;
import com.sc.game.graphics.TextureManager;

public class Enemy extends Entity {
    private EntityManager entityManager;
    private long baseTime;
    private float fakeAccelX = 0;

    public Enemy(Vector2 pos, Vector2 direction, EntityManager entityManager) {
        super(TextureManager.CANNON, pos, direction, 12, 12, 180);
        this.entityManager = entityManager;
        this.baseTime = System.currentTimeMillis();
    }

    @Override
    public void update() {
        pos.add(direction);
        int rotation;
        if(System.currentTimeMillis() > baseTime+MathUtils.random(500,2000)) {
            baseTime = System.currentTimeMillis();
            fakeAccelX = MathUtils.random(-3f, 3f);
            rotation = MathUtils.random(90, 180);
            sprite.setRotation(rotation);
        }
        if(fakeAccelX < -0.5) { // left
            if (pos.x > 0)
                setDirection(-(MainGame.DEFAULT_CANNON_SPEED * ((Math.abs(fakeAccelX)+1))/2), 0);
            else
                setDirection(0, 0);
        }
        else if(fakeAccelX > 0.5) { // right
            if(pos.x + sprite.getWidth() < MainGame.SCREEN_WIDTH)
                setDirection(MainGame.DEFAULT_CANNON_SPEED * ((fakeAccelX+1)/2), 0);
            else
                setDirection(0,0);
        }
        else
            setDirection(0,0);
    }
}
