package com.restaurant.service.Interface;

import com.restaurant.dto.product.ProductExpiration;
import com.restaurant.exceptions.product.ExceptionSendReport;

public interface EmailServiceInterface {

  public void sendProductEpiration(ProductExpiration productExpiration) throws ExceptionSendReport;

}
