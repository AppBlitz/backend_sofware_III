package com.restaurant.model.document;

import com.restaurant.enums.StateEnum;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data // Generates getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor // Generates a no-args constructor
@EqualsAndHashCode // Generates equals and hashCode methods based on all fields
@Builder // Allows for a builder pattern to create instances of this class
@Document("supplier") // Generate Collection with nameSupplier "supplier"

public class Supplier {

    @Id // Marks this field as the unique identifier in the document
    String id; // unique identifier of supplier

    @NonNull // marks that the field cannot be empty
    private String nameSupplier; // supplier´s name

    @NonNull // marks that the field cannot be empty
    private String location; // supplier´s location

    @NonNull // marks that the field cannot be empty
    private LocalDate orderDate; //

    @NonNull // marks that the field cannot be empty
    private List<String> offeredProducts; // list of products offered by the supplier

    @NonNull // marks that the field cannot be empty
    private StateEnum stateActivity; // status to indicate whether the provider is active or not
}
