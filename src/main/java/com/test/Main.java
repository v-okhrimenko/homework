package com.test;

import java.util.Scanner;

public class Main {
    private static boolean digitIsNotOk = true;
    private static final String[][] pseudoDigit = new String[10][6];

    static {
        pseudoDigit[0][0] = "@@@@@@";
        pseudoDigit[0][1] = "@    @";
        pseudoDigit[0][2] = "@    @";
        pseudoDigit[0][3] = "@    @";
        pseudoDigit[0][4] = "@    @";
        pseudoDigit[0][5] = "@@@@@@";

        pseudoDigit[1][0] = "  @@  ";
        pseudoDigit[1][1] = " @@@  ";
        pseudoDigit[1][2] = "@ @@  ";
        pseudoDigit[1][3] = "  @@  ";
        pseudoDigit[1][4] = "  @@  ";
        pseudoDigit[1][5] = "@@@@@@";

        pseudoDigit[2][0] = "@@@@@@";
        pseudoDigit[2][1] = "    @@";
        pseudoDigit[2][2] = "    @@";
        pseudoDigit[2][3] = "  @@  ";
        pseudoDigit[2][4] = "@@    ";
        pseudoDigit[2][5] = "@@@@@@";

        pseudoDigit[3][0] = "@@@@@@";
        pseudoDigit[3][1] = "    @@";
        pseudoDigit[3][2] = "  @@  ";
        pseudoDigit[3][3] = "@@@@@@";
        pseudoDigit[3][4] = "    @@";
        pseudoDigit[3][5] = "@@@@@@";

        pseudoDigit[4][0] = "@@  @@";
        pseudoDigit[4][1] = "@@  @@";
        pseudoDigit[4][2] = "@@@@@@";
        pseudoDigit[4][3] = "    @@";
        pseudoDigit[4][4] = "    @@";
        pseudoDigit[4][5] = "    @@";

        pseudoDigit[5][0] = "@@@@@@";
        pseudoDigit[5][1] = "@@    ";
        pseudoDigit[5][2] = "@@@@@@";
        pseudoDigit[5][3] = "    @@";
        pseudoDigit[5][4] = "    @@";
        pseudoDigit[5][5] = "@@@@@@";

        pseudoDigit[6][0] = "@@@@@@";
        pseudoDigit[6][1] = "@     ";
        pseudoDigit[6][2] = "@     ";
        pseudoDigit[6][3] = "@@@@@@";
        pseudoDigit[6][4] = "@    @";
        pseudoDigit[6][5] = "@@@@@@";

        pseudoDigit[7][0] = "@@@@@@";
        pseudoDigit[7][1] = "    @@";
        pseudoDigit[7][2] = "    @@";
        pseudoDigit[7][3] = "  @@  ";
        pseudoDigit[7][4] = " @@   ";
        pseudoDigit[7][5] = "@@    ";

        pseudoDigit[8][0] = "@@@@@@";
        pseudoDigit[8][1] = "@    @";
        pseudoDigit[8][2] = "@    @";
        pseudoDigit[8][3] = "@@@@@@";
        pseudoDigit[8][4] = "@    @";
        pseudoDigit[8][5] = "@@@@@@";

        pseudoDigit[9][0] = "@@@@@@";
        pseudoDigit[9][1] = "@    @";
        pseudoDigit[9][2] = "@@@@@@";
        pseudoDigit[9][3] = "    @@";
        pseudoDigit[9][4] = "    @@";
        pseudoDigit[9][5] = "@@@@@@";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введите чило: ");
            String digitString = scanner.nextLine().trim();
            if (checkDigit(digitString)) {
                printDigits(digitString);
            }
        }
        while (digitIsNotOk);
    }

    private static void printDigits(String digitString) {
        String[] strArr = digitString.split("");
        int index = 0;
        String[][] digit = new String[strArr.length][];
        for (String c : strArr) {
            digit[index++] = pseudoDigit[Integer.parseInt(c)];
        }

        for (int i = 0; i < digit[0].length; i++) {
            for (String[] strings : digit) {
                System.out.print(strings[i] + "   ");
            }
            System.out.println();
        }
        digitIsNotOk = false;
    }

    private static boolean checkDigit(String digitString) {
        try {
            Integer.valueOf(digitString);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели не число!");
            return false;
        }
    }
}