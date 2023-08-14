package hr.tvz.nasamalakuharica.service;

import hr.tvz.nasamalakuharica.dto.IngredientDto;

import java.util.List;

public interface IngredientService {
    List<IngredientDto> getAllByRecepyId(Long recepyId);

    IngredientDto save(Long recepyId, IngredientDto ingredientDto);
}
