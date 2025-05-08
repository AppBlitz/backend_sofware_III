package com.restaurant.repository;
import com.restaurant.dto.employee.EmployeeDTO;
import com.restaurant.model.document.Employee;
import com.restaurant.model.vo.Permissions;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    ArrayList<Employee> getAllByRetirementDateIsNullOrRetirementDateAfter(LocalDate retirementDateAfter);

    Employee getByUser_Email(@Email @NotBlank String userEmail);
    
    Employee getById(String id);
}
