package com.restaurant.repository;
import com.restaurant.model.document.Payroll;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface PayrollRepository extends MongoRepository<Payroll, String>{
    //obtiene todas las nominas donde se encuentre el id del empleado pasado por parametro
    List<Payroll> findAllByUpdateDetailsEmployeeIdContains(String updateDetailsEmployeeId);


    List<Payroll> findAllByYear(int year);

    List<Payroll> findAllByYearAfter(int yearAfter);

    List<Payroll> findByYearAndMonth(int year, Payroll.Month month);

    List<Payroll> findByPay_Date(LocalDate payDate);


}
