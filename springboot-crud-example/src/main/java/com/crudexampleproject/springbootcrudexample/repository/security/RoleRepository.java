package com.crudexampleproject.springbootcrudexample.repository.security;

import com.crudexampleproject.springbootcrudexample.domain.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String customer);
}