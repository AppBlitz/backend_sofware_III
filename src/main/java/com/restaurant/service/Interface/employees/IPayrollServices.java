package com.restaurant.service.Interface.employees;

import com.restaurant.model.Enum.UpdateType;
import com.restaurant.model.document.Payroll;

public interface IPayrollServices {
    Payroll pagar(Payroll payroll);
    Payroll construirNominaBase();
    Payroll agregarNovedades(Payroll payroll, String idEmpleado, UpdateType tipo, Double valor);
    Payroll editarNovedades(Payroll payroll, String idEmpleado, UpdateType tipo, Double valor);
    Double calculateTotal(Payroll payroll);


}
