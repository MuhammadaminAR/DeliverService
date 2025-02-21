package org.example.deliveryservicebotpro.repos;

import org.example.deliveryservicebotpro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(nativeQuery =true,name = """
            select * from users where email=:email
            """)
    User findByEmail(String email);
}