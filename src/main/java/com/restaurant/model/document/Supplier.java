package com.restaurant.model.document;
import com.restaurant.enums.StateEnum;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Document("supplier")
@Builder
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Supplier {

    @Id
    String id;

    @NonNull
    private String name;

    @NonNull
    private String location;

    @NonNull
    private LocalDate orderDate;

    @NonNull
    private List<Product> offeredProducts;

    @NonNull
    private StateEnum stateAtivity;
}
