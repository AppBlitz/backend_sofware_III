package com.restaurant.threads;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.restaurant.dto.product.ProductExpiration;
import com.restaurant.model.document.Product;
import com.restaurant.repository.ProductoRepository;

public class ReviewProduct extends Thread {

  @Autowired
  ProductoRepository productoRepository;

  @Scheduled(cron = "0 8 * * DE LUNES A DOMINGO")
  public void sendMessage(ProductExpiration productExpiration) {
    // Send email
  }

  public void sendMessageDateExpirationProduct() {

  }

  public void foundProduct(ArrayList<Product> products) {
    LocalDate how = LocalDate.now();
    for (Product producto : products) {
      if (calcularDate(how, producto.getDateExpiration())) {

      }
    }
  }

  public boolean calcularDate(LocalDate how, LocalDate product) {
    long amountDays = ChronoUnit.DAYS.between(how, product);
    if (amountDays <= 7) {
      return true;
    }
    return false;
  }

}
