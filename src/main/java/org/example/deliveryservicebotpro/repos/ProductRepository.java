package org.example.deliveryservicebotpro.repos;

import org.example.deliveryservicebotpro.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}