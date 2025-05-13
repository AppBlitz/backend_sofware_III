package com.restaurant.validators.implementation.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.restaurant.model.document.Product;
import com.restaurant.model.document.Supplier;
import com.restaurant.repository.ProductRepository;
import com.restaurant.repository.SupplierRepository;
import com.restaurant.validators.Interface.ProductInterfaceValidators;

@Component
public class ProductValidators implements ProductInterfaceValidators {

  @Autowired
  ProductRepository productRepository;

  @Autowired
  SupplierRepository supplierRepository;

  @Override
  public boolean verificationProduct(String nameProduct) {
    Optional<Product> product = productRepository.findByNameProduct(nameProduct);
    if (product.isEmpty()) {
      return false;
    }
    return true;
  }

  @Override
  public boolean validatorSupplier(String nameProduct, String idSupplier) {
    Optional<Product> product = productRepository.findByNameProduct(nameProduct);
    if (product.isEmpty()) {
      return false;
    } else {
      return validarExistsSupplier(product.get().getSuppliers(), idSupplier);
    }

  }

  @Override
  public boolean validarExistsSupplier(ArrayList<String> suppliers, String idSupplier) {
    for (String supplier : suppliers) {
      if (validatorIdSupplier(supplier)) {
        return true;
      }
    }
    return false;
  }

  public boolean validatorIdSupplier(String idSupplier) {
    return supplierRepository.existsById(idSupplier);
  }

  @Override
  public boolean identificationSupplierForName(String nameSupplier) {
    return supplierRepository.existsByNameSupplier(nameSupplier);
  }

  @Override
  public Supplier searchSupplierName(String nameSupplier) {
    Optional<Supplier> supplier = supplierRepository.searchSupplier(nameSupplier);
    if (supplier.isEmpty()) {

    }
    return supplier.get();

  }

  public boolean verificationProductName(String nameProduct) {
    return productRepository.existsByNameProduct(nameProduct);
  }

  public byte[] addImageProduct(MultipartFile image) {
    if (image.isEmpty()) {
      return null;
    }

    try {
      return image.getBytes();
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException("Error al procesar la imagen: " + e.getMessage(), e);
    }
  }
}
