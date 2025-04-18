package com.restaurant.service.implementation.employees;

import com.restaurant.service.Interface.employees.IPayrollUpdateServices;
import org.springframework.stereotype.Service;

@Service
public class PayrollUpdateServices implements IPayrollUpdateServices {
    /**
     * Calculates the bonus based on a percentage of the salary.
     *
     * @param salary     the base salary
     * @param percentage the percentage to calculate the bonus
     * @return the calculated bonus
     */
    @Override
    public Double calculateBonusPercentage(Double salary, float percentage) {
        return salary*percentage;
    }

    /**
     * Calculates the overtime pay based on the number of hours and a percentage.
     *
     * @param hours      the number of overtime hours
     * @param percentage the percentage to calculate the overtime pay
     * @return the calculated overtime pay
     */
    @Override
    public Double calculateOvertimeHours(int hours, float percentage) {
        return Double.parseDouble(""+hours*percentage);
    }

    /**
     * Calculates the deduction based on a percentage of the salary.
     *
     * @param salary     the base salary
     * @param percentage the percentage to calculate the deduction
     * @return the calculated deduction
     */
    @Override
    public Double calculateDeductionPercentage(Double salary, float percentage) {
        return -salary*percentage;
    }

    /**
     * Deducts the salary for days without pay.
     *
     * @param salary the base salary
     * @param days   the number of days without pay
     * @return the deducted amount
     */
    @Override
    public Double deductDaysWithoutPay(Double salary, int days) {
        return -((salary/30)*days)-calculateTransportationAux(days);
    }

    /**
     * Calculates the vacation pay based on the salary and the number of days.
     *
     * @param salary the base salary
     * @param days   the number of vacation days
     * @return the calculated vacation pay
     */
    @Override
    public Double calculateVacationPay(Double salary, int days) {
        return null;
    }

    /**
     * Calculates the disability pay based on the salary and the number of days.
     *
     * @param salary the base salary
     * @param days   the number of disability days
     * @return the calculated disability pay
     */
    @Override
    public Double calculateDisabilityPay(Double salary, int days) {
        return null;
    }

    /**
     * Calculates the transportation allowance based on the number of days.
     *
     * @param days the number of days
     * @return the calculated transportation allowance
     */
    @Override
    public Double calculateTransportationAux(int days) {
        return AUX_TRANSPORTATION/30*days;
    }
}
