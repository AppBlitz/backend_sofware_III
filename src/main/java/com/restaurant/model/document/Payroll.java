package com.restaurant.model.document;

import com.restaurant.model.vo.Pay;
import com.restaurant.model.vo.UpdateDetails;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The Payroll class represents the payroll information.
 * It includes information about the payment, update details, date of
 * generation, and the month.
 */
@AllArgsConstructor
@Document(collection = "payroll")
@Builder
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Payroll {
    @Id
    private String id;

    /**
     * The payment information.
     */
    private Pay pay;

    /**
     * The update details.
     */
    private ArrayList<UpdateDetails> updateDetails;

    /**
     * The date when the payroll was generated.
     */
    private LocalDate dateGenerate;

    /**
     * The month of the payroll.
     */
    private Month month;

    public enum Month {
        ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE, DICIEMBRE
    }

    /**
     * The year of the payroll.
     */
    private int year;
}
