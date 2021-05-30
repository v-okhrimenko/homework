package ua.ithillel.task3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Scanner;

public class TaskCopy {
    public static void main(String[] args) {

        boolean isFile = true;
        boolean isFolder = true;

        replacementInFile(new File("src/main/java/ua/ithillel/task3/Test.txt"));

        System.out.println("___________________");
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("enter origin file path: ");
            String origin = scanner.nextLine();
            File oldFile = new File(origin);

            if (checkPathToFile(oldFile) & !origin.isEmpty()) {
                do {
                    System.out.println("enter new path to file and file name: ");
                    String newFileString = scanner.nextLine();
                    File newFile = new File(newFileString);

                    if (checkPathToFolder(newFileString)) {
                        copyFiles(oldFile, newFile);
                        isFile = false;
                        isFolder = false;
                    } else {
                        System.out.println("Enter correct path and file name");
                    }
                }
                while (isFolder);

            } else {
                System.out.println("Enter correct path and file name");
            }
        }
        while (isFile);
    }

    private static boolean checkPathToFolder(String newFileString) {
        try {
            return Files.exists(Path.of(newFileString).getParent());
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean checkPathToFile(File path) {
        return Files.exists(path.toPath());
    }

    public static void copyFiles(File oldFile, File newFile) {
        try (FileReader fr = new FileReader(oldFile); FileWriter fw = new FileWriter(newFile)) {
            System.out.println("Copy file " + oldFile);
            fr.transferTo(fw);

//            или так:

//            int x;
//            while ((x = fr.read()) != -1){
//                System.out.println(fr.toString());
//                fw.write(x);
//            }
        } catch (FileNotFoundException e) {
            System.out.println("No such file or directory...enter correct path");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Copy ended");
    }

    public static void replacementInFile(File file) {
        if (readFromFile(file) != null) {
            System.out.println("Replacing in a file " + file.getName());
            saveToFile(file, Objects.requireNonNull(readFromFile(file)).replaceAll("public", "protected"));
        }
    }


    public static String readFromFile(File file) {
        StringBuilder textFromFile = new StringBuilder();
        try (FileReader fr = new FileReader(file)) {
            int data = fr.read();
            while (data != -1) {
                textFromFile.append((char) data);
                data = fr.read();
            }
            return textFromFile.toString();

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void saveToFile(File file, String txt) {
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(txt);
            fw.flush();
            System.out.println("Replacement complete");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
