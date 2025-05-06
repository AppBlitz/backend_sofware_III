package com.restaurant.controller.implementation.recipe;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.controller.Interface.recipe.RecipeControllerInterface;
import com.restaurant.dto.employee.EmployeeDTO;
import com.restaurant.dto.recipe.RecipeDtoAdd;
import com.restaurant.dto.recipe.RecipeDtoUpdate;
import com.restaurant.model.Enum.Estate;
import com.restaurant.model.document.Employee;
import com.restaurant.model.document.Recipe;
import com.restaurant.model.vo.HistoryRecipe;
import com.restaurant.service.implementation.employees.EmployeeServices;
import com.restaurant.service.implementation.inventory.RecipeServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController implements RecipeControllerInterface {

    @Autowired
    private RecipeServices recipeServices;

    @Autowired
    private EmployeeServices employeeServices;

    @Override
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Recipe> createRecipe(@Valid @RequestBody RecipeDtoAdd recipeDtoAdd) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeDtoAdd.name());
        recipe.setIngredients(recipeDtoAdd.ingredients());
        recipe.setInstructions(recipeDtoAdd.instructions());
        recipe.setPreparationTime(recipeDtoAdd.preparationTime());
        recipe.setServings(recipeDtoAdd.servings());
        recipe.setComment(recipeDtoAdd.comment());
        recipe.setCreationDate(recipeDtoAdd.creationDate());
        recipe.setEstate(Estate.ACTIVE);
        recipe.setPrice(recipeServices.calculatePrice(recipeDtoAdd.ingredients()));
        Recipe newRecipe = recipeServices.createRecipe(recipe);
        return ResponseEntity.status(200).body(newRecipe);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Recipe> getRecipeById(@PathVariable String id) {
        Recipe recipe = recipeServices.getRecipeById(id);
        if (recipe != null) {
            return ResponseEntity.ok(recipe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> recipes = recipeServices.getAllRecipes();
        return ResponseEntity.ok(recipes);
    }

    @Override
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Recipe> updateRecipe(@PathVariable("id") String id,
            @Valid @RequestBody RecipeDtoUpdate recipeDtoUpdate) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeDtoUpdate.name());
        recipe.setIngredients(recipeDtoUpdate.ingredients());
        recipe.setInstructions(String.valueOf(recipeDtoUpdate.instructions()));
        recipe.setPreparationTime(recipeDtoUpdate.preparationTime());
        recipe.setServings(recipeDtoUpdate.servings());
        recipe.setComment(recipeDtoUpdate.comment());
        recipe.setCreationDate(LocalDate.from(recipeDtoUpdate.creationDate()));
        recipe.setEstate(recipeDtoUpdate.recipeStatus());
        Recipe updatedRecipe = recipeServices.updateRecipe(recipeDtoUpdate);
        if (updatedRecipe != null) {
            return ResponseEntity.ok(updatedRecipe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteRecipe(@PathVariable String id) {
        recipeServices.deleteRecipe(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/movementByDate", method = RequestMethod.GET)
    public ResponseEntity<List<HistoryRecipe>> getByDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<HistoryRecipe> results = recipeServices.consult_movementsByDate(date);
        return ResponseEntity.ok(results);
    }

    @RequestMapping(value = "/movementByRangeHour", method = RequestMethod.GET)
    public ResponseEntity<List<HistoryRecipe>> getByHour(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam int startHour,
            @RequestParam int endHour) {
        List<HistoryRecipe> results = recipeServices.consult_movementsByHour(date, startHour, endHour);
        return ResponseEntity.ok(results);
    }

    @RequestMapping(value = "/historyEmployee", method = RequestMethod.GET)
    public ResponseEntity<List<HistoryRecipe>> getHistoryByEmployeeAndDate(
            @RequestParam String employeeId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        DayOfWeek dayOfWeek = date.getDayOfWeek(); // Ej: MONDAY
        Employee.Day diaSemana = Employee.Day.valueOf(dayOfWeek.name()); // Convertir a tu enum

        EmployeeDTO empleado = employeeServices.get(employeeId);
        Map<Employee.Day, Employee.Hours> horarios = empleado.schedule();

        if (!horarios.containsKey(diaSemana)) {
            return ResponseEntity.ok(Collections.emptyList()); // No trabajó ese día
        }

        Employee.Hours horario = horarios.get(diaSemana);

        List<HistoryRecipe> actividades = recipeServices.consult_movementsByHour(
                date, horario.getHourStart(), horario.getHourEnd());

        return ResponseEntity.ok(actividades);
    }

    @RequestMapping(value = "/getServings/{id}", method = RequestMethod.GET)
    public ResponseEntity<Integer> MaxQuantity(@PathVariable String id){
        int servings =recipeServices.getServings(id);

        return ResponseEntity.ok(servings);
    }

}
