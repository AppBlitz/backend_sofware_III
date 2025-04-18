package com.restaurant.model.document;

import com.restaurant.model.Enum.employees.RollManager;
import com.restaurant.model.interfaces.IEmployee;
import com.restaurant.model.vo.Permisions;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@AllArgsConstructor
@Document(collection = "manager")
@Builder
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Manager implements IEmployee {

    /**
     * The wrapped IEmployee instance.
     */
    private Employee wrappe;

    /**
     * The permissions associated with the manager.
     */
    private ArrayList<Permisions> permisions;

    /**
     * The role assigned to the manager.
     */
    private RollManager rollManager;
}