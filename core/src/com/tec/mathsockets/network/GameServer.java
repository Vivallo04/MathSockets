package com.tec.mathsockets.network;

import com.badlogic.gdx.Gdx;
import com.tec.mathsockets.MathSockets;
import com.tec.mathsockets.entity.Player;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

public class GameServer {

    private final String TAG = GameServer.class.getSimpleName();
    private Socket socket;

    private Player player;
    String id;

    private MathSockets game;

    public GameServer(MathSockets game, Player player) {
        this.game = game;
        this.player = player;
        init();
        configSocketEvents();
    }

    private void init() {
        try {
            socket = IO.socket("http://localhost:8080");
            socket.connect();

        } catch (URISyntaxException e) {
            Gdx.app.debug(TAG, "Unable to connect to server: " + e);
            e.printStackTrace();
        }
    }

    public void configSocketEvents() {
        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Gdx.app.debug(TAG, "Connected");
            }
        });
        socket.on("SocketID", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                JSONObject data = (JSONObject) args[0];
                try {
                    id = data.getString("id");
                    game.connectedPLayers.put(id, player);
                    Gdx.app.log(TAG, "My id: " + id);

                    Gdx.app.debug(TAG, "Total of connected players: "
                            + game.connectedPLayers.size());
                } catch (JSONException e) {
                    Gdx.app.debug(TAG, "Error getting id" + e);
                    e.printStackTrace();
                }
            }
        });

        socket.on("newPlayer", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                JSONObject data = (JSONObject) args[0];
                try {
                    id = data.getString("id");
                    game.connectedPLayers.put(id, player);
                    Gdx.app.log(TAG, "Player connected id: " + id);
                    Gdx.app.debug(TAG, "Total of connected players: "
                                        + game.connectedPLayers.size());

                } catch (JSONException e) {
                    Gdx.app.debug(TAG, "Error getting new player's id" + e);
                    e.printStackTrace();
                }
            }
        });

        socket.on("playerDisconnected", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                JSONObject data = (JSONObject) args[0];
                try {
                    id = data.getString(id);
                    game.connectedPLayers.remove(id);
                } catch (JSONException e) {
                    Gdx.app.debug(TAG, "Error disconnecting players" + e);
                    e.printStackTrace();
                }
            }
        });

        socket.on("getPlayers", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                JSONArray objects = (JSONArray) args[0];
                try {
                    for (int i = 0; i < objects.length(); i++) {
                        double x = ((Double) objects.getJSONObject(i).getDouble("x")).floatValue();
                        double y = ((Double) objects.getJSONObject(i).getDouble("y")).floatValue();

                        player.getCurrentPlayerPosVector().x = (float) x;
                        player.getCurrentPlayerPosVector().y = (float) y;

                        game.connectedPLayers.put(objects.getJSONObject(i).getString("id"), player);
                    }
                } catch (JSONException e) {
                    Gdx.app.debug(TAG, "Error getting new players");
                    e.printStackTrace();
                }

            }
        });

        socket.on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Gdx.app.debug(TAG, "Player disconnected");
                socket.close();
            }
        });
    }

    public void dispose() {
        socket.disconnect();
        socket.connect().disconnect();
        socket.connect().close();
        socket.close();
    }
}
