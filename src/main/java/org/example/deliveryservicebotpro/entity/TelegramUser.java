package org.example.deliveryservicebotpro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TelegramUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String fullName;
    private String phone;
    private Long chatId;
    @OneToMany
    private List<Location> locations;
}
