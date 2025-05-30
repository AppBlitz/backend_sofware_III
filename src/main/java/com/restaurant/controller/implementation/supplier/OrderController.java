package com.restaurant.controller.implementation.supplier;

import com.restaurant.controller.Interface.supplier.IOrderController;
import com.restaurant.model.vo.OrderRecommendation;
import com.restaurant.service.implementation.email.EmailService;
import com.restaurant.service.implementation.inventory.OrderRecommendationService;
import com.restaurant.util.PdfGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController implements IOrderController {

    @Autowired
    private OrderRecommendationService recommendationService;

    @Autowired
    private PdfGenerator pdfGenerator;

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/recommendation", method = RequestMethod.GET)
    public ResponseEntity<String> sendRecommendation(@RequestParam String email) {
        try {
            OrderRecommendation recommendation = recommendationService.generateRecommendation(10);
            byte[] pdf = pdfGenerator.generateOrderRecommendationPdf(recommendation);
            emailService.sendOrderRecommendationEmail(email, pdf);

            return ResponseEntity.ok("Recommendation sent to " + email);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

}
