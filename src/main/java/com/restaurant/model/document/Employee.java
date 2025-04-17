package com.restaurant.model.document;
import com.restaurant.model.Enum.RollEmployee;
import com.restaurant.model.interfaces.IEmployee;
import com.restaurant.model.vo.Permisions;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;


@AllArgsConstructor
@Document(collection = "employee")
@Builder
@NoArgsConstructor
@ToString
@Getter
@Setter
/*
 * The Employee class represents an employee in the restaurant.
 * It includes information about the employee's ID, DNI, name, schedule, charge, base salary, email, password, permissions, and role.
 */
public class Employee implements IEmployee {

    /**
     * The unique identifier for the employee.
     */
    private String id;

    /**
     * The DNI (Documento Nacional de Identidad) of the employee.
     */
    private String dni;

    /**
     * The name of the employee.
     */
    private String nameEmployee;

    /**
     * The schedule of the employee.
     */
    private String schedule;

    /**
     * The charge or position of the employee.
     */
    private String charge;

    /**
     * The base salary of the employee.
     */
    private double baseSalary;

    /**
     * The email of the employee.
     */
    private String email;

    /**
     * The password of the employee.
     */
    private String password;

    /**
     * The permissions associated with the employee.
     */
    private ArrayList<Permisions> permisions;

    /**
     * The role assigned to the employee.
     */
    private RollEmployee rollEmployee;
}
