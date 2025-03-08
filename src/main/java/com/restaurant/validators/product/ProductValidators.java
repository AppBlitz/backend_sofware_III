package com.restaurant.validators.product;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurant.model.document.Product;
import com.restaurant.repository.ProductoRepository;
import com.restaurant.validators.Interface.ProductInterfaceValidators;

@Component
public class ProductValidators implements ProductInterfaceValidators {

  @Autowired
  ProductoRepository productoRepository;

  @Override
  public boolean verificationProduct(String nameProduct) {
    Optional<Product> product = productoRepository.findByNameProduct(nameProduct);
    if (product.isEmpty()) {
      return false;
    }
    return true;
  }

  @Override
  public boolean validatorSupplier(String nameProduct, String nameSupplier) {
    Optional<Product> product = productoRepository.findByNameProduct(nameProduct);
    if (product.isEmpty()) {
      return false;
    } else {
      return validarExistsSupplier(product.get().getSuppliers(), nameSupplier);
    }

  }

  @Override
  public boolean validarExistsSupplier(ArrayList<String> suppliers, String nameSupplier) {
    for (String supplier : suppliers) {
      if (supplier.equals(nameSupplier)) {
        return true;
      }
    }
    return false;
  }
}
