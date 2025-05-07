package com.restaurant.service.Interface.email;

import com.restaurant.dto.user.UserDto;

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

    /**
     * @param to         email of destination
     * @param subject
     * @param idShopping for search shopping cart
     * @throws MessagingException
     *
     *                            The aim of this method is to be able to send the
     *                            payment invoice when the shopping cart is checked
     *                            out.
     */
    void sendEmailBill(UserDto user, String subject, String idShopping) throws MessagingException;

    /**
     * @param message
     * @throws MessagingException
     */
    public void sendMessage(MimeMessage message) throws MessagingException;

    /**
     * @param name user
     * @return message
     *
     *         Message structure for when the message is sent
     */
    public String createMessage(String name);

}
