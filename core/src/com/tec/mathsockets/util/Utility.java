package com.tec.mathsockets.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;



public final class Utility {

    private static final String TAG = Utility.class.getSimpleName();
    private static final AssetManager assetManager = new AssetManager();
    private static final InternalFileHandleResolver filePathResolver = new InternalFileHandleResolver();


    /**
     * Check to see whether te asset is loaded,
     * and if it is, then unload the asset from memory.
     * @param assetFilenamePath Asset to unload
     */
    public static void unloadAsset(String assetFilenamePath) {
        // Once the asset manager is done loading
        if (assetManager.isLoaded(assetFilenamePath)) {
            assetManager.unload(assetFilenamePath);
        } else {
            Gdx.app.debug(TAG, "Asset is not loaded, Nothing to unload: " + assetFilenamePath);
        }
    }

    public static float loadCompleted() {
        return assetManager.getProgress();
    }

    public static int numberAssetsQueued() {
        return assetManager.getQueuedAssets();
    }

    public static boolean updateAssetLoading() {
        return assetManager.update();
    }

    public static boolean isAssetLoaded(String filename) {
        return assetManager.isLoaded(filename);
    }

    public static void loadMapAsset(String mapFilename) {
        if (mapFilename == null || mapFilename.isEmpty()) {
            return;
        }

        // Load the asset
        if (filePathResolver.resolve(mapFilename).exists()) {
            assetManager.setLoader(TiledMap.class, new TmxMapLoader(filePathResolver));

            assetManager.load(mapFilename, TiledMap.class);

            /* Until we add the loading screen,
             * just block until we load the map
             */
            assetManager.finishLoadingAsset(mapFilename);
            Gdx.app.debug(TAG, "Map loaded: " + mapFilename);
        } else {
            Gdx.app.debug(TAG, "Map doesn't exist: " + mapFilename);
        }
    }

    public static TiledMap getMapAsset(String mapFilename) {
        TiledMap map = null;

        // Once the asset manager is done loading
        if (assetManager.isLoaded(mapFilename)) {
            map = assetManager.get(mapFilename, TiledMap.class);
        } else {
            Gdx.app.debug(TAG, "Map is not loaded: " + mapFilename);
        }
        return map;
    }

    public static void loadTextureAsset(String textureFilename) {
        if (textureFilename == null || textureFilename.isEmpty()) {
            return;
        }

        // Load Asset
        if (filePathResolver.resolve(textureFilename).exists()) {
            assetManager.setLoader(Texture.class, new TextureLoader(filePathResolver));

            assetManager.load(textureFilename, Texture.class);
            // Until we add the loading screen,
            // just block until we load the map
            assetManager.finishLoadingAsset(textureFilename);
        } else {
            Gdx.app.debug(TAG, "Texture asset unavailable: " + textureFilename);
        }
    }

    public static Texture getTextureAsset(String textureFilename) {
        Texture texture = null;

        // Once the asset manager is done loading
        if (assetManager.isLoaded(textureFilename)) {
            texture = assetManager.get(textureFilename, Texture.class);
        } else {
            Gdx.app.debug(TAG, "Texture is not loaded: " + textureFilename);
        }
        return texture;
    }

}
