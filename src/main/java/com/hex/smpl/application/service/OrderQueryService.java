package com.hex.smpl.application.service;

import com.hex.smpl.application.port.in.GetOrderUseCase;
import com.hex.smpl.application.port.out.LoadOrderPort;
import com.hex.smpl.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderQueryService implements GetOrderUseCase {

    private final LoadOrderPort loadOrderPort;

    @Override
    public Order getOrder(String id) {
        return loadOrderPort.loadById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
