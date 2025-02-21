package org.example.deliveryservicebotpro.repos;

import org.example.deliveryservicebotpro.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}