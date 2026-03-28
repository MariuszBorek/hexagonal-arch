package com.hex.smpl.adapters.in.web;

import com.hex.smpl.application.port.in.CreateOrderCommand;
import com.hex.smpl.application.port.in.CreateOrderUseCase;
import com.hex.smpl.application.port.in.GetOrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final CreateOrderUseCase createUseCase;
    private final GetOrderUseCase getUseCase;

    @PostMapping
    public void create(@RequestBody CreateOrderRequest request) {
        createUseCase.createOrder(
                new CreateOrderCommand(request.id(), request.amount())
        );
    }

    @GetMapping("/{id}")
    public OrderResponse get(@PathVariable String id) {
        return OrderResponse.from(getUseCase.getOrder(id));
    }

    public record CreateOrderRequest(String id, BigDecimal amount) {}
}
