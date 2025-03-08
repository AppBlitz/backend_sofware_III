package com.restaurant.service.implementation;

import com.restaurant.service.Interface.IEmailService;
import jakarta.mail.util.ByteArrayDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

@Service
public class EmailService implements IEmailService {

    @Value("${spring.mail.username}")
    String username;

    @Value("${spring.mail.host}")
    String host;

    @Value("${spring.mail.port}")
    int port;

    @Value("${spring.mail.password}")
    String password;

    @Override
    public void sendOrderRecommendationEmail(String toEmail, byte[] pdfContent) throws Exception {
        Email email = EmailBuilder.startingBlank()
                .from(username)
                .to(toEmail)
                .withSubject("Recomendacion de pedido Generada automaticamente")
                .withPlainText("")
                .withAttachment("OrderRecommendation.pdf", new ByteArrayDataSource(pdfContent, "application/pdf"), "image/png")  // Adjuntar el QR
                .buildEmail();

        try (Mailer mailer = MailerBuilder
                .withSMTPServer(host, Integer.valueOf(port), username, password)
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .withDebugLogging(false)
                .buildMailer()) {


            mailer.sendMail(email);
        }
    }

}


