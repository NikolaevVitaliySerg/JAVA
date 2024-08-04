package ru.cft.study.j_2023_nikolaev.producing;

import java.util.UUID;

public class Product {
    private final UUID uuid;

    public Product(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getProductId() {
        return this.uuid;
    }
}