package ru.cft.study.j_2023_nikolaev.shape;

import java.text.DecimalFormat;

public abstract class Shape {

    private final String name;

    public Shape(String name) {
        this.name = name;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public String getName() {
        return name;
    }

    public String getCharacteristicsShape(DecimalFormat decimalFormat) {
        return "Тип фигуры: " + this.getName() + "\n" +
                "Площадь: " + decimalFormat.format(this.getArea()) + " кв. мм \n" +
                "Периметр: " + decimalFormat.format(this.getPerimeter()) + " кв. мм \n";
    }
}