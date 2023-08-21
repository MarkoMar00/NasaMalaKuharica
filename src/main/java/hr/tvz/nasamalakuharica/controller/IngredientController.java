package hr.tvz.nasamalakuharica.controller;

import hr.tvz.nasamalakuharica.dto.IngredientDto;
import hr.tvz.nasamalakuharica.service.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ingredient")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class IngredientController {

    IngredientService ingredientService;

    @GetMapping("/recipe")
    public List<IngredientDto> findIngredientsByRecipeId(@RequestParam Long id) {
        return ingredientService.getAllByRecipeId(id);
    }

    @PostMapping("/save/{recipeId}/")
    public IngredientDto saveIngredient(@PathVariable(value = "recipeId") Long recipeId, @RequestBody IngredientDto ingredientDto) {
        return ingredientService.save(recipeId, ingredientDto);
    }

    @DeleteMapping("/delete/{ingredientId}")
    public void deleteIngredient(@PathVariable(value = "ingredientId") Long ingredientId) {
        ingredientService.delete(ingredientId);
    }
}
