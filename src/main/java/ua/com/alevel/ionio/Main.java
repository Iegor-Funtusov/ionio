package ua.com.alevel.ionio;

import ua.com.alevel.ionio.abstracts.FileChannelCustom;
import ua.com.alevel.ionio.channel.EchoTest;
import ua.com.alevel.ionio.io.FileIO;
import ua.com.alevel.ionio.nio.FileNIO;
import ua.com.alevel.ionio.serializable.SerializableTest;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Iehor Funtusov, created 21/07/2020 - 7:33 PM
 */

public class Main implements Serializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        SerializableTest.run();

//        FileIO io = new FileIO();
//        io.createDir();
//        FileNIO nio = new FileNIO();
//        nio.fetchFiles();

//        EchoTest echoTest = new EchoTest();
//        echoTest.init();
//        for (int i = 0; i < 100; i++) {
//        echoTest.send("test: ");
//        }
//        echoTest.stop();


//        SerializableTest.run();

//        FileIO fileIO = new FileIO();
//        fileIO.createDir();
//        fileIO.createFile();
//        fileIO.fetchFiles();
//        fileIO.listFiles();
//        FileNIO fileNIO = new FileNIO();
//        fileNIO.createFile();
//        fileNIO.createDir();
//        fileNIO.listFiles();
//        fileNIO.fetchFiles();
//        testRead();
//        testWrite();
//        channel();
    }

    private static void testRead() {
        try {
            Reader reader = new FileReader("test.txt");
            int s;
            while ((s = reader.read()) != -1) {
                System.out.println("reader = " + (char) s);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testWrite() {
//        test bla
//        File file = new File("test");
        try {
            Writer writer = new FileWriter("test.txt");
            String word = "test bla";
            char[] chars = word.toCharArray();
//            for (int i = 0 ; i < chars.length ; i++) {
//                int utf = chars[i];
//                writer.write(utf);
//            }
            writer.write(chars);
            writer.write("1");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void channel() {
        Path path = Paths.get("file.txt");
        try {
            FileChannel fileChannel = FileChannel.open(path);
            ByteBuffer buffer = ByteBuffer.allocate(5);
            int noOfBytesRead = fileChannel.read(buffer);
            System.out.println("noOfBytesRead = " + noOfBytesRead);
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            FileNIO nio = new FileNIO();
            new Thread(() -> {
                nio.createFile();
            }).start();
        }


//        FileChannelCustom custom = new FileChannelCustom();
    }
}
