package com.tec.mathsockets.network;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import java.io.IOException;


public class GServer {

    public final String TAG = GServer.class.getSimpleName();
    private static Server server;
    private static GServer gameSever;
    private String serverResponse;


    /**
     * Initialize the server
     * @throws IOException Unable to bind to ports
     */
    private GServer() throws IOException {
        init();
    }

    public static GServer getGServerInstance() throws IOException {
        if (gameSever == null) {
            gameSever = new GServer();
        }
        return gameSever;
    }

    /**
     * Singleton || Get a unique instance of the server
     * @return Server instance
     */
    public static Server getServerInstance() {
        if (server == null) {
            server = new Server();
        }
        return server;
    }


    /**
     * Initialize the server on ports TCP: 54555, UDP: 54777
     * and stay open to new requests
     * @throws IOException Unable to initialize Server
     */
    private void init() throws IOException {
        getServerInstance();
        getServerInstance().start();

        Gdx.app.debug(TAG, "The server has been started correctly");

        serverResponse = " ";

        getServerInstance().bind(54555, 54777);

        getServerInstance().addListener(new Listener() {
            public void received (Connection connection, Object object) {
                if (object instanceof someRequest) {
                    someRequest request = (someRequest)object; // Listen to client responses
                    System.out.println(request.write());

                    someResponse response = new someResponse();
                    connection.sendTCP(response.write());
                }
            }
        });
    }


    /**
     * Stop the server from receiving requests and sending responses
     */
    public void dispose() {
        getServerInstance().stop();
    }



    public static class someRequest {
        public String write() {
            String message;
            message = "Hello";

            String clientString = EventManager.json.toJson(message);

            EventManager.files.writeString(clientString, true);
            return clientString;
        }

        public void read() {

        }
    }


    public static class someResponse{
        public String write() {
            Json json = new Json();
            String received;
            received = "Hello2";
            String serverString = json.toJson(received);
            return serverString;
        }

        public void read() {

        }
    }


}





