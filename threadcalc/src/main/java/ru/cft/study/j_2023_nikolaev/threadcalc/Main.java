package ru.cft.study.j_2023_nikolaev.threadcalc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            MainParams mainParams = parse(args);
            calculateConvergentSeries(mainParams);
        } catch (DataException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void calculateConvergentSeries(MainParams mainParams) {
        CompletableFuture[] futures = new CompletableFuture[mainParams.getNumberThreads()];
        Task[] tasks = new Task[mainParams.getNumberThreads()];
        int portionSize = mainParams.getNumberIterations() / futures.length;

        for (int i = 0; i < futures.length; i++) {
            int threadNumber = i;
            tasks[i] = new Task(threadNumber * portionSize, threadNumber * portionSize + portionSize);

            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> tasks[threadNumber].run());
            futures[i] = future;
        }

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures);

        try {
            allFutures.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException("Неожиданная ошибка при вызове allFutures.get()", e);
        }

        double result = 0;

        for (Task task : tasks) {
            result += task.getResult();
        }

        log.info("Итоговое значение = " + result);
    }

    private static MainParams parse(String[] args) throws DataException {
        int numberThreads;
        int numberIterations;

        try {
            numberThreads = Integer.parseInt(args[0]);
            numberIterations = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            throw new DataException("Входные параметры должны иметь числовой формат");
        }

        if (numberThreads < 1) {
            throw new DataException("Кол-во потоков не может быть меньше одного");
        }

        if (numberThreads > numberIterations) {
            throw new DataException("Кол-во итераций расчета не может быть меньше кол-во потоков: " + numberThreads);
        }

        return new MainParams(numberThreads, numberIterations);
    }
}