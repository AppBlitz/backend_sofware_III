package com.restaurant.repository;
import com.restaurant.model.document.Payroll;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Date;
import java.util.List;

@Repository
public interface PayrollRepository extends MongoRepository<Payroll, String>{
    //obtiene todas las nominas donde se encuentre el id del empleado pasado por parametro
    List<Payroll> findAllByUpdateDetailsEmployeeIdContains(String updateDetailsEmployeeId);

    List<Payroll> findAllByAnio(int anio);

    List<Payroll> findAllByAnioAfter(int anioAfter);

    List<Payroll> findByAnioAndMonth(int anio, Payroll.Month month);

    List<Payroll> findByPay_Fecha(Date payFecha);


}
