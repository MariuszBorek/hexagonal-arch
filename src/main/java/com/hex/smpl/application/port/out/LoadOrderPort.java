package com.hex.smpl.application.port.out;

import com.hex.smpl.domain.model.Order;
import java.util.Optional;

public interface LoadOrderPort {
    Optional<Order> loadById(String id);
}
