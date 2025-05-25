package com.restaurant.controller.implementation.pay;

import com.mercadopago.resources.preference.Preference;
import com.restaurant.dto.pay.ItemPayDto;
import com.restaurant.model.vo.Items;
import com.restaurant.model.vo.MenuItem;
import com.restaurant.service.implementation.pay.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("Pay")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @RequestMapping(value = "/realizarPago", method = RequestMethod.POST)
    public ResponseEntity<Preference> realizatePay(@Valid @RequestBody List<ItemPayDto> itemsDto) throws Exception {
        List<Items> items = new ArrayList<>();
        Items item= new Items();
        for(ItemPayDto it: itemsDto){
        item.setMenuItem(it.menuItem());
        item.setAmountServings(it.amountServings());
        item.setRestServings(it.restServings());
        items.add(item);
        }

        Preference preference = paymentService.createPayment(items);
        return ResponseEntity.ok(preference);
    }

}
