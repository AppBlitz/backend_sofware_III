package com.restaurant.service.implementation;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.restaurant.model.document.ShoppingCart;
import com.restaurant.service.Interface.email.IEmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;

@Service
public class EmailService implements IEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

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
                .withAttachment("OrderRecommendation.pdf", new ByteArrayDataSource(pdfContent, "application/pdf"),
                        "image/png") // Adjuntar el QR
                .buildEmail();

        try (Mailer mailer = MailerBuilder
                .withSMTPServer(host, Integer.valueOf(port), username, password)
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .withDebugLogging(false)
                .buildMailer()) {

            mailer.sendMail(email);
        }
    }

    @Override
    public void sendEmailBill(String to, String subject) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(username);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(createMessage("Carlos"), true);
        sendMessage(message);
    }

    @Override
    public void sendMessage(MimeMessage message) throws MessagingException {
        javaMailSender.send(message);
    }

    @Override
    public String createMessage(String name) {
        String body = "<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\" />\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n" +
                "    <title>Electronic Invoice</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            background-color: #121212;\n" +
                "            color: #ffffff;\n" +
                "            font-family: 'Arial', sans-serif;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "        .container {\n" +
                "            max-width: 600px;\n" +
                "            margin: 20px auto;\n" +
                "            padding: 20px;\n" +
                "            background-color: #1e1e1e;\n" +
                "            border-radius: 10px;\n" +
                "            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);\n" +
                "        }\n" +
                "        .header {\n" +
                "            text-align: center;\n" +
                "            margin-bottom: 20px;\n" +
                "        }\n" +
                "        .header h1 {\n" +
                "            margin: 0;\n" +
                "            font-size: 24px;\n" +
                "            color: #ffffff;\n" +
                "        }\n" +
                "        .header p {\n" +
                "            margin: 0;\n" +
                "            font-size: 14px;\n" +
                "            color: #b0b0b0;\n" +
                "        }\n" +
                "        .content {\n" +
                "            font-size: 16px;\n" +
                "            line-height: 1.8;\n" +
                "        }\n" +
                "        .footer {\n" +
                "            text-align: center;\n" +
                "            margin-top: 20px;\n" +
                "            font-size: 12px;\n" +
                "            color: #b0b0b0;\n" +
                "        }\n" +
                "        .button {\n" +
                "            display: inline-block;\n" +
                "            margin: 20px auto;\n" +
                "            padding: 10px 20px;\n" +
                "            color: #ffffff;\n" +
                "            background-color: #007BFF;\n" +
                "            text-decoration: none;\n" +
                "            border-radius: 5px;\n" +
                "            font-weight: bold;\n" +
                "        }\n" +
                "        .button:hover {\n" +
                "            background-color: #0056b3;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"container\">\n" +
                "        <div class=\"header\">\n" +
                "            <h1>Hello, " + name + "</h1>\n" +
                "            <p>Your invoice is ready</p>\n" +
                "        </div>\n" +
                "        <div class=\"content\">\n" +
                "            <p>We are delighted to provide you with the details of your invoice. Attached you will find all the necessary information regarding your recent transaction.</p>\n"
                +
                "            <p>If you have any questions or need further assistance, do not hesitate to contact us. Your satisfaction is our priority.</p>\n"
                +
                "            <a href=\"#\" class=\"button\">View Invoice</a>\n" +
                "        </div>\n" +
                "        <div class=\"footer\">\n" +
                "            <p>Thank you for trusting us with your business.</p>\n" +
                "            <p>&copy; 2025 Your Company Name. All rights reserved.</p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";

        return body;
    }

}
