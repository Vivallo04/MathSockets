package com.tec.mathsockets.network;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.tec.mathsockets.util.EventHandler;

import java.io.IOException;


public class GServer {

    public final String TAG = GServer.class.getSimpleName();
    private static Server server = new Server();
    private String serverResponse;

    public GServer() throws IOException {
        init();
    }

    private void init() throws IOException {
        server.start();

        Gdx.app.debug(TAG, "The server has been started correctly");

        serverResponse = "";

        // Initialize the server on port 54555 (TCP) and 54777 (UDP)
        server.bind(54555, 54777);

        server.addListener(new Listener() {
            public void received (Connection connection, Object object) {
                if (object instanceof someRequest) {
                    someRequest request = (someRequest)object; // Recibe el mensaje del cliente
                    System.out.println(request.write());

                    someResponse response = new someResponse();
                    connection.sendTCP(response.write());
                }
            }
        });
    }

    public static Server getServer() {
        return server;
    }

    public static class someRequest {
        public String write() {
            String message;
            message = "Hello";

            String clientString = EventHandler.json.toJson(message);

            EventHandler.files.writeString(clientString, true);
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





