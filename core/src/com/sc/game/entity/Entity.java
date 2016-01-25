package com.sc.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.sc.game.MainGame;

public abstract class Entity {

    protected Sprite sprite;
    protected Vector2 pos, direction;

    public Entity(Texture texture, Vector2 pos, Vector2 direction, float scaleX, float scaleY) {
        this.sprite = new Sprite(texture);
        this.sprite.setSize(MainGame.SCREEN_WIDTH / scaleX, MainGame.SCREEN_WIDTH / scaleY);
        this.sprite.setRotation(0);
        this.sprite.setPosition(pos.x, pos.y);
        this.sprite.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.pos = pos;
        this.direction = direction;
    }

    public Sprite getMostRecentSprite() {
        return sprite;
    }

    public void setMostRecentSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public abstract void update();

    public void render(SpriteBatch sb) {
        sprite.setPosition(pos.x,pos.y);
        sprite.draw(sb);
    }

    public Vector2 getPosition() {
        return  pos;
    }

    public Rectangle getBounds() {
        return new Rectangle(pos.x, pos.y, sprite.getWidth(), sprite.getHeight());
    }

    public void setDirection(float x, float y) {
        direction.set(x,y);
        direction.scl(Gdx.graphics.getDeltaTime());
    }
}
