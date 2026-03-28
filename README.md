# Arch schema


```
domain          → logika biznesowa
application     → przypadki użycia (use case)
adapters        → wejście/wyjście (API, DB)
infrastructure  → konfiguracja
```

```
src/
├── main/
│   ├── java/com/example/myapp/
│   │   │
│   │   ├── MyAppApplication.java
│   │   │
│   │   ├── domain/
│   │   │   └── model/
│   │   │       └── Order.java
│   │   │
│   │   ├── application/
│   │   │   ├── port/
│   │   │   │   ├── in/
│   │   │   │   │   ├── CreateOrderUseCase.java
│   │   │   │   │   ├── CreateOrderCommand.java
│   │   │   │   │   └── GetOrderUseCase.java
│   │   │   │   │
│   │   │   │   └── out/
│   │   │   │       ├── SaveOrderPort.java
│   │   │   │       └── LoadOrderPort.java
│   │   │   │
│   │   │   └── service/
│   │   │       ├── OrderService.java
│   │   │       └── OrderQueryService.java
│   │   │
│   │   ├── adapters/
│   │   │   ├── in/web/
│   │   │   │   ├── OrderController.java
│   │   │   │   └── OrderResponse.java
│   │   │   │
│   │   │   └── out/persistence/
│   │   │       ├── OrderEntity.java
│   │   │       ├── SpringDataOrderRepository.java
│   │   │       └── JpaOrderRepositoryAdapter.java
│   │   │
│   │   └── infrastructure/config/
│   │       └── BeanConfig.java
│   │
│   └── resources/
│       └── application.properties
```