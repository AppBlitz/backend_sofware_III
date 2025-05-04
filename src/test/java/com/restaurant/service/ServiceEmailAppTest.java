package com.restaurant.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurant.service.implementation.email.EmailService;

import jakarta.mail.MessagingException;

@SpringBootTest
public class ServiceEmailAppTest {

  @Autowired
  EmailService emailService;

  @Test
  public void sendEmail() throws MessagingException {

    String to = "carlosfabiancorraleszapata9@gmail.com";
    String subject = "Factura eléctronica";
    emailService.sendEmailBill(to, subject);
  }

  @Test
  public void sendVoice() {

  }

}
