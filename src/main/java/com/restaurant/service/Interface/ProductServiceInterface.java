package com.restaurant.service.Interface;

import com.restaurant.dto.product.ProductDtoAdd;
import com.restaurant.exceptions.product.ErrorConsultandoProducto;
import com.restaurant.exceptions.product.ExceptioAddedProduct;
import com.restaurant.exceptions.product.ExceptionUpdateProduct;
import com.restaurant.model.document.Product;

import java.util.Optional;

public interface ProductServiceInterface {
  /**
   * @param ProductDtoAdd
   * @return
   * @throws ExceptioAddedProduct
   */
  public Product addProduct(ProductDtoAdd ProductDtoAdd) throws ExceptioAddedProduct;

  /**
   * @param nameProduct
   * @param amount
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
   * @throws ErrorConsultandoProducto
   */
  public Optional<Product> ConsultarProductosDisponibles() throws ErrorConsultandoProducto;


  public Product updateProductListsSUpplier(ProductDtoAdd productDtoAdd);

  public Product updateProductListsSUpplier(ProductDtoAdd productDtoAdd);
}
