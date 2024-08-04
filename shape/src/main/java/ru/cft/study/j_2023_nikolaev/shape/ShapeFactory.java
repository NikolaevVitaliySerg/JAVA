package ru.cft.study.j_2023_nikolaev.shape;

import java.util.NoSuchElementException;

public class ShapeFactory {

    public static Shape createShape(String[] shapeParams) throws DataException, NoSuchElementException {
        String shapeType = shapeParams[0];
        Shape shape;
        String[] paramsString;

        if (shapeParams[1] == null) {
            throw new DataException("Параметры входного файла должны быть заполнены! Проверьте его содержимое");
        }

        paramsString = shapeParams[1].split(" ");

        switch (shapeType) {
            case ("CIRCLE"):
                if (paramsString.length != 1) {
                    throw new DataException("Для круга должен быть заполнен один параметр");
                }

                shape = new Circle(Double.parseDouble(paramsString[0]));
                break;
            case ("RECTANGLE"):
                if (paramsString.length != 2) {
                    throw new DataException("Для прямоугольника должно быть заполнено два параметра");
                }

                shape = new Rectangle(Double.parseDouble(paramsString[0]), Double.parseDouble(paramsString[1]));
                break;
            case ("TRIANGLE"):
                if (paramsString.length != 3) {
                    throw new DataException("Для треугольника должно быть заполнено три параметра");
                }

                shape = new Triangle(Double.parseDouble(paramsString[0]), Double.parseDouble(paramsString[1]), Double.parseDouble(paramsString[2]));
                break;
            default:
                throw new DataException("Не удалось определить код фигуры из входящего файла");
        }

        return shape;
    }
}

