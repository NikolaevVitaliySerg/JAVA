package ru.cft.study.j_2023_nikolaev.producing;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        try {
            runMultiThreadedProduction();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void runMultiThreadedProduction() throws InterruptedException {
        var prop = loadProperties("config.properties");

        var producerCount = Integer.parseInt(prop.getProperty("producerCount"));
        var consumerCount = Integer.parseInt(prop.getProperty("consumerCount"));
        var producerTime = Integer.parseInt(prop.getProperty("producerTime"));
        var consumerTime = Integer.parseInt(prop.getProperty("consumerTime"));
        var storageSize = Integer.parseInt(prop.getProperty("storageSize"));

        ArrayList<Producer> producers = new ArrayList<>();
        ArrayList<Consumer> consumers = new ArrayList<>();
        Stock stock = new Stock(storageSize);

        for (int i = 0; i < producerCount; i++) {
            producers.add(new Producer(i + 1, producerTime));
        }

        for (int i = 0; i < consumerCount; i++) {
            consumers.add(new Consumer(i + 1, consumerTime));
        }

        producers.forEach(producer -> producer.produce(stock));
        consumers.forEach(consumer -> {
            try {
                consumer.consume(stock);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

    }

    private static Properties loadProperties(String propertiesFilename) {
        Properties prop = new Properties();

        ClassLoader loader = Main.class.getClassLoader();

        try (InputStream stream = loader.getResourceAsStream(propertiesFilename)) {
            prop.load(stream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return prop;
    }
}

