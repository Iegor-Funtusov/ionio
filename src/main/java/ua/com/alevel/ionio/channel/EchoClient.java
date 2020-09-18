package ua.com.alevel.ionio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author Iehor Funtusov, created 24/07/2020 - 8:55 PM
 */

public class EchoClient {

    private static SocketChannel socketChannel;
    private static ByteBuffer byteBuffer;
    private static EchoClient echoClient;

    private EchoClient() throws IOException {
        socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 5454));
        byteBuffer = ByteBuffer.allocate(256);
    }

    public static EchoClient start() throws IOException {
        if (echoClient == null) {
            echoClient = new EchoClient();
        }
        return echoClient;
    }

    public static void stop() throws IOException {
        socketChannel.close();
        byteBuffer = null;
    }

    public String sendMessage(String message) {
        byteBuffer = ByteBuffer.wrap(message.getBytes());
        String res = null;
        try {
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
            socketChannel.read(byteBuffer);
            res = new String(byteBuffer.array()).trim();
            byteBuffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
