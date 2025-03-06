package com.restaurant.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.restaurant.dto.product.ProductDtoAdd;
import com.restaurant.exceptions.product.ExceptioAddedProduct;
import com.restaurant.model.document.Product;
import com.restaurant.repository.ProductoRepository;
import com.restaurant.service.Interface.ProductServiceInterface;
import com.restaurant.validators.product.ProductValidators;

public class ProductService implements ProductServiceInterface {

  @Autowired
  public ProductoRepository productRepository;

  @Autowired
  public ProductValidators productValidators;

  @Override
  public Product addProduct(ProductDtoAdd ProductDtoAdd) throws ExceptioAddedProduct {
    if (productValidators.verificationProduct(ProductDtoAdd.nameProduct())) {
      if (productValidators.validatorSupplier(ProductDtoAdd.nameProduct(), ProductDtoAdd.supplier())) {
        return updateProductAmount(ProductDtoAdd.nameProduct(), ProductDtoAdd.amount());
      } else {
        return updateProductListsSUpplier(ProductDtoAdd.nameProduct(), ProductDtoAdd.supplier());
      }
    } else {

      Product product = new Product();
      return productRepository.save(product);
    }
  }

  @Override
  public Product updateProductAmount(String nameProduct, int amount) {
    Optional<Product> product = productRepository.findByNombreProducto(nameProduct);
    Product aux = product.get();
    Product updateProduct = product.get();
    updateProduct.setPesoProducto(aux.getPesoProducto());
    updateProduct.setCantidad(aux.getCantidad() + amount);
    updateProduct.setProveedores(aux.getProveedores());
    return updateProduct;

  }

  @Override
  public Product updateProductListsSUpplier(String nameProduct, String supplier) {
    Optional<Product> product = productRepository.findByNombreProducto(nameProduct);
    Product aux = product.get();
    String[] suppliers = aux.getProveedores();
    Product updateProduct = product.get();
    updateProduct.setPesoProducto(aux.getPesoProducto());
    updateProduct.setCantidad(aux.getCantidad());
    updateProduct.setProveedores(suppliers);
    return updateProduct;
  }

}
