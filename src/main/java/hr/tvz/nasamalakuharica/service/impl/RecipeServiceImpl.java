package hr.tvz.nasamalakuharica.service.impl;

import hr.tvz.nasamalakuharica.domain.Recipe;
import hr.tvz.nasamalakuharica.domain.User;
import hr.tvz.nasamalakuharica.dto.RecipeDto;
import hr.tvz.nasamalakuharica.repository.RecipeRepository;
import hr.tvz.nasamalakuharica.repository.UserRepository;
import hr.tvz.nasamalakuharica.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    RecipeRepository recipeRepository;
    UserRepository userRepository;

    @Override
    public Optional<RecipeDto> getRecipeById(Long id) {
        return Optional.of(mapToDto(recipeRepository.findById(id).get()));
    }

    @Override
    public List<RecipeDto> findAllRecipes() {
        return recipeRepository.findAll()
                .stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<RecipeDto> findAllByUserId(Long userId) {
        return recipeRepository.findAllByUser_Id(userId)
                .stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public Optional<List<RecipeDto>> findByName(String name) {
        return Optional.of(recipeRepository.findByName(name).get()
                .stream().map(this::mapToDto).collect(Collectors.toList()));
    }

    @Override
    public RecipeDto save(Long userId, RecipeDto recipeDto) {
        Recipe recipe = mapToRecepy(recipeDto);

        User user = userRepository.findById(userId).orElseThrow();

        recipe.setUser(user);

        Recipe newRecipe = recipeRepository.save(recipe);

        return mapToDto(newRecipe);
    }

    private Recipe mapToRecepy (RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        recipe.setId(recipeDto.getId());
        recipe.setName(recipeDto.getName());
        recipe.setPortions(recipeDto.getPortions());
        recipe.setPreparationTimeMinutes(recipeDto.getPreparationTimeMinutes());
        recipe.setInstructions(recipeDto.getInstructions());
        recipe.setDate(recipeDto.getDate());

        return recipe;
    }

    private RecipeDto mapToDto (Recipe recipe) {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setId(recipe.getId());
        recipeDto.setName(recipe.getName());
        recipeDto.setPortions(recipe.getPortions());
        recipeDto.setPreparationTimeMinutes(recipe.getPreparationTimeMinutes());
        recipeDto.setInstructions(recipe.getInstructions());
        recipeDto.setDate(recipe.getDate());

        return recipeDto;
    }
}
