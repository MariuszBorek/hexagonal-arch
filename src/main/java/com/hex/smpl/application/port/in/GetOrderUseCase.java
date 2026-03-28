package com.hex.smpl.application.port.in;

import com.hex.smpl.domain.model.Order;

public interface GetOrderUseCase {
    Order getOrder(String id);
}
