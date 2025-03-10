package com.restaurant.controller.Interface.supplier;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface IOrderController {

    /**
     * Generates an automatic order recommendation and sends it via email as a PDF attachment.
     *
     * @param email The recipient's email address.
     * @return A response indicating whether the recommendation was sent successfully or if an error occurred.
     */
    ResponseEntity<String> sendRecommendation(@RequestParam String email);
}
