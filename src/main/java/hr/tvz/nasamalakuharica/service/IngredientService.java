package hr.tvz.nasamalakuharica.service;

import hr.tvz.nasamalakuharica.dto.IngredientDto;

import java.util.List;

public interface IngredientService {
    List<IngredientDto> getAllByRecipeId(Long recepyId);

    IngredientDto save(Long recepyId, IngredientDto ingredientDto);

    void delete(Long ingredientId);
}
