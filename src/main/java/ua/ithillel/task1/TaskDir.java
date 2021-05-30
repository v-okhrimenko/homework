package ua.ithillel.task1;

import java.io.File;

public class TaskDir {

    private static File[] files = null;

    public static void main(String[] args) {

        if (args.length > 0) {
            files = new File(args[0]).listFiles();
            showFiles(files);
        } else {
            System.out.println("No path in arguments...");
        }

    }

    private static void showFiles(File[] path) {
        if (path == null) {
            System.out.println("You entered the wrong path...");
        } else {
            for (File file : path) {
                System.out.println(file.getName());
            }
        }
    }
}
