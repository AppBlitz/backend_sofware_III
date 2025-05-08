package com.restaurant.service.Interface.inventory;

import java.util.List;

import com.restaurant.dto.product.ProductActiveDto;
import com.restaurant.dto.product.ProductDtoAdd;
import com.restaurant.dto.product.ProductUpdateDto;
import com.restaurant.exceptions.product.ExceptioAddedProduct;
import com.restaurant.exceptions.product.ExceptionUpdateProduct;
import com.restaurant.exceptions.product.ProductExcpetionState;
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
  public List<Product> getAvailableProducts() throws ProductFetchException;

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

  // /**
  // * @return list of products
  // */
  // public ArrayList<ListProducts> getAllProducts();

  /**
   * @param productUpdateDto for update product
   * @return priduct update
   */
  public Product updateProduct(ProductUpdateDto productUpdateDto);

  /**
   * add product to suppliers
   * 
   * @param idProduct
   * @param suppliers
   */
  public void verification_product_supplier(String idProduct, List<String> suppliers);

  public List<ProductActiveDto> getAllProductActive() throws ProductExcpetionState;

  public void ModificationProduct(String id, int amount, int rest);

  public boolean productExists(String id);

  public void sumStock(String idProduct, int rest);

  public void resProduct(String idProduct, int amount);

}
