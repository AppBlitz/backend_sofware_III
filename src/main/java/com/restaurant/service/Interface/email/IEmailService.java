package com.restaurant.service.Interface.email;

import com.restaurant.model.document.ShoppingCart;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

public interface IEmailService {
    /**
     * Sends an order recommendation email with a PDF attachment.
     *
     * @param toEmail    The recipient's email address.
     * @param pdfContent The PDF file content as a byte array.
     * @throws Exception If an error occurs while sending the email.
     */
    void sendOrderRecommendationEmail(String toEmail, byte[] pdfContent) throws Exception;

    void sendEmailBill(String to, String subject) throws MessagingException;

    public void sendMessage(MimeMessage message) throws MessagingException;

    public String createMessage(String name);

}
