package com.tec.mathsockets.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

import java.nio.file.Files;

public class EventHandler {

    public static Json json = new Json();
    public static FileHandle files = Gdx.files.local("text/request.json");
}
