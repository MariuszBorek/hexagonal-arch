package com.hex.smpl.application.port.out;

import com.hex.smpl.domain.model.Order;

public interface SaveOrderPort {
    void save(Order order);
}
