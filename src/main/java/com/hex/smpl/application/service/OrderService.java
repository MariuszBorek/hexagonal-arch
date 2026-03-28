package com.hex.smpl.application.service;

import com.hex.smpl.application.port.in.CreateOrderCommand;
import com.hex.smpl.application.port.in.CreateOrderUseCase;
import com.hex.smpl.application.port.out.SaveOrderPort;
import com.hex.smpl.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService implements CreateOrderUseCase {

    private final SaveOrderPort saveOrderPort;

    @Override
    public void createOrder(CreateOrderCommand command) {
        Order order = new Order(command.id(), command.amount());
        saveOrderPort.save(order);
    }
}
