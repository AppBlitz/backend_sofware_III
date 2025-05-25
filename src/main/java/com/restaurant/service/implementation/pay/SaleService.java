package com.restaurant.service.implementation.pay;

import com.restaurant.dto.pay.saleDto;
import com.restaurant.model.vo.Sale;
import com.restaurant.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    SaleRepository saleRepository;

    public Sale saveSale(saleDto sale) {
        Sale newsale = new Sale();

        newsale.setIdCashier(sale.idCashier());
        newsale.setDate(sale.date());
        newsale.setPaymentMethod(sale.paymentMethod());
        newsale.setIdShoppingCart(sale.idShoppingCart());
        newsale.setAmount(sale.amount());

        return saleRepository.save(newsale);
    }

    public Sale getsaleid(String id) throws Exception{
        Optional<Sale> sale = saleRepository.findById(id);
        if(sale.isPresent()){
        return sale.get();}
        else{
            throw new Exception("no hay venta con ese id");
        }
    }

}
