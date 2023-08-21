package hr.tvz.nasamalakuharica.service;

import hr.tvz.nasamalakuharica.dto.RecipeDto;

import java.util.List;
import java.util.Optional;

public interface RecipeService {

    Optional<RecipeDto> getRecipeById(Long id);

    List<RecipeDto> findAllRecipes();

    List<RecipeDto> findAllByUserId(Long userId);

    Optional<List<RecipeDto>> findByName(String name);

    RecipeDto save(Long userId, RecipeDto recipeDto);

    RecipeDto updateRecipe(Long recipeId, RecipeDto recipeDto);

    void deleteRecipe(Long recipeId);
}
