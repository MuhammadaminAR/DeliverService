package org.example.deliveryservicebotpro.repos;

import org.example.deliveryservicebotpro.entity.TelegramUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelegramUserRepository extends JpaRepository<TelegramUser, Integer> {
}