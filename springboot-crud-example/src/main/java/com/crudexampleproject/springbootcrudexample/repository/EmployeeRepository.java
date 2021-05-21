package com.crudexampleproject.springbootcrudexample.repository;

import com.crudexampleproject.springbootcrudexample.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

