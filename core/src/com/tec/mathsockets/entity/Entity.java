package com.tec.mathsockets.entity;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Entity implements InputProcessor {

    private TextureRegion textureRegion;
    private TextureAtlas textureAtlas;
    private Sprite sprite;

    public Entity() {

    }

}
