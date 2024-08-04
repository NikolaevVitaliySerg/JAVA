package ru.cft.study.j_2023_nikolaev.producing;

import java.util.ArrayDeque;
import java.util.logging.Logger;

public class Stock {
    private static final Logger log = Logger.getLogger(Stock.class.getName());
    private final Object SYNC = new Object();
    private final int storageSize;
    private final ArrayDeque<Product> arrayDeque = new ArrayDeque<>();

    public Stock(int storageSize) {
        this.storageSize = storageSize;
    }

    public void put(Product product) throws InterruptedException {
        log.info("start put");

        synchronized (SYNC) {
            log.info("Количество ресурсов на складе = " + String.valueOf(arrayDeque.size()));

            while (arrayDeque.size() >= this.storageSize) {
                log.info("Очередь переполнена");
                SYNC.wait();
            }

            arrayDeque.push(product);

            SYNC.notify();
        }
    }

    public Product pop() throws InterruptedException {
        log.info("start pop");

        synchronized (SYNC) {
            log.info("Зашли в SYNC");

            while (arrayDeque.size() == 0) {
                log.info("Количество продуктов = 0, ожидаем пополнение");
                SYNC.wait();
            }

            var task = arrayDeque.pop();

            SYNC.notify();

            return task;
        }
    }
}
