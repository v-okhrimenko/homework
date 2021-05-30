package ua.ithillel.task1;

import java.io.*;
import java.nio.file.Path;

public class Task1 {
    public static void main(String[] args) {

        Path pathName = Path.of("src/main/java/ua/ithillel/task1/obj.ser");

        Employee employee = new Employee();
        employee.setName("Valdemar");
        employee.setAddress("Ukraine, Kiev, 04189, Malinovskogo 10, app.134");
        employee.setSSN(1234567);
        employee.setNumber(1);

        writeObject(employee, pathName);
        readObject(pathName);

    }

    private static void readObject(Path path) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            Employee employFromFile = (Employee) ois.readObject();
            System.out.println("\nRead object from file:");
            System.out.println(employFromFile);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("\nNo such file or directory...");
        }
    }

    private static void writeObject(Employee e, Path pathName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathName.toFile()))) {
            oos.writeObject(e);
            oos.flush();
            System.out.println("\nFile saved");
        } catch (IOException ioException) {
            System.out.println("\nFile not saved");
        }
    }
}
