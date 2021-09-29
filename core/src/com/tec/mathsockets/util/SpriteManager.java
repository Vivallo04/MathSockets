package com.tec.mathsockets.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class SpriteManager {

    private final String TAG = SpriteManager.class.getSimpleName();
    private final String spritePaths = "core/assets/characters/spritePaths.txt";

    public HashMap<String, String> spritesPathMap = new HashMap<>();

    Animation<TextureRegion> idleAnimation;
    Animation<TextureRegion> walkAnimation;
    Texture walkSheet;
    Texture idleSheet;

    private float stateTime;
    public CharacterType currentSprite;

    private int FRAME_COLS_IDLE;
    private int FRAME_ROWS_IDLE;
    private int FRAME_COLS_WALKING;
    private int FRAME_ROWS_WALKING;

    public enum CharacterType {
        BALLOONEY,
        BLANKEY,
        LIL_WIZ,
        MR_CIRCUIT,
        ROACH,
        ROBO_RETRO,
    }

    public enum AnimationState {
        IDLE,
        WALKING
    }

    public SpriteManager(CharacterType characterType) {
        // Initialize rows and columns
        this.currentSprite = characterType;

        try {
            loadSpritePaths();
        } catch (IOException e) {
            Gdx.app.debug(TAG, "Unable to load sprites from path " + e);
            e.printStackTrace();
        }

        // set the size of the different Sprite sheets
        setSpriteSheetDimensionsIdle(currentSprite);
        setSpriteSheetDimensionsWalking(currentSprite);

        // Load the frames from the spritesheet as an Animation
        initIdleAnimation();
        initWalkingAnimation();
    }

    private void initWalkingAnimation() {
        Utility.loadTextureAsset(getSpriteTexture(currentSprite, AnimationState.WALKING));

        // Load the sprites as a texture
        walkSheet = Utility.getTextureAsset(getSpriteTexture(currentSprite, AnimationState.WALKING));
        Gdx.app.debug(TAG, "Loaded walksheet sprite");

        TextureRegion[][] temp = TextureRegion.split(walkSheet, walkSheet.getWidth() / FRAME_COLS_WALKING,
                walkSheet.getHeight() / FRAME_ROWS_WALKING);

        TextureRegion[] walkFrames = new TextureRegion[FRAME_ROWS_WALKING * FRAME_COLS_WALKING];

        int index = 0;
        for (int i = 0; i < FRAME_ROWS_WALKING; i++) {
            for (int j = 0; j < FRAME_COLS_WALKING; j++) {
                walkFrames[index++] = temp[i][j];
            }
        }

        // Initialize the Animation with the frame interval and array of frames
        walkAnimation = new Animation<TextureRegion>(0.20f, walkFrames);
        // Reset the elpased animation time to 0
        stateTime = 0f;
    }

    private void initIdleAnimation() {
        Utility.loadTextureAsset(getSpriteTexture(currentSprite, AnimationState.IDLE));
        idleSheet = Utility.getTextureAsset(getSpriteTexture(currentSprite, AnimationState.IDLE));
        Gdx.app.debug(TAG, "Loaded idle sprite");


        TextureRegion[][] temp = TextureRegion.split(idleSheet, idleSheet.getWidth() / FRAME_COLS_IDLE,
                idleSheet.getHeight() / FRAME_ROWS_IDLE);

        TextureRegion[] idleFrames = new TextureRegion[FRAME_ROWS_IDLE * FRAME_COLS_IDLE];

        int index = 0;
        for (int i = 0; i < FRAME_ROWS_IDLE; i++) {
            for (int j = 0; j < FRAME_COLS_IDLE; j++) {
                idleFrames[index++] = temp[i][j];
            }
        }

        idleAnimation = new Animation<TextureRegion>(0.020f, idleFrames);
        stateTime = 0f;
    }

    private void loadSpritePaths() throws IOException {
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(spritePaths));

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":", 2);
            if (parts.length >= 2) {
                String key = parts[0];
                String value = parts[1];
                spritesPathMap.put(key, value);
            } else {
                Gdx.app.debug(TAG, "Ignoring line: " + line);
            }
        }
        reader.close();
    }

    private String getSpriteTexture(CharacterType characterType, AnimationState state) {
        return spritesPathMap.get(characterType.toString() + state.toString());
    }

    public Animation<TextureRegion> getIdleAnimation() {
        return idleAnimation;
    }

    public Animation<TextureRegion> getWalkAnimation() {
        return walkAnimation;
    }

    public HashMap<String, String> getSpritesPathMap() {
        return spritesPathMap;
    }

    public float getStateTime() {
        return stateTime;
    }

    public void addStateTime(float newStateTime) {
        this.stateTime += newStateTime;
    }

    public void setSpriteSheetDimensionsWalking(int rows, int cols) {
        setFrameRowsWalking(rows);
        setFrameColsWalking(cols);
    }

    public void setSpriteSheetDimensionsIdle(int rows, int cols) {
        setFRAME_ROWS_IDLE(rows);
        setFRAME_COLS_IDLE(cols);
    }

    private void setSpriteSheetDimensionsIdle(CharacterType characterType) {
        switch (characterType) {
            case BALLOONEY:
            case MR_CIRCUIT:
            case ROACH:
                setSpriteSheetDimensionsIdle(1, 2);
                break;
            case BLANKEY:
                setSpriteSheetDimensionsIdle(1, 4);
                break;
            case LIL_WIZ:
                setSpriteSheetDimensionsIdle(1, 5);
                break;
            case ROBO_RETRO:
                setSpriteSheetDimensionsIdle(1, 9);
                break;
            default:
                try {
                    throw new IllegalAccessException("Unable to set sprite sheet dimensions (Idle)");
                } catch (IllegalAccessException e) {
                    Gdx.app.debug(TAG, String.valueOf(e));
                    e.printStackTrace();
                }
        }
    }

    private void setSpriteSheetDimensionsWalking(CharacterType characterType) {
        switch (characterType) {
            case BALLOONEY:
            case ROACH:
                setSpriteSheetDimensionsWalking(1, 2);
                break;
            case MR_CIRCUIT:
                setSpriteSheetDimensionsWalking(1, 3);
                break;
            case BLANKEY:
                setSpriteSheetDimensionsWalking(1, 4);
                break;
            case LIL_WIZ:
            case ROBO_RETRO:
                setSpriteSheetDimensionsWalking(1, 6);
                break;
            default:
                try {
                    throw new IllegalAccessException("Unable to set sprite sheet dimensions (Walking)");
                } catch (IllegalAccessException e) {
                    Gdx.app.debug(TAG, String.valueOf(e));
                    e.printStackTrace();
                }
        }
    }

    /**
     * Print assets' name with their respective path
     */
    public void printSpritesMap() {
        for (String key: spritesPathMap.keySet()) {
            System.out.println(key + " = " + spritesPathMap.get(key));
        }
    }

    /** @return number of rows in sprite sheet*/
    public int getFrameRows() {
        return FRAME_ROWS_WALKING;
    }

    /**
     * Set the number of rows of the current sprite sheet
     * @param frameRows int number of rows
     */
    public void setFrameRowsWalking(int frameRows) {
        FRAME_ROWS_WALKING = frameRows;
    }

    /** @return number of columns in sprite sheet */
    public int getFrameCols() {
        return FRAME_COLS_WALKING;
    }

    /**
     * Set the number of cols of the current sprite sheet
     * @param frameCols int number of cols
     */
    public void setFrameColsWalking(int frameCols) {
        FRAME_COLS_WALKING = frameCols;
    }

    public void setFRAME_COLS_IDLE(int FRAME_COLS_IDLE) {
        this.FRAME_COLS_IDLE = FRAME_COLS_IDLE;
    }

    public void setFRAME_ROWS_IDLE(int FRAME_ROWS_IDLE) {
        this.FRAME_ROWS_IDLE = FRAME_ROWS_IDLE;
    }
}