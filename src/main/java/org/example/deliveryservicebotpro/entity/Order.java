package org.example.deliveryservicebotpro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.deliveryservicebotpro.enums.OrderStatus;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime orderDate;
    @ManyToOne
    private TelegramUser telegramUser;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
