package com.restaurant.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurant.service.implementation.cart.ShoppinCartServiceIm;
import com.restaurant.service.implementation.inventory.RecipeServices;
import com.restaurant.model.vo.*;
import com.restaurant.dto.cart.UpdateShopping;
import com.restaurant.model.Enum.*;

@SpringBootTest
public class ShoppinCartServiceTest {

  @Autowired
  ShoppinCartServiceIm shoppinCartServiceIm;

  @Autowired
  RecipeServices recipeServices;

  @Test
  public void createShoppingCart() {
    assertNotNull(shoppinCartServiceIm.createShoppingCart());
  }

  @Test
  public void addData() {
    ArrayList<Items> datas = new ArrayList<>();
    MenuItem menuItem_uno = new MenuItem("681ae25fb76eef217eee214c", "", CategoriItem.BREAKFAST);
    MenuItem menuItem = new MenuItem("", "680207e38a976e641f7b951b", CategoriItem.BREAKFAST);
    Items item = new Items(menuItem, 0, 19);
    Items item_dos = new Items(menuItem_uno, 35, 0);
    datas.add(item);
    datas.add(item_dos);
    assertNotNull(shoppinCartServiceIm.addProducAnShopping(new UpdateShopping("681b61aa1e710924d1408dd6", datas)));

  }

}
