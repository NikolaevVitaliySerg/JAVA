package ru.cft.study.j_2023_nikolaev.shape;

import java.text.DecimalFormat;

public class Triangle extends Shape {
    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(double sideA, double sideB, double sideC) throws DataException {
        super("TRIANGLE");

        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new DataException("Стороны треугольника должны быть положительные");
        }

        checkTriangleRule(sideA, sideB, sideC);

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    @Override
    public double getArea() {
        double semiPerimeter = getPerimeter() / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC));
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    private double getOppositeAngleA() {
        return calculateOppositeAngle(sideA, sideB, sideC);
    }

    private double getOppositeAngleB() {
        return calculateOppositeAngle(sideB, sideA, sideC);
    }

    private double getOppositeAngleC() {
        return calculateOppositeAngle(sideC, sideA, sideB);
    }

    private double calculateOppositeAngle(double a, double b, double c) {
        double radian = Math.acos((b * b + c * c - a * a) / (2 * b * c));
        return Math.toDegrees(radian);
    }

    @Override
    public String getCharacteristicsShape(DecimalFormat decimalFormat) {
        return super.getCharacteristicsShape(decimalFormat) +
                "Длина первой стороны: " + this.getSideA() + " мм " + "Противолежащий угол: " +
                decimalFormat.format(this.getOppositeAngleA()) + " градусов \n" +
                "Длина второй стороны: " + this.getSideB() + " мм " + "Противолежащий угол: " +
                decimalFormat.format(this.getOppositeAngleB()) + " градусов \n" +
                "Длина третьей стороны: " + this.getSideC() + " мм " + "Противолежащий угол: " +
                decimalFormat.format(this.getOppositeAngleC()) + " градусов";
    }

    private void checkTriangleRule(double sideA, double sideB, double sideC) throws DataException {
        if (sideA > sideB + sideC || sideB > sideA + sideC || sideC > sideA + sideB) {
            throw new DataException("Одна сторона треугольника больше двух других сторон");
        }
    }
}
