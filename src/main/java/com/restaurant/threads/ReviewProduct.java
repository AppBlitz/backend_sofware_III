package com.restaurant.threads;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.restaurant.dto.product.ProductExpiration;
import com.restaurant.model.document.Product;
import com.restaurant.repository.ProductRepository;
import com.restaurant.service.implementation.EmailService;
import com.restaurant.util.PdfGenerator;

public class ReviewProduct extends Thread {

  @Autowired
  ProductRepository productRepository;

  @Autowired(required = true)
  EmailService emailService;

  @Autowired(required = true)
  PdfGenerator pdfGenerator;

  @Scheduled(cron = "0 8 * * DE LUNES A DOMINGO")
  public void sendMessage() {
    // Send email
  }

  public void sendMessageDateExpirationProduct(ArrayList<ProductExpiration> productExpirations) throws Exception {
    emailService.sendOrderRecommendationEmail("", pdfGenerator.expirationProducts(productExpirations));
  }

  public void foundProduct(ArrayList<Product> products) throws Exception {
    ArrayList<ProductExpiration> productsExpiration = new ArrayList<>();
    LocalDate how = LocalDate.now();
    for (Product producto : products) {
      if (calcularDate(how, producto.getDateExpiration())) {
        productsExpiration.add(createStructureProductExpiration(producto));
      }
    }
    sendMessageDateExpirationProduct(productsExpiration);
  }

  public boolean calcularDate(LocalDate how, LocalDate product) {
    long amountDays = ChronoUnit.DAYS.between(how, product);
    if (amountDays <= 7) {
      return true;
    }
    return false;
  }

  public ProductExpiration createStructureProductExpiration(Product product) {
    ProductExpiration productExpiration = new ProductExpiration(product.getNameProduct(), product.getDateExpiration());
    return productExpiration;

  }
}
