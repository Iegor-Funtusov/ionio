package ua.com.alevel.ionio.channel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.*;

/**
 * @author Iehor Funtusov, created 24/07/2020 - 8:36 PM
 */

public class EchoServer {

    public static void main(String[] args) throws IOException {

        System.out.println("EchoServer.main");
        Selector selector = Selector.open();
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress("localhost", 5454));
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_ACCEPT);
        ByteBuffer byteBuffer = ByteBuffer.allocate(256);

        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    register(selector, channel);
                }
                if (selectionKey.isReadable()) {
                    readable(byteBuffer, selectionKey);
                }
                iterator.remove();
            }
        }
    }

    private static void register(Selector selector, ServerSocketChannel channel) throws IOException {
        SocketChannel socketChannel = channel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    private static void readable(ByteBuffer byteBuffer, SelectionKey selectionKey) throws IOException {
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        channel.read(byteBuffer);
        byteBuffer.flip();
        channel.write(byteBuffer);
        byteBuffer.clear();
    }

    public static Process start() throws IOException {
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
        String javaClassPath = System.getProperty("java.class.path");
        String className = EchoServer.class.getName();

        ProcessBuilder processBuilder = new ProcessBuilder(javaBin, "-cp", javaClassPath, className);
        return processBuilder.start();
    }
}
