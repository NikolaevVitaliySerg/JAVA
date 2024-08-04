package ru.cft.study.j_2023_nikolaev.producing;

import java.util.logging.Logger;

public class Consumer {
    private static final Logger log = Logger.getLogger(Stock.class.getName());
    private final int id;
    private final int workingTime;

    public Consumer(int id, int workingTime) {
        this.id = id;
        this.workingTime = workingTime;
    }

    public void consume(Stock stock) throws InterruptedException {
        log.info("start consume " + "id = " + id);

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    var product = stock.pop();
                    log.info("Использовали продукт со склада с " + "id = " + product.getProductId());
                    Thread.sleep(this.workingTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread.start();
    }
}

