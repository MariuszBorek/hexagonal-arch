package com.hex.smpl.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Order {

    private final String id;
    private final BigDecimal amount;

    public Order(String id, BigDecimal amount) {
        this.id = id == null ? UUID.randomUUID().toString() : id;
        this.amount = amount;
    }

    public String getId() { return id; }
    public BigDecimal getAmount() { return amount; }
}
