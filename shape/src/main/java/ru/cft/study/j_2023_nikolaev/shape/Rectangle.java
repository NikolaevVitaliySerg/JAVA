package ru.cft.study.j_2023_nikolaev.shape;

import java.text.DecimalFormat;

public class Rectangle extends Shape {
    private double sideA;
    private double sideB;

    public Rectangle(double sideA, double sideB) throws DataException {
        super("RECTANGLE");
        if (sideA <= 0 || sideB <= 0) {
            throw new DataException("Стороны прямоугольника должны быть положительные");
        }

        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double getArea() {
        return sideA * sideB;
    }

    @Override
    public double getPerimeter() {
        return 2 * (sideA + sideB);
    }

    public double getDiagonalLength() {
        return Math.sqrt(sideA * sideA + sideB * sideB);
    }

    public double getLength() {
        return Math.max(sideA, sideB);
    }

    public double getWidth() {
        return Math.min(sideA, sideB);
    }

    @Override
    public String getCharacteristicsShape(DecimalFormat decimalFormat) {
        return super.getCharacteristicsShape(decimalFormat) +
                "Длина диагонали: " + decimalFormat.format(this.getDiagonalLength()) + " мм \n" +
                "Длина (размер длинной стороны): " + decimalFormat.format(this.getLength()) + " мм \n" +
                "Ширина (размер короткой стороны): " + decimalFormat.format(this.getWidth()) + " мм";
    }
}
