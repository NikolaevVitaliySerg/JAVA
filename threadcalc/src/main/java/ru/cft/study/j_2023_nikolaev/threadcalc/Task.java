package ru.cft.study.j_2023_nikolaev.threadcalc;

import java.util.logging.Logger;

public class Task {
    private static final Logger log = Logger.getLogger(Task.class.getName());
    private final int startInclusive;
    private final int endExclusive;
    private double result;

    public Task(int startInclusive, int endExclusive) {
        this.startInclusive = startInclusive;
        this.endExclusive = endExclusive;
    }

    public void run() {
        double summParam = 0;

        for (int i = this.startInclusive; i < this.endExclusive; i++) {
            summParam += 1 / Math.pow(2, i);
        }

        this.result = summParam;

        log.info("Вызван Task. Стартовое значение = " + startInclusive + " Конечное значение = " + endExclusive + " Результат = " + result);
    }

    public double getResult() {
        return this.result;
    }
}