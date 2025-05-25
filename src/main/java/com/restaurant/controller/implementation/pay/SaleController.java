package com.restaurant.controller.implementation.pay;


import com.restaurant.dto.pay.saleDto;
import com.restaurant.model.vo.Sale;
import com.restaurant.service.implementation.pay.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sale")
public class SaleController {

    @Autowired
    SaleService saleService;

    @RequestMapping(value = "/venta", method = RequestMethod.POST)
    public ResponseEntity<Sale> saveSale(@RequestBody saleDto saledto) throws Exception {
        Sale sale = saleService.saveSale(saledto);

        return ResponseEntity.ok(sale);
    }

    @RequestMapping(value = "/getsale/{id}", method = RequestMethod.GET)
    public ResponseEntity<Sale> saveSale(@PathVariable String id) throws Exception {
        Sale sale= saleService.getsaleid(id);

        return ResponseEntity.ok(sale);
    }
}
