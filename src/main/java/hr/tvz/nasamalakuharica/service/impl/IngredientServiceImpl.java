package hr.tvz.nasamalakuharica.service.impl;

import hr.tvz.nasamalakuharica.domain.Ingredient;
import hr.tvz.nasamalakuharica.domain.Recipe;
import hr.tvz.nasamalakuharica.dto.IngredientDto;
import hr.tvz.nasamalakuharica.repository.IngredientRepository;
import hr.tvz.nasamalakuharica.repository.RecipeRepository;
import hr.tvz.nasamalakuharica.service.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    IngredientRepository ingredientRepository;
    RecipeRepository recipeRepository;

    @Override
    public List<IngredientDto> getAllByRecipeId(Long recepyId) {
        return ingredientRepository.getAllByRecipe_Id(recepyId)
                .stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public IngredientDto save(Long recepyId, IngredientDto ingredientDto) {
        Ingredient ingredient = mapToIngredient(ingredientDto);

        Recipe recipe = recipeRepository.findById(recepyId).orElseThrow();

        ingredient.setRecepy(recipe);

        Ingredient newIngredient = ingredientRepository.save(ingredient);

        return mapToDto(newIngredient);
    }

    private Ingredient mapToIngredient(IngredientDto ingredientDto){
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredientDto.getId());
        ingredient.setName(ingredientDto.getName());
        ingredient.setAmount(ingredientDto.getAmount());
        ingredient.setUnit(ingredientDto.getUnit());

        return ingredient;
    }

    private IngredientDto mapToDto(Ingredient ingredient){
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setId(ingredient.getId());
        ingredientDto.setName(ingredient.getName());
        ingredientDto.setAmount(ingredient.getAmount());
        ingredientDto.setUnit(ingredient.getUnit());

        return ingredientDto;
    }
}
