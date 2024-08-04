package ru.cft.study.j_2023_nikolaev.shape;

import java.io.File;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try {
            MainParams mainParams = parse(args);
            FileLinesReader shapeData = new FileLinesReader();
            String[] shapeDataFromFile = shapeData.getShapeDataFromFile(mainParams.getInputFilePath());
            Shape shapes = ShapeFactory.createShape(shapeDataFromFile);
            ShapeWriter.writeShape(shapes, mainParams.getOutputFileName(), mainParams.getOutputType());
        } catch (DataException e) {
            System.out.println(e.getMessage());
        }
    }

    private static MainParams parse(String[] args) throws DataException {
        if (args.length != 3 && args[1].equals("FILE")) {
            throw new DataException("Для вывода данных в файл входных аргумента должно быть 3");
        } else if (args.length != 2 && args[1].equals("CONSOLE")) {
            throw new DataException("Для вывода данных в консоль входных аргумента должно быть 2");
        }

        File file = new File(args[0]);

        if (!file.exists()) {
            throw new DataException("Входного файла не существует по заданному пути");
        }

        OutputType outputType;

        try {
            outputType = OutputType.valueOf(args[1]);
        } catch (IllegalArgumentException e) {
            String enumNames = Stream.of(OutputType.values())
                    .map(OutputType::name)
                    .collect(Collectors.joining(", "));
            throw new DataException("Второй параметр должен быть один из: " + enumNames);
        }

        return new MainParams(args[0], args[1], outputType);
    }
}