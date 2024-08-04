package ru.cft.sstudy.j_2023_nikolaev.multytable;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int tableSize;

        try {
            tableSize = readTableSizeFromConsole();
        } catch (InputMismatchException exception) {
            System.out.println("Ожидалось числовое значение, попробуйте снова");
            return;
        }

        if (tableSize < 1) {
            System.out.println("Размер таблицы должен быть больше 0");
            return;
        }

        printMultiTable(tableSize);
    }

    private static int readTableSizeFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите размер таблицы умножения: ");

        return scanner.nextInt();
    }

    private static void printLineSeparator(int tableSize, String firstColumnLength, String contentColumnLength) {
        StringBuilder countDash = new StringBuilder(Math.max(firstColumnLength.length(), contentColumnLength.length()) + 1);

        for (int cellIndex = 1; cellIndex <= firstColumnLength.length(); cellIndex++) {
            countDash.append("-");
        }

        System.out.print(countDash);

        countDash.delete(0, countDash.length());

        countDash.append("+");

        for (int cellIndex = 1; cellIndex <= contentColumnLength.length(); cellIndex++) {
            countDash.append("-");
        }

        for (int cellIndex = 1; cellIndex <= tableSize; cellIndex++) {
            System.out.print(countDash);
        }

        System.out.println();
    }

    private static void printMultiTable(int tableSize) {
        String firstColumnLength = String.valueOf(tableSize);
        String contentColumnLength = String.valueOf(tableSize * tableSize);

        System.out.print(" ".repeat(firstColumnLength.length()));

        String firstCellFormat = "|" + "%" + contentColumnLength.length() + "d";

        for (int cellIndex = 1; cellIndex <= tableSize; cellIndex++) {
            System.out.printf(firstCellFormat, cellIndex);
        }

        System.out.println();

        printLineSeparator(tableSize, firstColumnLength, contentColumnLength);

        String firstColumnCellFormat = "%" + firstColumnLength.length() + "d";
        String contentCellFormat = "|" + "%" + contentColumnLength.length() + "d";

        for (int rowIndex = 1; rowIndex <= tableSize; rowIndex++) {
            System.out.printf(firstColumnCellFormat, rowIndex);

            for (int columnIndex = 1; columnIndex <= tableSize; columnIndex++) {
                System.out.printf(contentCellFormat, rowIndex * columnIndex);
            }

            System.out.println();

            printLineSeparator(tableSize, firstColumnLength, contentColumnLength);
        }
    }
}
