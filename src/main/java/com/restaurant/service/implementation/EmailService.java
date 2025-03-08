package com.restaurant.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;

import com.restaurant.dto.product.ProductExpiration;
import com.restaurant.exceptions.product.ExceptionSendReport;
import com.restaurant.service.Interface.EmailServiceInterface;

public class EmailService implements EmailServiceInterface {

  @Autowired
  private JavaMailSender javaMailSender;

  @Override
  @Async
  public void sendProductEpiration(ProductExpiration productExpiration) throws ExceptionSendReport {

  }

}
