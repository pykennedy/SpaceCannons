package com.sc.game.entity.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.sc.game.MainGame;
import com.sc.game.entity.Entity;
import com.sc.game.entity.EntityManager;
import com.sc.game.graphics.TextureManager;

public class Player extends Entity {

    private EntityManager entityManager;

    public Player(Vector2 pos, Vector2 direction, EntityManager entityManager) {
        super(TextureManager.CANNON_BODY, pos, direction, 10, 20);
        this.entityManager = entityManager;
    }

    @Override
    public void update() {
        float accelX = Gdx.input.getAccelerometerY(); // inverted because landscape mode
        pos.add(direction);

        if(accelX < -0.35) { // left
            if (pos.x > 0)
                setDirection(-MainGame.DEFAULT_SPEED, 0);
            else
                setDirection(0, 0);
        }
        else if(accelX > 0.35) { // right
            if(pos.x + sprite.getWidth() < MainGame.SCREEN_WIDTH)
                setDirection(MainGame.DEFAULT_SPEED, 0);
            else
                setDirection(0,0);
        }
        else
            setDirection(0,0);
    }
}
