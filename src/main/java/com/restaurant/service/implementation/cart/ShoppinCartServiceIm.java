package com.restaurant.service.implementation.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.dto.cart.ActivateShopping;
import com.restaurant.dto.cart.AddProductDto;
import com.restaurant.dto.cart.DeleteMenuShopping;
import com.restaurant.exceptions.cart.SearchCartException;
import com.restaurant.model.Enum.cart.StateCart;
import com.restaurant.model.document.ShoppingCart;
import com.restaurant.repository.ShoppingCartRespository;
import com.restaurant.service.Interface.cart.ShoppingCartServiceInterface;
import com.restaurant.validators.cart.validatorsCartCom;

@Service
public class ShoppinCartServiceIm implements ShoppingCartServiceInterface {

  @Autowired
  ShoppingCartRespository shoppingCartRepository;

  @Autowired
  validatorsCartCom validatorsCartCom;

  @Override
  public ShoppingCart addMenuCart(AddProductDto addProduct) {
    ShoppingCart cartAdd = validatorsCartCom.searchCart(addProduct.id());
    if (cartAdd.getStateCart() == StateCart.INACTIVE) {
      throw new SearchCartException("Shopping cart is not available, is inactive");
    }
    ShoppingCart cartUpdate = ShoppingCart.builder()
        .id(cartAdd.getId())
        .stateCart(cartAdd.getStateCart())
        .menus(addProduct.menus())
        .amount(addProduct.menus().size())
        .total(addProduct.total())
        .build();
    validatorsCartCom.runListMenus(addProduct.menus());
    return shoppingCartRepository.save(cartUpdate);
  }

  @Override
  public ShoppingCart createShoppingCart() {
    ShoppingCart cart = ShoppingCart.builder()
        .id(validatorsCartCom.createIdCart().toString())
        .amount(0)
        .stateCart(StateCart.PENDING)
        .build();
    return shoppingCartRepository.save(cart);
  }

  @Override
  public void deleteCar(String id) {
    ShoppingCart cartDelete = validatorsCartCom.searchCart(id);
    ShoppingCart cartUpdate = ShoppingCart.builder()
        .id(cartDelete.getId())
        .stateCart(StateCart.INACTIVE)
        .menus(cartDelete.getMenus())
        .amount(cartDelete.getAmount())
        .build();

    shoppingCartRepository.save(cartUpdate);
  }

  @Override
  public ShoppingCart searchCartId(String id) {
    return validatorsCartCom.searchCart(id);
  }

  @Override
  public ShoppingCart activateCart(ActivateShopping activateShopping) {
    ShoppingCart cartDelete = validatorsCartCom.searchCart(activateShopping.id());
    ShoppingCart cartUpdate = ShoppingCart.builder()
        .id(cartDelete.getId())
        .stateCart(StateCart.PENDING)
        .menus(cartDelete.getMenus())
        .amount(cartDelete.getAmount())
        .build();
    shoppingCartRepository.save(cartUpdate);
    return cartUpdate;
  }

  @Override
  public ShoppingCart deleteMenu(DeleteMenuShopping deleteMenuShopping) {
    ShoppingCart deleteMenu = validatorsCartCom.searchCart(deleteMenuShopping.id());
    ShoppingCart updated = ShoppingCart.builder()
        .id(deleteMenu.getId())
        .stateCart(deleteMenuShopping.stateCart())
        .menus(validatorsCartCom.deleteItems(deleteMenuShopping.menus(), deleteMenu.getId()))
        .amount(deleteMenuShopping.amount())
        .build();
    return shoppingCartRepository.save(updated);
  }

  @Override
  public List<ShoppingCart> getAllShopping() {
    return shoppingCartRepository.findAll();
  }

}
