package com.restaurant.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.restaurant.exceptions.product.ProductFetchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restaurant.dto.product.ProductDtoAdd;
import com.restaurant.exceptions.product.ExceptioAddedProduct;
import com.restaurant.model.document.Product;
import com.restaurant.repository.ProductoRepository;
import com.restaurant.service.Interface.ProductServiceInterface;
import com.restaurant.validators.product.ProductValidators;

@Service
public class ProductService implements ProductServiceInterface {

  @Autowired
  public ProductoRepository productRepository;

  @Autowired
  public ProductValidators productValidators;

  @Override
  public Product addProduct(ProductDtoAdd ProductDtoAdd) throws ExceptioAddedProduct {
    if (productValidators.verificationProduct(ProductDtoAdd.nameProduct())) {
      if (productValidators.validatorSupplier(ProductDtoAdd.nameProduct(), ProductDtoAdd.supplier())) {
        return updateProductAmount(ProductDtoAdd);
      } else {
        return updateProductListsSUpplier(ProductDtoAdd);
      }
    } else {

      ArrayList<String> listSupplier = new ArrayList<>();
      listSupplier.add(ProductDtoAdd.supplier());
      Product product = Product.builder()
          .nameProduct(ProductDtoAdd.nameProduct())
          .suppliers(listSupplier)
          .stock(ProductDtoAdd.amount())
          .dateExpiration(ProductDtoAdd.dateExpiration())
          .dateRegister(ProductDtoAdd.dateAdd())
          .weightProduct(ProductDtoAdd.weightProduct())
          .build();
      return productRepository.save(product);
    }
  }

  @Override
  public Product updateProductAmount(ProductDtoAdd productDtoAdd) {
    Optional<Product> product = productRepository.findByNameProduct(productDtoAdd.nameProduct());
    Product aux = product.get();
    Product updateProduct = product.get();
    updateProduct.setWeightProduct(aux.getWeightProduct());
    updateProduct.setStock(aux.getStock() + productDtoAdd.amount());
    updateProduct.setSuppliers(aux.getSuppliers());
    updateProduct.setWeightProduct(aux.getWeightProduct() + productDtoAdd.weightProduct());
    return productRepository.save(updateProduct);

  }

  @Override
  public Product updateProductListsSUpplier(String nameProduct, String supplier, int amount) {
    return null;
  }

  @Override
  public Product updateProductListsSUpplier(ProductDtoAdd productDtoAdd) {
    Optional<Product> product = productRepository.findByNameProduct(productDtoAdd.nameProduct());
    Product aux = product.get();
    ArrayList<String> suppliers = aux.getSuppliers();
    suppliers.add(productDtoAdd.supplier());
    Product updateProduct = product.get();
    updateProduct.setWeightProduct(aux.getWeightProduct() + productDtoAdd.weightProduct());
    updateProduct.setStock(aux.getStock() + productDtoAdd.amount());
    updateProduct.setSuppliers(suppliers);
    return productRepository.save(updateProduct);
  }

  @Override
  public List<Product> getAvailableProducts() throws ProductFetchException {
    List<Product> products = productRepository.findByStockGreaterThan(0);
    if (products.isEmpty()) {
      throw new ProductFetchException("No products available");
    }
    return products;
  }
}
