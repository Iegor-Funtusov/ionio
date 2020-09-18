package ua.com.alevel.ionio.channel;

import java.io.IOException;

/**
 * @author Iehor Funtusov, created 24/07/2020 - 9:03 PM
 */

public class EchoTest {

    private Process process;
    private EchoClient echoClient;

    public void init() throws IOException {
        process = EchoServer.start();
        echoClient = EchoClient.start();
    }

    public void send(String message) {
        System.out.println("message = " + message);
        String res = echoClient.sendMessage(message);
        System.out.println("res = " + res);
    }

    public void stop() throws IOException {
        process.destroy();
        EchoClient.stop();
    }
}
