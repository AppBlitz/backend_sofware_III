package com.restaurant.service.Interface;

public interface IEmailService {
    /**
     * Sends an order recommendation email with a PDF attachment.
     *
     * @param toEmail    The recipient's email address.
     * @param pdfContent The PDF file content as a byte array.
     * @throws Exception If an error occurs while sending the email.
     */
    void sendOrderRecommendationEmail(String toEmail, byte[] pdfContent) throws Exception;

}
