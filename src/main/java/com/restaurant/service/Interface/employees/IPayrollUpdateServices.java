package com.restaurant.service.Interface.employees;

/**
 * This interface performs the necessary calculations to adjust the payroll according to the registered novelty.
 */
public interface IPayrollUpdateServices {

    /**
     * Calculates the bonus based on a percentage of the salary.
     *
     * @param salary the base salary
     * @param percentage the percentage to calculate the bonus
     * @return the calculated bonus
     */
    Double calculateBonusPercentage(Double salary, float percentage);

    /**
     * Calculates the overtime pay based on the number of hours and a percentage.
     *
     * @param hours the number of overtime hours
     * @param percentage the percentage to calculate the overtime pay
     * @return the calculated overtime pay
     */
    Double calculateOvertimeHours(int hours, float percentage);

    /**
     * Calculates the deduction based on a percentage of the salary.
     *
     * @param salary the base salary
     * @param percentage the percentage to calculate the deduction
     * @return the calculated deduction
     */
    Double calculateDeductionPercentage(Double salary, float percentage);

    /**
     * Deducts the salary for days without pay.
     *
     * @param salary the base salary
     * @param days the number of days without pay
     * @return the deducted amount
     */
    Double deductDaysWithoutPay(Double salary, int days);

    /**
     * Calculates the vacation pay based on the salary and the number of days.
     *
     * @param salary the base salary
     * @param days the number of vacation days
     * @return the calculated vacation pay
     */
    Double calculateVacationPay(Double salary, int days);

    /**
     * Calculates the disability pay based on the salary and the number of days.
     *
     * @param salary the base salary
     * @param days the number of disability days
     * @return the calculated disability pay
     */
    Double calculateDisabilityPay(Double salary, int days);

    /**
     * Calculates the transportation allowance based on the number of days.
     *
     * @param days the number of days
     * @return the calculated transportation allowance
     */
    Double calculateTransportationAux(int days);

    /**
     * The fixed transportation allowance.
     */
    Double AUX_TRANSPORTATION = 200000.0;

    /**
     * The minimum salary.
     */
    Double SALARY_MINIMUM = 1423500.0;
}

