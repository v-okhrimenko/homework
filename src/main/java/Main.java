import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        Path path = Path.of("/Users/JULIA/java/homework/l4/JavaTest/src/main/java/java1.test");
        if (path.toFile().exists()) {
            TestRun.run(path, 3);
        } else {
            System.out.println("Такого файла не существует...");
        }

    }
}
