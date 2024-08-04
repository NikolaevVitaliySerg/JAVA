package ru.cft.study.j_2023_nikolaev.shape;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class ShapeWriter {
    public static void writeShape(Shape shapes, String outputFileName, OutputType dataOutputOption) throws DataException {
        File file = new File(outputFileName);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        switch (dataOutputOption) {
            case CONSOLE:
                System.out.println(shapes.getCharacteristicsShape(decimalFormat));
                break;
            case FILE:
                try (PrintWriter printWriter = new PrintWriter(file)) {
                    printWriter.println(shapes.getCharacteristicsShape(decimalFormat));
                } catch (FileNotFoundException e) {
                    throw new DataException("Не найдена директория для записи файла по пути " + file.getPath());
                }
                break;
        }
    }
}
