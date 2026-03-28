package com.hex.smpl.adapters.out.persistence;

import com.hex.smpl.domain.model.Order;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;

@Entity
public class OrderEntity {

    @Id
    private String id;
    private BigDecimal amount;

    public static OrderEntity from(Order order) {
        OrderEntity entity = new OrderEntity();
        entity.id = order.getId();
        entity.amount = order.getAmount();
        return entity;
    }

    public Order toDomain() {
        return new Order(id, amount);
    }
}
