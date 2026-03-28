# Arch schema


```
domain/          → logika biznesowa
application/     → przypadki użycia (use case)
└── port/
    ├── in/
    └── out/
adapters/        → wejście/wyjście (API, DB)
infrastructure/  → konfiguracja
```

>port = granica systemu - mówi CO system potrafi, ale nie mówi JAK

---

```
Controller (adapter IN)
    ↓
UseCase / port IN (interface)
    ↓
Service (implementacja use case)
    ↓
Port OUT (interface)
    ↓
Adapter OUT (implementacja)
    ↓
DB
```

```
                ┌───────────────────────────────┐
                │        HTTP REQUEST           │
                │   GET /orders/{id}            │
                └──────────────┬────────────────┘
                               │
                               ▼
                ┌───────────────────────────────┐
                │   OrderController             │
                │ (adapter IN - REST)           │
                └──────────────┬────────────────┘
                               │
                               ▼
                ┌───────────────────────────────┐
                │   GetOrderUseCase             │
                │ (port IN - interface)         │
                └──────────────┬────────────────┘
                               │
                               ▼
                ┌───────────────────────────────┐
                │   OrderQueryService           │
                │ (application / use case)      │
                └──────────────┬────────────────┘
                               │
                               ▼
                ┌───────────────────────────────┐
                │   LoadOrderPort               │
                │ (port OUT - interface)        │
                └──────────────┬────────────────┘
                               │
                               ▼
                ┌───────────────────────────────┐
                │ JpaOrderRepositoryAdapter     │
                │ (adapter OUT - persistence)   │
                └──────────────┬────────────────┘
                               │
                               ▼
                ┌───────────────────────────────┐
                │ SpringDataOrderRepository     │
                └──────────────┬────────────────┘
                               │
                               ▼
                ┌───────────────────────────────┐
                │            DATABASE           │
                │        (H2 / PostgreSQL)      │
                └──────────────┬────────────────┘


====================== RESPONSE FLOW ======================


                               ▲
                               │
                ┌───────────────────────────────┐
                │        OrderEntity            │
                │ (dane z DB)                   │
                └──────────────┬────────────────┘
                               │  map()
                               ▼
                ┌───────────────────────────────┐
                │            Order              │
                │ (DOMAIN MODEL)                │
                └──────────────┬────────────────┘
                               │
                               ▼
                ┌───────────────────────────────┐
                │   OrderQueryService           │
                └──────────────┬────────────────┘
                               │
                               ▼
                ┌───────────────────────────────┐
                │   OrderController             │
                └──────────────┬────────────────┘
                               │  map()
                               ▼
                ┌───────────────────────────────┐
                │        OrderResponse          │
                │ (DTO → JSON)                  │
                └──────────────┬────────────────┘
                               │
                               ▼
                ┌───────────────────────────────┐
                │        HTTP RESPONSE          │
                │   200 OK + JSON               │
                └───────────────────────────────┘
```

---

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