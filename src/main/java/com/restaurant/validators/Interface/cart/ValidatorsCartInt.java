package com.restaurant.validators.Interface.cart;

import java.util.ArrayList;

import com.restaurant.model.vo.Items;

public interface ValidatorsCartInt {

  public void modificationData(ArrayList<Items> items);

  public void modificationProduct(String idProduct, int amount, int rest);

  public void modificationRecipe(String idRecipe, int amount, int rest);

}
