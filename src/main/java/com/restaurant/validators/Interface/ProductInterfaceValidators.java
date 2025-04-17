package com.restaurant.validators.Interface;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import com.restaurant.dto.product.ListProducts;
import com.restaurant.model.document.Product;
import com.restaurant.model.document.Supplier;

public interface ProductInterfaceValidators {

  /**
   * @param nameProduct
   * @return true if product exist or false if profuct no exist
   */
  public boolean verificationProduct(String nameProduct);

  /**
   * @param nameProduct
   * @param nameSupplier
   * @return true if supplier is found or false is not supplier found
   */
  public boolean validatorSupplier(String nameProduct, String nameSupplier);

  /**
   * @param suppliers    arrays of supplier as have product
   * @param nameSupplier name supplier
   * @return true if found name supplier or false if no found name supplier
   */
  public boolean validarExistsSupplier(ArrayList<String> suppliers, String nameSupplier);

  /**
   * @param nameSupplier
   * @return
   */
  public boolean identificationSupplierForName(String nameSupplier);

  /**
   * @param nameSupplier
   * @return
   */
  public Supplier searchSupplierName(String nameSupplier);

//  /**
//   * @return
//   */
//  public ArrayList<ListProducts> listAllProducts();
//
//  /**
//   * @return
//   */
//  public ListProducts createProductDto(Product product);

  public byte[] addImageProduct(MultipartFile image);

}
