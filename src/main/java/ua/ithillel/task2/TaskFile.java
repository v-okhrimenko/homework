package ua.ithillel.task2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class TaskFile {
    public static void main(String[] args) throws IOException {
        Path path;

        if (args.length > 0) {
            path = Path.of(args[0]);
            if (Files.exists(path)) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])))) {
                    System.out.println("\nFile: " + path.getFileName() + ":\n");
                    while (br.read() != -1) {
                        System.out.println(br.readLine());
                    }
                }
            } else {
                System.out.println("File not found");
            }
        } else {
            System.out.println("No path to show file...");
        }
    }
}
