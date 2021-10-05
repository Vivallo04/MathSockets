package com.tec.mathsockets.entity;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Entity extends Sprite {

    protected TextureRegion textureRegion;
    protected TextureAtlas textureAtlas;
    protected Sprite sprite;


    public Entity() {

    }

}
