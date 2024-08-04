package ru.cft.study.j_2023_nikolaev.shape;

import java.text.DecimalFormat;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) throws DataException {
        super("CIRCLE");
        if (radius <= 0) {
            throw new DataException("Радиус круга не может быть отрицательным или равен нулю");
        }
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getDiameter() {
        return radius * 2;
    }

    @Override
    public String getCharacteristicsShape(DecimalFormat decimalFormat) {
        return super.getCharacteristicsShape(decimalFormat) +
                "Радиус: " + decimalFormat.format(this.getRadius()) + " мм \n" +
                "Диаметр: " + decimalFormat.format(this.getDiameter()) + " мм";
    }
}
