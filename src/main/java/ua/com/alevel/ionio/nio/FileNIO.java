package ua.com.alevel.ionio.nio;

import ua.com.alevel.ionio.abstracts.AbstractIO;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Iehor Funtusov, created 21/07/2020 - 7:36 PM
 */

public class FileNIO implements AbstractIO {

    @Override
    public void createFile() {
        Path path = Paths.get("file.txt");
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("path = " + path);
    }

    @Override
    public void createDir() {
        Path path = Paths.get("test/test1");
        try {
            if (!Files.exists(path)) {
                Files.createDirectory(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("path = " + path.toFile().getAbsolutePath());

//        try {
//            path = Files.createTempDirectory("test");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("path = " + path.toFile().getAbsolutePath());
//
//        Path file = path.resolve("file.txt");
//        try {
//            Files.createFile(file);
//            System.out.println("file = " + file.toFile().getAbsolutePath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        Files.copy(pathSource, pathDestination);


//        Path pathSource = Paths.get("Вставьте сюда путь к файлу/директории, который надо переместить");
//        Path pathDestination = Paths.get("Вставьте сюда путь для нового местоположения файла/директории");
//        try {
//            Files.move(pathSource, pathDestination, StandardCopyOption.REPLACE_EXISTING);
//            System.out.println("Source file copied successfully");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        Path pathSource = Paths.get("Вставьте сюда путь к файлу/директории для удаления");
//        try {
//            Files.delete(pathSource);
//            System.out.println("File deleted successfully");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void listFiles() {
        createDir();
        Set<String> fileList = new HashSet<>();
        try {
            DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get("test"));
            for (Path path : paths) {
                fileList.add(path.getFileName().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileList.forEach(System.out::println);
    }

    @Override
    public void fetchFiles() {
        Set<String> fileList = new HashSet<>();
        try {
            Stream<Path> pathStream = Files.walk(Paths.get("test"));
            fileList = pathStream
                    .filter(Files::isDirectory)
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileList.forEach(System.out::println);
    }
}
