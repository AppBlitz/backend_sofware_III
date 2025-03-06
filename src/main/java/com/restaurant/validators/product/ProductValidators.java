package com.restaurant.validators.product;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.restaurant.model.document.Product;
import com.restaurant.repository.ProductoRepository;

public class ProductValidators {

  @Autowired
  ProductoRepository productoRepository;

  /**
   * @param nameProduct
   * @return true if product exist or false if profuct no exist
   */
  public boolean verificationProduct(String nameProduct) {
    Optional<Product> product = productoRepository.findByNombreProducto(nameProduct);
    if (product.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * @param nameProduct
   * @param nameSupplier
   * @return true if supplier is found or false is not supplier found
   */
  public boolean validatorSupplier(String nameProduct, String nameSupplier) {
    Optional<Product> product = productoRepository.findByNombreProducto(nameProduct);
    if (product.isEmpty()) {
      return false;
    } else {
      return validarExistsSUpplier(product.get().getProveedores(), nameSupplier);
    }

  }

  /**
   * @param suppliers    arrays of supplier as have product
   * @param nameSupplier name supplier
   * @return true if found name supplier or false if no found name supplier
   */
  private boolean validarExistsSUpplier(String[] suppliers, String nameSupplier) {
    int i = 0;
    while (i < suppliers.length) {
      if (suppliers[i].equals(nameSupplier)) {
        i = suppliers.length;
        return true;
      }
    }
    return false;
  }

}
