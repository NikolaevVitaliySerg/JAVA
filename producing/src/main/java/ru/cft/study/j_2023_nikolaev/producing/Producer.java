package ru.cft.study.j_2023_nikolaev.producing;

import java.util.UUID;
import java.util.logging.Logger;

public class Producer {
    private static final Logger log = Logger.getLogger(Stock.class.getName());
    private final int id;
    private final int workingTime;

    public Producer(int id, int workingTime) {
        this.id = id;
        this.workingTime = workingTime;
    }

    public void produce(Stock stock) {
        log.info("start produce " + "id = " + id);

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(this.workingTime);
                } catch (InterruptedException e) {
                    log.warning("Ошибка в процессе работы produce " + e.getMessage());
                    throw new RuntimeException(e);
                }

                Product product = new Product(UUID.randomUUID());

                try {
                    stock.put(product);
                } catch (InterruptedException e) {
                    log.warning("Ошибка при попытке добавить продукт в stock " + e.getMessage());
                    throw new RuntimeException(e);
                }

                log.info("Добавили продукт на склад с " + "id = " + product.getProductId());
            }
        });

        thread.start();
    }
}