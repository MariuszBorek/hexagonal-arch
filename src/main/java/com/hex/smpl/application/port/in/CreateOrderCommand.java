package com.hex.smpl.application.port.in;

import java.math.BigDecimal;

public record CreateOrderCommand(String id, BigDecimal amount) {}
