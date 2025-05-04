package com.restaurant.service.Interface.cart;

import java.util.List;

import com.restaurant.dto.cart.ActivateShopping;
import com.restaurant.dto.cart.AddProductDto;
import com.restaurant.dto.cart.DeleteMenuShopping;
import com.restaurant.model.document.ShoppingCart;

public interface ShoppingCartServiceInterface {

  /**
   * @param addProduct
   * @return shopping cart with menu add
   *
   *         add menu at shopping cart
   */
  public ShoppingCart addMenuCart(AddProductDto addProduct);

  /**
   * @return
   */
  public ShoppingCart createShoppingCart();

  /**
   * @param id to find the shopping cart
   * @return nothing
   */
  public void deleteCar(String id);

  /**
   * @param id to find the shopping cart
   * @return Desired shopping cart
   * @exception If no error is found with the shopping cart search, send an
   *               exception.
   */
  public ShoppingCart searchCartId(String id);

  /**
   * @param activateShopping
   * @return shopping cart with state updated
   *
   *         updated state of cart if is inactive
   */
  public ShoppingCart activateCart(ActivateShopping activateShopping);

  /**
   * @param deleteMenuShopping
   * @return shopping cart updated, then updated items of shopping cart
   *
   *         Remove products from the shopping cart
   */
  public ShoppingCart deleteMenu(DeleteMenuShopping deleteMenuShopping);

  /**
   * @return list the shopping cart save in database
   *         What the method does is to fetch a list of shopping carts, regardless
   *         of the status of the cart, it still fetches them.
   */
  public List<ShoppingCart> getAllShopping();

}
