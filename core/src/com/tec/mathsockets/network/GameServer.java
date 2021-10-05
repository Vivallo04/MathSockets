package com.tec.mathsockets.network;

import com.badlogic.gdx.Gdx;
import com.tec.mathsockets.MathSockets;
import com.tec.mathsockets.entity.Player;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

public class GameServer {

    private final String TAG = GameServer.class.getSimpleName();
    private Socket socket;

    private Player player;

    public GameServer(Player player) {
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
                    String id = data.getString("id");
                    Gdx.app.log(TAG, "My id: " + id);
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
                    String id = data.getString("id");
                    MathSockets.connectedPLayers.put(id, player);
                    Gdx.app.log(TAG, "My id: " + id);

                } catch (JSONException e) {
                    Gdx.app.debug(TAG, "Error getting new player's id" + e);
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
        socket.close();
    }
}
