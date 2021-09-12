package com.tec.mathsockets.network;

import com.badlogic.gdx.utils.Json;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import java.io.IOException;


public class GServer {

    public GServer() throws IOException {
        init();
    }

    private void init() throws IOException {
        final Json json = new Json();
        final String respuesta_servidor;
        respuesta_servidor = "{\n" +
                "Clients: [\n" +
                "\t{\n" +
                "\t\tConnecting clients: \"5\",\n" +
                "\t\tClients connected successfully: \"1\",\n" +
                "}";

        Server server = new Server();
        server.start();
        server.bind(54555, 54777);
        Kryo kryo = server.getKryo();
        kryo.register(someRequest.class);
        kryo.register(someResponse.class);

        server.addListener(new Listener() {
            public void received (com.esotericsoftware.kryonet.Connection connection, Object object) {
                if (object instanceof someRequest) {
                    someRequest request = (someRequest)object; // Recibe el mensaje del cliente
                    System.out.println(request.write());

                    someResponse response = new someResponse();
                    connection.sendTCP(response.write());
                }
            }
        });

    }


    public static class someRequest {

        public String write() {
            Json json = new Json();
            String mensaje;
            mensaje = "{\n" +
                    "Clients: [\n" +
                    "\t{\n" +
                    "\t\tConnecting clients: \"5\",\n" +
                    "\t\tClients connected successfully: \"1\",\n" +
                    "}";
            String cadenaCliente = json.toJson(mensaje);
            return cadenaCliente;

        }

        public void read() {

        }
    }

    public static class someResponse{

        public String write() {
            Json json = new Json();
            String recibido;
            recibido = "{\n" +
                    "Server: [\n" +
                    "\t{\n" +
                    "\t\tNew Client connected" +
                    "}";
            String cadenaServidor = json.toJson(recibido);
            return cadenaServidor;

        }

        public void read() {

        }
    }
}





