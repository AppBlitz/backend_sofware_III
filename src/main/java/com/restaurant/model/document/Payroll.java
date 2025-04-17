package com.restaurant.model.document;

import com.restaurant.model.vo.Pay;
import com.restaurant.model.vo.UpdateDetails;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * The Payroll class represents the payroll information.
 * It includes information about the payment, update details, date of generation, and the month.
 */
@AllArgsConstructor
@Document(collection = "payroll")
@Builder
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Payroll {

    /**
     * The payment information.
     */
    private Pay pay;

    /**
     * The update details.
     */
    private UpdateDetails updateDetails;

    /**
     * The date when the payroll was generated.
     */
    private LocalDate dateGenerate;

    /**
     * The month of the payroll.
     */
    private String month;
}

