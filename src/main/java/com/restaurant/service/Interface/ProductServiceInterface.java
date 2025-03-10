package com.restaurant.service.Interface;

import java.util.ArrayList;
import java.util.Optional;

import com.restaurant.dto.product.ListProducts;
import com.restaurant.dto.product.ProductDtoAdd;
import com.restaurant.exceptions.product.ExceptioAddedProduct;
import com.restaurant.exceptions.product.ExceptionUpdateProduct;
import com.restaurant.exceptions.product.ProductFetchException;
import com.restaurant.model.document.Product;

public interface ProductServiceInterface {
  /**
   * @param ProductDtoAdd
   * @return
   * @throws ExceptioAddedProduct
   */
  public Product addProduct(ProductDtoAdd ProductDtoAdd) throws ExceptioAddedProduct;

  /**
   * @return
   * @throws ExceptionUpdateProduct
   */
  public Product updateProductAmount(ProductDtoAdd productDtoAdd) throws ExceptionUpdateProduct;

  /**
   * @param nameProduct
   * @param supplier
   * @return
   */
  public Product updateProductListsSUpplier(String nameProduct, String supplier, int amount);

  /**
   * @return
   * @throws ProductFetchException
   */
  public Optional<Product> ConsultarProductosDisponibles() throws ProductFetchException;

  /**
   * @param productDtoAdd
   * @return
   */
  public Product updateProductListsSUpplier(ProductDtoAdd productDtoAdd);

  /**
   * @param productDtoAdd
   * @return
   */
  public Product createProduct(ProductDtoAdd productDtoAdd);

  /**
   * @return
   */
  public ArrayList<ListProducts> getAllProducts();
}
