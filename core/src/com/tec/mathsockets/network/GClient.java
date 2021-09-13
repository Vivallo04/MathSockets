package com.tec.mathsockets.network;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.tec.mathsockets.util.EventHandler;

import java.io.IOException;


public class GClient {

    private Client client;

    private final String TAG = GClient.class.getSimpleName();

    public GClient() throws IOException {
        init();
        Kryo kryo = client.getKryo();
        kryo.register(GServer.someResponse.class);
        kryo.register(GServer.someRequest.class);
    }

    private void init() throws IOException {
        String message;
        message = "";

        String clientString = EventHandler.json.toJson(message);

        client = new Client();

        client.start();
        client.connect(5000, "localhost", 54555, 54777);

        GServer.someRequest request = new GServer.someRequest(); // Envía mensaje al servidor
        client.sendTCP(request.write());

        client.addListener(new Listener() {
            public void received (Connection connection, Object object) {
                if (object instanceof GServer.someResponse) {
                    GServer.someResponse response = (GServer.someResponse)object; // Recibe mensaje del servidor
                    System.out.println(response.write());
                }
            }
        });
    }

    public Client getClient() {
        return this.client;
    }
}


