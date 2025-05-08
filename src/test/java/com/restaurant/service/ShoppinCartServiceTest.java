package com.restaurant.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurant.dto.cart.UpdateShopping;
import com.restaurant.model.Enum.CategoriItem;
import com.restaurant.model.document.Recipe;
import com.restaurant.model.vo.Items;
import com.restaurant.model.vo.MenuItem;
import com.restaurant.service.implementation.cart.ShoppinCartServiceIm;
import com.restaurant.service.implementation.inventory.RecipeServices;
import com.restaurant.model.document.Product;

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

  @Test
  public void deleteCart() {

    shoppinCartServiceIm.deleteShopping("681c12764c19f05068897aad");
  }

  @Test
  public void searchCategory() {
    List<Recipe> recipes = shoppinCartServiceIm.getAllRecipe("681b61aa1e710924d1408dd6");
    assertTrue(recipes.size() > 0);
  }

  @Test
  //Perfect
  public void searchProduct() {

    List<Product> product = shoppinCartServiceIm.getAllProduct("681b61aa1e710924d1408dd6");
    assertTrue(product.size() > 0);

  }

}
