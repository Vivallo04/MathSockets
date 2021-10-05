package com.tec.mathsockets.network;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.tec.mathsockets.entity.Player;

import java.io.IOException;


public class GClient {

    private final String TAG = GClient.class.getSimpleName();
    private Client client;

    private Player player;

    /**
     * Initialize the Client and bind to the available Server
     * @throws IOException
     */
    public GClient() throws IOException {
        init();
        Kryo kryo = client.getKryo();
        //kryo.register(GServer.someResponse.class);
        kryo.register(GServer.someRequest.class);
    }


    /**
     * Initialize the client and bind to localhost and connect
     * @throws IOException Unable to connect to server
     */
    private void init() throws IOException {
        String message;
        message = "Client message ";
        String clientString = EventManager.json.toJson(message);

        client = new Client();
        client.start();
        client.connect(5000, "localhost", 54555, 54777);

        player = new Player(null);

        GServer.someRequest request = new GServer.someRequest(); // Envía mensaje al servidor
        client.sendTCP(request.write());
        /*
        client.addListener(new Listener() {
            public void received (Connection connection, Object object) {
                if (object instanceof Player) {
                    GServer.someResponse response = (GServer.someResponse)object; // Recibe mensaje del servidor
                    System.out.println(response.write());
                }
            }
        });

         */
    }

    /**
     * Get client instance
      * @return client instance
     */
    public Client getClient() {
        return this.client;
    }


    /**
     * Disconnect the client from the server and
     * eliminate its instance
     */
    public void dispose() {
        client.stop();
    }
}


