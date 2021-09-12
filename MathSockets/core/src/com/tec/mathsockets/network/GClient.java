package com.tec.mathsockets.network;

import com.badlogic.gdx.utils.Json;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import java.io.IOException;



public class GClient {

    public GClient() throws IOException {

        init();
    }

    private void init() throws IOException {
        Json json = new Json();
        String mensaje;
        mensaje = "{\n" +
                "Clients: [\n" +
                "\t{\n" +
                "\t\tConnecting clients: \"5\",\n" +
                "\t\tClients connected successfully: \"1\",\n" +
                "}";
        String cadenaCliente = json.toJson(mensaje);


        Client client = new Client();
        Kryo kryo = client.getKryo();
        kryo.register(GServer.someResponse.class);
        kryo.register(GServer.someRequest.class);

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
    }


