package com.hex.smpl.adapters.out.persistence;

import com.hex.smpl.application.port.out.LoadOrderPort;
import com.hex.smpl.application.port.out.SaveOrderPort;
import com.hex.smpl.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaOrderRepositoryAdapter implements SaveOrderPort, LoadOrderPort {

    private final SpringDataOrderRepository repository;

    @Override
    public void save(Order order) {
        repository.save(OrderEntity.from(order));
    }

    @Override
    public Optional<Order> loadById(String id) {
        return repository.findById(id)
                .map(OrderEntity::toDomain);
    }
}
