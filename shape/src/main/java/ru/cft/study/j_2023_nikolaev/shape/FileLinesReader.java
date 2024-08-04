package ru.cft.study.j_2023_nikolaev.shape;

import java.io.*;

public class FileLinesReader {

    public String[] getShapeDataFromFile(String filePath) throws DataException {
        String[] shapeData = new String[2];
        File file = new File(filePath);
        int countNullElements = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            shapeData[0] = bufferedReader.readLine();
            shapeData[1] = bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            throw new DataException("Файл для считывания параметров фигур по пути " + filePath + " не найден");
        } catch (IOException e) {
            throw new DataException("Возникла проблема со считыванием данных с входного файла");
        }


        for (String shapeDateNum : shapeData) {
            if (shapeDateNum == null) {
                countNullElements = countNullElements + 1;
            }
        }

        if (countNullElements == shapeData.length) {
            throw new DataException("Массив данных фигуры пустой! Проверьте содержимое входного файла");
        }

        return shapeData;
    }
}
