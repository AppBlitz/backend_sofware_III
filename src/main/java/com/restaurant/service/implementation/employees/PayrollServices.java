package com.restaurant.service.implementation.employees;

import com.restaurant.model.Enum.UpdateType;
import com.restaurant.model.document.Employee;
import com.restaurant.model.document.Payroll;
import com.restaurant.model.vo.Pay;
import com.restaurant.model.vo.Update;
import com.restaurant.model.vo.UpdateDetails;
import com.restaurant.repository.EmployeeRepository;
import com.restaurant.repository.PayrollRepository;
import com.restaurant.service.Interface.employees.IPayrollServices;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class PayrollServices implements IPayrollServices {
    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PayrollUpdateServices payrollUpdateServices;

    /**
     * @return
     */
    @Override
    public Payroll pagar(@NotNull Payroll payroll) {
        Pay pay = new Pay();
        pay.setDate(LocalDate.now());
        pay.setAmount(calculateTotal(payroll));
        payroll.setPay(pay);
        return payrollRepository.save(payroll);
    }

    @Override
    public Double calculateTotal(@NotNull Payroll payroll) {
        double total = 0.0;
        for (UpdateDetails details :payroll.getUpdateDetails()){
            total+=details.getEmployee().getBaseSalary();
            for(Update update : details.getUpdates()){
                total+= update.getAmount();
            }
        }
            return total;
    }

    /**
     * @return
     */
    @Override
    public Payroll construirNominaBase() {
        Payroll payroll = new Payroll();
        ArrayList<Employee> employees = employeeRepository.getAllByRetirementDateIsNullOrRetirementDateAfter(LocalDate.now());
        ArrayList<UpdateDetails> updateDetails = new ArrayList<>();
        for (Employee employee : employees){
            UpdateDetails updateDetail =new UpdateDetails();
            updateDetail.setEmployee(employee);
            Update auxTransportation = createAuxTransportation();
            updateDetail.getUpdates().add(auxTransportation);
            updateDetails.add(updateDetail);
        }
        payroll.setUpdateDetails(updateDetails);
        return payrollRepository.save(payroll);
    }

    private Update createAuxTransportation() {
        Update update = new Update();
        update.setUpdateDate(LocalDate.now());
        update.setAmount(payrollUpdateServices.calculateTransportationAux(30));
        update.setUpdateType(UpdateType.AUXILIO_DE_TRANSPORTE);
        update.setDescription("Auxilio de transporte");
        return update;
    }

    /**
     * @param payroll
     * @param idEmpleado
     * @param tipo
     * @param valor
     * @return
     */
    @Override
    public Payroll agregarNovedades(Payroll payroll, String idEmpleado, UpdateType tipo, Double valor) {
        return null;
    }

    /**
     * @param payroll
     * @param idEmpleado
     * @param tipo
     * @param valor
     * @return
     */
    @Override
    public Payroll editarNovedades(Payroll payroll, String idEmpleado, UpdateType tipo, Double valor) {
        return null;
    }
}
