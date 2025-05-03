package com.restaurant.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurant.service.implementation.EmailService;

import jakarta.mail.MessagingException;

@SpringBootTest
public class ServiceEmailAppTest {

  @Autowired
  EmailService emailService;

  @Test
  public void sendEmail() throws MessagingException {

    String to = "";
    String subject = "Factura eléctronica";
    emailService.sendEmailBill(to, subject);
  }

}
