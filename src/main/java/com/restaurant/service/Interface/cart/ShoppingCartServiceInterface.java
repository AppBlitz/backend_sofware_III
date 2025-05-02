package com.restaurant.service.Interface.cart;

import com.restaurant.dto.cart.ActivateShopping;
import com.restaurant.dto.cart.AddProductDto;
import com.restaurant.model.document.ShoppingCart;

public interface ShoppingCartServiceInterface {

  /**
   * @param addProduct
   * @return
   */
  public ShoppingCart addMenuCart(AddProductDto addProduct);

  /**
   * @return
   */
  public ShoppingCart createShoppingCart();

  /**
   * @param id
   * @return
   */
  public void deleteCar(String id);

  public ShoppingCart searchCartId(String id);

  public ShoppingCart activateCart(ActivateShopping activateShopping);

}
