package com.crudexampleproject.springbootcrudexample.repository.security;

import com.crudexampleproject.springbootcrudexample.domain.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}