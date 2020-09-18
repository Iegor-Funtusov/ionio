package ua.com.alevel.ionio.io;

import ua.com.alevel.ionio.abstracts.AbstractIO;
import ua.com.alevel.ionio.abstracts.FileFilterCustom;

import java.io.*;
import java.util.Date;

/**
 * @author Iehor Funtusov, created 21/07/2020 - 7:36 PM
 */

public class FileIO implements AbstractIO {

    @Override
    public void createFile() {
//        File file = new File("file.txt");
//        System.out.println("file = " + file);
//        System.out.println("getAbsolutePath = " + file.getAbsolutePath());
//        System.out.println("length = " + file.length());
//        System.out.println("exists = " + file.exists());
//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("exists = " + file.exists());
//        System.out.println("isFile = " + file.isFile());
//        System.out.println("isHidden = " + file.isHidden());

//        try (PrintStream out = new PrintStream(new FileOutputStream("file.txt"))) {
//            out.println("bla bla");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

//        boolean exists = file.exists();
//        System.out.println("exists = " + exists);

//        System.out.println("is file = " + file.isFile());
//        System.out.println("is dir = " + file.isDirectory());
//        System.out.println("is name = " + file.getName());
//        System.out.println("is path = " + file.getPath());
//        System.out.println("is absolute path = " + file.getAbsolutePath());
//        System.out.println("is length = " + file.length());
//        System.out.println("is length = " + new Date(file.lastModified()));
    }

    @Override
    public void createDir() {
        File dir = new File("test");
        boolean mkdir = dir.mkdir();

        dir = new File("test/test1/test2");
        mkdir = dir.mkdirs();
    }

    private void consoleCommander(File file) {
        System.out.println("dir = " + file.getPath());
        File[] list = file.listFiles();
        for (File currentFile : list) {
            if (currentFile.isDirectory()) {
                consoleCommander(currentFile);
            } else {
                System.out.println("file = " + currentFile.getName());
            }
        }
    }

    @Override
    public void listFiles() {

        // 1
//        File[] files = File.listRoots();
//        for (File file : files) {
//            System.out.println("file = " + file.getName());
//            System.out.println("file = " + file.getPath());
//        }

        // 2
//        File rootFile = new File("test");
        File rootFile = new File("test");
        consoleCommander(rootFile);
//        rootFile.mkdirs();
//        File[] files = rootFile.listFiles();
//        System.out.println("files = " + files.length);
//        for (File file : files) {
//            if (file.isFile()) {
//                System.out.println("file = " + file.getName());
//            } else {
//                System.out.println("dir = " + file.getName());
//            }
//        }

        // 3
//        File[] files = rootFile.listFiles((FileFilterCustom) File::isFile);
//
//        for (File file : files) {
//            System.out.println("file = " + file.getPath());
//        }
//
//        System.out.println("------------------------------------------------------");

        // 4
//        File[] files = rootFile.listFiles((file, name) -> name.endsWith(".txt"));
//
//        for (File file : files) {
//            System.out.println("file = " + file.getPath());
//        }
    }

    @Override
    public void fetchFiles() {
        File dir = new File("test");
        this.fetchFiles(dir);
    }

    private void fetchFiles(File dir) {
        System.out.println("dir = " + dir.getAbsolutePath());
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                fetchFiles(file);
            }
        }
    }
}
