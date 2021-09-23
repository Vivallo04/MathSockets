package com.tec.mathsockets.util;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public final class TheTexturePacker {

    public static void generateTextureAtlas(String input, String output, String atlasName) {
        TexturePacker.process(input, output, atlasName);
    }


    public static void main (String[] args) throws Exception {
        TheTexturePacker.generateTextureAtlas("core/assets/ui", "core/assets/atlases", "UI_ATLAS");
    }



}
