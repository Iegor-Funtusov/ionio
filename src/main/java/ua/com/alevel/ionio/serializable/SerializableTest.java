package ua.com.alevel.ionio.serializable;

import java.io.*;

/**
 * @author Iehor Funtusov, created 24/07/2020 - 7:11 PM
 */

public class SerializableTest {

    public static void run() throws IOException, ClassNotFoundException {
        Group group = new Group(1);
        Student sabina = new Student("Sabina", group);
        Student marina = new Student("Marina", group);
        Student julia = new Student("Julia", group);

        System.out.println("sabina = " + sabina);
        System.out.println("marina = " + marina);
        System.out.println("julia = " + julia);

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("student.out"));
        outputStream.writeObject(sabina);
        outputStream.writeObject(marina);
        outputStream.writeObject(julia);
        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("student.out"));
        sabina = (Student) inputStream.readObject();
        marina = (Student) inputStream.readObject();
        julia = (Student) inputStream.readObject();
        inputStream.close();

        System.out.println("sabina = " + sabina);
        System.out.println("marina = " + marina);
        System.out.println("julia = " + julia);

//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

//        outputStream = new ObjectOutputStream(byteArrayOutputStream);
//        outputStream.writeObject(sabina);
//        outputStream.writeObject(marina);
//        outputStream.writeObject(julia);
//        outputStream.close();
//
//        inputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
//        sabina = (Student) inputStream.readObject();
//        marina = (Student) inputStream.readObject();
//        julia = (Student) inputStream.readObject();
//        inputStream.close();
//
//        System.out.println("sabina = " + sabina);
//        System.out.println("marina = " + marina);
//        System.out.println("julia = " + julia);
    }
}
