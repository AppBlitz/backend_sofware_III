package com.restaurant.service;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RecipeServiceAppTest {

  // @Autowired
  // RecipeServices recipeService;
  //
  // @Test
  // public void deleteRecipe() {
  // Recipe old = recipeService.getRecipeById("680290f571ae414c518bf1ca");
  // recipeService.deleteRecipe("680290f571ae414c518bf1ca");
  // assertNotEquals(old,
  // recipeService.getRecipeById("680290f571ae414c518bf1ca"));
  // }
  //
  // @Test
  // public void listRecipe() {
  // List<Recipe> lists = recipeService.getAllRecipes();
  // assertTrue(lists.size() >= 0);
  // }
  //
  // @Test
  // public void createRecipe() {
  // List<Ingredient> ingredients = new ArrayList<>();
  // Ingredient ingredient = new Ingredient("680207e38a976e641f7b951b", 34f, "no
  // se", "no se");
  // ingredients.add(ingredient);
  // Recipe recipe = Recipe.builder()
  // .name("sushi")
  // .instructions(" 1. Se debe de comprar el pescado 2. Se debe hacer el arroz ")
  // .ingredients(ingredients)
  // .preparationTime(2000000)
  // .servings(35)
  // .comment("Esto es un producto de japon")
  // .creationDate(LocalDate.now())
  // .estate(Estate.ACTIVE)
  // .build();
  //
  // assertNotNull(recipeService.createRecipe(recipe));
  // }
}
