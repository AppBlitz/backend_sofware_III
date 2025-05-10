package com.restaurant.model.document;
import com.restaurant.model.Enum.employees.RollManager;
import com.restaurant.model.interfaces.IEmployee;
import com.restaurant.model.vo.RollForManager;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    @Id
    @NotBlank
    @NotNull(message = "Wrapped employee cannot be null")
    private String wrappeID;

    /**
     * The role assigned to the manager.
     */
    @NotNull(message = "Role manager cannot be null")
    private RollForManager rollManager;

    /**
     * The salary increment for the manager.
     */
    @Min(value = 0, message = "Increment salary must be positive")
    private Double incrementSalary;
}
