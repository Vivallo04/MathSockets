package com.tec.mathsockets;

import com.tec.mathsockets.network.GClient;
import com.tec.mathsockets.network.GServer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

class MathSocketsTest {

    static ArrayList<GClient> clients = new ArrayList<>();
    static GServer server;

    @BeforeAll
    static void initTest() throws IOException {
        server = new GServer();
        int serverCount = 500;
        while (serverCount > 0) {
            clients.add(new GClient());
        }
    }

    @Test
    void testClientConnection() {
        //assers(tTrue();
        //        //1assertEqual);
    }

}