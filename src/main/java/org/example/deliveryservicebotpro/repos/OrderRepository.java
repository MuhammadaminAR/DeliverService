package org.example.deliveryservicebotpro.repos;

import org.example.deliveryservicebotpro.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}