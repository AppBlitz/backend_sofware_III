package com.restaurant.validators.product;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurant.model.document.Product;
import com.restaurant.repository.ProductoRepository;

@Component
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
   * @param nameSupplier nameSupplier supplier
   * @return true if found nameSupplier supplier or false if no found nameSupplier supplier
   */
  private boolean validarExistsSUpplier(ArrayList<String> suppliers, String nameSupplier) {
    for (String supplier : suppliers) {
      if (supplier.equals(nameSupplier)) {
        return true;
      }
    }
    return false;
  }

}
