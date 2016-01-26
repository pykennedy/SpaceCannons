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
        super(TextureManager.CANNON, pos, direction, 12, 12, 0);
        this.entityManager = entityManager;
    }

    @Override
    public void update() {
        float accelX = Gdx.input.getAccelerometerY(); // inverted because landscape mode
        if(accelX > 3)
            accelX = 3;
        if(accelX < -3)
            accelX = -3;
        pos.add(direction);

        if(accelX < -0.35) { // left
            if (pos.x > 0)
                setDirection(-(MainGame.DEFAULT_CANNON_SPEED * ((Math.abs(accelX)+1))/2), 0);
            else
                setDirection(0, 0);
        }
        else if(accelX > 0.35) { // right
            if(pos.x + sprite.getWidth() < MainGame.SCREEN_WIDTH)
                setDirection(MainGame.DEFAULT_CANNON_SPEED * ((accelX+1)/2), 0);
            else
                setDirection(0,0);
        }
        else
            setDirection(0,0);
    }
}
