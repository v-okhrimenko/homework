import java.util.Scanner;

public class QuadraticEquation {
    private static boolean noExit = true;

    public static void main(String[] args) {

        do {
            System.out.println("\nВведите квадратное уравнение типа (примеры):");
            System.out.println("____________________________________________");
            System.out.println("| x^2 + 2x - 4 = 0     |  x^2 - 16 = 0     |");
            System.out.println("|----------------------|-------------------|");
            System.out.println("| -2x^2 - 3x + 0.1 = 0 |  4x^2 - 12x = -9  |");
            System.out.println("|----------------------|-------------------|");
            System.out.println("| -x^2 - 3x + 0.1 = 0  |  4x + 2x^2 = 16   |");
            System.out.println("--------------------------------------------");
            System.out.println("где ^ - указывает на степень. Важно соблюдать правильные отступы между элементами!");
            System.out.println("______________________________");
            System.out.println("Введите уравнение: ");

            Scanner scanner = new Scanner(System.in);
            String txt = scanner.nextLine().trim();

            if (checkString(txt)) result(txt);

        } while (noExit);

    }

    public static boolean checkString(String txt) {
        String[] sm = txt.split(" ");
        if (sm.length < 4) {
            System.out.println("Введите правильное уровнение...");
            return false;
        }
        return true;
    }

    public static void result(String v) {

        String[] sm = v.split(" ");
        String fElement = sm[0];
        String sElement = sm[2];

        if (sm[sm.length - 1].equals("0") & fElement.contains("^") & fElement.indexOf("x") == 0 & !sElement.contains("x")) {
            v1(sm);
        } else if (!sm[sm.length - 1].equals("0") & fElement.contains("x") & !fElement.contains("^") & sElement.contains("x") & sElement.contains("^")) {
            v2(sm);
        } else if (sm[sm.length - 1].equals("0") & fElement.contains("^") & !fElement.contains("-") & sElement.contains("x")) {
            v3(sm);
        } else if (!sm[sm.length - 1].equals("0") & fElement.contains("^") & sElement.contains("x")) {
            v4(sm);
        } else if (sm[sm.length - 1].equals("0") & fElement.contains("^") & fElement.contains("-") & sElement.contains("x")) {
            v5(sm);
        } else if (sm[sm.length - 1].equals("0") & fElement.contains("^") & fElement.indexOf("x") != 0 & !sElement.contains("x")) {
            v6(sm);
        } else {
            System.out.println("Введите правильное уравнение...");
        }
    }

    public static void v1(String[] mass) {
        double x1 = Math.sqrt(Double.parseDouble(mass[2]));
        double x2 = x1 * -1;
        System.out.println("Результат: ");
        System.out.println("x1 = " + x1 + "\n" + "x2 = " + x2);
        noExit = false;
    }

    public static void v2(String[] mass) {

        String firstElement = (mass[2].indexOf("x") == 0) ? "1" : mass[2].substring(0, mass[2].indexOf("x"));
        String secondElement = (mass[0].indexOf("x") == 0) ? "1" : mass[0].substring(0, mass[0].indexOf("x"));
        String thirdElement = mass[mass.length - 1];

        calculate(firstElement, secondElement, thirdElement);
    }

    private static void v3(String[] mass) {

        String firstElement = (mass[0].indexOf("x") == 0) ? "1" : mass[0].substring(0, mass[0].indexOf("x"));
        String secondElement;
        if (mass[1].equals("-")) {
            secondElement = "-" + ((mass[2].indexOf("x") == 0) ? "1" : mass[2].substring(0, mass[2].indexOf("x")));
        } else {
            secondElement = (mass[2].indexOf("x") == 0) ? "1" : mass[2].substring(0, mass[2].indexOf("x"));
        }

        String thirdElement = (mass[3].equals("-")) ? "-" + mass[4] : mass[4];

        calculate(firstElement, secondElement, thirdElement);
    }

    private static void v4(String[] mass) {

        String firstElement = (mass[0].indexOf("x") == 0) ? "1" : mass[0].substring(0, mass[0].indexOf("x"));
        String secondElement = (mass[2].indexOf("x") == 0) ? "1" : mass[2].substring(0, mass[2].indexOf("x"));
        if (mass[1].equals("-")) {
            secondElement = "-" + secondElement;
        }
        String thirdElement = (mass[4]);

        calculate(firstElement, secondElement, thirdElement);
    }

    private static void v5(String[] mass) {

        String firstElement = "";
        if (mass[0].startsWith("-") & mass[0].indexOf("x") == 1) {
            firstElement = "-1";
        } else if (mass[0].startsWith("-") & mass[0].indexOf("x") > 1) {
            firstElement = mass[0].substring(0, mass[0].indexOf("x"));
        }

        String secondElement = (mass[2].indexOf("x") == 0) ? "1" : mass[2].substring(0, mass[2].indexOf("x"));
        if (mass[1].equals("-")) {
            secondElement = "-" + secondElement;
        }

        String thirdElement = (mass[3].equals("-")) ? "-" + mass[4] : mass[4];

        calculate(firstElement, secondElement, thirdElement);
    }

    private static void v6(String[] mass) {

        String firstElement = mass[0].substring(0, mass[0].indexOf("x"));

        String secondElement = (mass[3].equals("-")) ? "-" + mass[4] : mass[4];

        String thirdElement;
        if (mass[1].startsWith("-")) {
            thirdElement = "-" + mass[2];
        } else {
            thirdElement = mass[2];
        }

        calculate(firstElement, secondElement, thirdElement);
    }

    public static void calculate(String sA, String sB, String sC) {

        double a = Double.parseDouble(sA);
        double b = Double.parseDouble(sB);
        double c = Double.parseDouble(sC);

        double discriminant = (b * b) - 4 * a * c;
        double v = (-b - Math.sqrt(discriminant)) / (2 * a);
        if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);

            System.out.println("Результат: ");
            System.out.println("x1 = " + x1 + "\n" + "x2 = " + v + "\n");
        }
        if (discriminant == 0) {
            System.out.println("Результат: ");
            System.out.println("x1 = " + v + "\n" + "x2 = " + v + "\n");
        }
        noExit = false;
    }
}
