package ua.ithillel.task2;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {

        Path path = Path.of("src/main/java/ua/ithillel/task2/users.ser");
        User[] users = new User[5];

        for (int i = 0; i < 5; i++) {
            users[i] = new User("name" + i, "lastName" + 1, i);
        }
        saveTo(users, path);
        readFrom(path);
    }

    private static void readFrom(Path path) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            try {
                User[] usersFromFile = (User[]) objectInputStream.readObject();
                Arrays.stream(usersFromFile).forEach(System.out::println);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveTo(User[] users, Path path) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            objectOutputStream.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
