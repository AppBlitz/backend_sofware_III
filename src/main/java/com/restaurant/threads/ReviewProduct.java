package com.restaurant.threads;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.restaurant.dto.product.ProductExpiration;
import com.restaurant.model.document.Product;
import com.restaurant.repository.ProductRepository;
import com.restaurant.service.implementation.EmailService;
import com.restaurant.util.PdfGenerator;
import org.springframework.stereotype.Service;

@Service
public class ReviewProduct extends Thread {

  @Autowired
  ProductRepository productRepository;

  @Autowired(required = true)
  EmailService emailService;

  @Autowired(required = true)
  PdfGenerator pdfGenerator;

  @Scheduled(cron = "0 0 8 * * *")
  public void sendMessage() throws Exception {
    // Send email
    foundProduct();
  }

  public void sendMessageDateExpirationProduct(ArrayList<ProductExpiration> productExpirations) throws Exception {
    emailService.sendOrderRecommendationEmail("equiporoblox520@gmail.com", pdfGenerator.expirationProducts(productExpirations));
  }

  public void foundProduct() throws Exception {
    ArrayList<ProductExpiration> productsExpiration = new ArrayList<>();

    LocalDate how = LocalDate.now();
    LocalDate nowPlusSevenDays= how.plusDays(7);
    List<Product> productList = productRepository.findProductsExpiring(how,nowPlusSevenDays);
    for (Product producto : productList) {
      if (calcularDate(how, producto.getDateExpiration().get(0))) {
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
    ProductExpiration productExpiration = new ProductExpiration(product.getNameProduct(), product.getDateExpiration().get(0));
    return productExpiration;

  }
}
