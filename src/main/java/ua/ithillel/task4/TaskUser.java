package ua.ithillel.task4;

import java.io.File;
import java.util.Scanner;

public class TaskUser {
    public static void main(String[] args) {

        //File file = new File("src/main/java/ua/ithillel/task4/users2.txt");
        File pathToFile = new File("null");
        AccountingUser user = new AccountingUser(pathToFile);

        boolean noExit = true;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nSelect:");
            System.out.println("1. List of users\n2. Add user\n3. Exit");
            switch (scanner.nextLine()) {
                case "1":
                    System.out.println("List of users:");
                    user.printFile();
                    break;
                case "2":
                    System.out.println("Enter user name: ");
                    user.addUsers(scanner.next());
                    System.out.println("AFTER ADD USER");
                    user.printFile();
                    break;
                case "3":
                    user.finalize();
                    noExit = false;
                    break;
                default:
                    System.out.println("Select one of this variant.");
            }
        }
        while (noExit);
    }
}
