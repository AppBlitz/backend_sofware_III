package com.restaurant.controller.implementation.pay;

import com.mercadopago.resources.preference.Preference;
import com.restaurant.model.vo.Items;
import com.restaurant.service.implementation.pay.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Pay")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @RequestMapping(value = "/realizar-pago", method = RequestMethod.POST)
    public ResponseEntity<Preference> realizarPago(@RequestBody List<Items> items) throws Exception {
        Preference preference = paymentService.createPayment(items);
        return ResponseEntity.ok(preference);
    }

}
