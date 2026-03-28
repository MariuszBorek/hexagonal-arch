package com.hex.smpl.adapters.in.web;

import com.hex.smpl.domain.model.Order;
import java.math.BigDecimal;

public record OrderResponse(String id, BigDecimal amount) {

    public static OrderResponse from(Order order) {
        return new OrderResponse(order.getId(), order.getAmount());
    }
}
