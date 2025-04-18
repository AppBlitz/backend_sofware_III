package com.restaurant.repository;

import com.restaurant.model.Enum.State;
import com.restaurant.model.document.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    ArrayList<Employee> getAllByState(State state);
}
