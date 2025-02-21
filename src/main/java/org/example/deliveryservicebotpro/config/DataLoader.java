package org.example.deliveryservicebotpro.config;

import org.example.deliveryservicebotpro.entity.Role;
import org.example.deliveryservicebotpro.entity.User;
import org.example.deliveryservicebotpro.enums.RoleName;
import org.example.deliveryservicebotpro.repos.RoleRepository;
import org.example.deliveryservicebotpro.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class DataLoader implements CommandLineRunner {
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public DataLoader(RoleRepository roleRepository, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Role role1 =Role.builder()
                .roleName(RoleName.ROLE_ADMIN)
                .build();
        Role role2 =Role.builder()
                .roleName(RoleName.ROLE_USER)
                .build();
        Role role3 =Role.builder()
                .roleName(RoleName.ROLE_OPERATOR)
                .build();
        Role role4 =Role.builder()
                .roleName(RoleName.ROLE_SUPER_ADMIN)
                .build();


        List<Role> allRoles = roleRepository.saveAll(new ArrayList<>(List.of(role1, role2, role3, role4)));
        User user1 = User.builder()
                .roles(new ArrayList<>(List.of(allRoles.get(3))))
                .email("superadmin@123gmail.com")
                .password(passwordEncoder.encode("root123"))
                .build();
        userRepository.save(user1);
    }
}
