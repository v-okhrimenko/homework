package ua.ithillel.task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class AccountingUser {
    private final RandomAccessFile file;
    private static final ArrayList<UserOfSite> userOfSites = new ArrayList<>();

    public AccountingUser(File path) {
        if (path.exists()) {
            this.file = readUsersTxt(path);
            initUserArray();
        } else {
            System.out.println("File not found. Create new file: " + path.getName());
            File file = new File(path.getPath());
            this.file = readUsersTxt(file);
        }
    }

    private void initUserArray() {
        userOfSites.clear();
        String name;
        int count;
        long pointer;
        try {
            if (file.length() != 0) {
                file.seek(0);
                while (file.getFilePointer() < file.length()) {
                    pointer = file.getFilePointer();
                    String fullData = file.readLine();
                    name = fullData.substring(0, fullData.indexOf(":"));
                    count = Integer.parseInt(fullData.substring(name.length() + 1));
                    userOfSites.add(new UserOfSite(name, count, pointer));
                }
            } else {
                System.out.println("List of users is empty.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private RandomAccessFile readUsersTxt(File file) {
        try {
            return new RandomAccessFile(file, "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addUsers(String nameUser) {
        System.out.println("BEFORE ADD:");
        this.printFile();
        System.out.println("______________");

        if (userOfSites.size() != 0) {
            if (userOfSites.stream().anyMatch(s -> s.getName().equals(nameUser))) {
                UserOfSite user = userOfSites.stream().filter(v -> v.getName().equals(nameUser)).findFirst().get();
                int currentUserId = user.getUserId();
                long indexOfDivider = user.getStartPosition() + user.getName().length();
                int lessonCounter = user.getLessons();
                try {
                    file.seek(indexOfDivider + 1);
                    file.writeBytes(String.valueOf(++lessonCounter));

                    if (lessonCounter > 9) {
                        for (int i = currentUserId + 1; i < userOfSites.size(); i++) {
                            int uid = i;
                            UserOfSite u = userOfSites.stream().filter(us -> us.getUserId() == uid).findFirst().get();
                            file.writeBytes("\n" + u);
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                UserOfSite newUserOfSite;
                try {
                    newUserOfSite = new UserOfSite(nameUser, 1, file.getFilePointer() + 1);
                    userOfSites.add(newUserOfSite);
                    file.seek(file.length());
                    file.writeBytes("\n" + newUserOfSite);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            UserOfSite newUserOfSite;
            try {
                newUserOfSite = new UserOfSite(nameUser, 1, 0);
                userOfSites.add(newUserOfSite);
                file.seek(0);
                file.writeBytes(newUserOfSite.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void printFile() {
        initUserArray();
        userOfSites.forEach(System.out::println);
    }

    protected void finalize() {
        System.out.println("______FILE CLOSE____");
        try {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
