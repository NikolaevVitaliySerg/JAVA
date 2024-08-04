package ru.cft.study.j_2023_nikolaev.threadcalc;

public class MainParams {
    private int numberThreads;
    private int numberIterations;

    public MainParams(int numberThreads, int numberIterations) {
        this.numberThreads = numberThreads;
        this.numberIterations = numberIterations;
    }

    public int getNumberThreads() {
        return this.numberThreads;
    }

    public int getNumberIterations() {
        return this.numberIterations;
    }
}