package com.crudexampleproject.springbootcrudexample.bootstrap;

import com.crudexampleproject.springbootcrudexample.domain.security.Authority;
import com.crudexampleproject.springbootcrudexample.domain.security.Role;
import com.crudexampleproject.springbootcrudexample.domain.security.User;
import com.crudexampleproject.springbootcrudexample.repository.security.AuthorityRepository;
import com.crudexampleproject.springbootcrudexample.repository.security.RoleRepository;
import com.crudexampleproject.springbootcrudexample.repository.security.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Component
public class UserDataLoader implements CommandLineRunner {

    private final AuthorityRepository authorityRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private void loadSecurityData() {
        /*
        Authority createBeer = authorityRepository.save(Authority.builder().permission("beer.create").build());
        Authority readBeer = authorityRepository.save(Authority.builder().permission("beer.read").build());
        Authority updateBeer = authorityRepository.save(Authority.builder().permission("beer.update").build());
        Authority deleteBeer = authorityRepository.save(Authority.builder().permission("beer.delete").build());
         */

        Authority readEmployees = authorityRepository.save(Authority.builder().permission("empoyee.read").build());

        Role adminRole = roleRepository.save(Role.builder().name("ROLE_ADMIN").build());
        Role guestRole = roleRepository.save(Role.builder().name("ROLE_GUEST").build());
        Role userRole = roleRepository.save(Role.builder().name("ROLE_USER").build());

        adminRole.setAuthorities(new HashSet<>(Set.of(readEmployees)));

        /*
        customerRole.setAuthorities(new HashSet<>(Set.of(readBeer, readCustomer, readBrewery, createOrderCustomer, readOrderCustomer,
                updateOrderCustomer, deleteOrderCustomer, pickUpOrderCustomer)));
        userRole.setAuthorities(new HashSet<>(Set.of(readBeer)));
         */

        roleRepository.saveAll(Arrays.asList(adminRole, guestRole, userRole));

        userRepository.save(User.builder()
                .username("spring")
                .password(passwordEncoder.encode("guru"))
                .role(adminRole)
                .build());

        userRepository.save(User.builder()
                .username("user")
                .password(passwordEncoder.encode("password"))
                .role(userRole)
                .build());

        userRepository.save(User.builder()
                .username("scott")
                .password(passwordEncoder.encode("tiger"))
                .role(guestRole)
                .build());

        //log.debug("Users Loaded: " + userRepository.count());
    }

    @Override
    public void run(String... args) throws Exception {
        if(authorityRepository.count() == 0){
            loadSecurityData();
        }
    }
}
