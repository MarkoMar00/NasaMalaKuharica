package hr.tvz.nasamalakuharica.controller;

import hr.tvz.nasamalakuharica.dto.RecipeDto;
import hr.tvz.nasamalakuharica.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("recipe")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class RecipeController {

    RecipeService recipeService;

    @GetMapping("/")
    public ResponseEntity<RecipeDto> findRecepyById(@RequestParam Long id) {
        return recipeService.getRecipeById(id)
                .map(
                        recipeDto -> ResponseEntity.status(HttpStatus.OK).body(recipeDto)
                ).orElseGet(
                        () -> ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                );
    }

    @GetMapping("/all")
    public List<RecipeDto> findAllRecepies() {
        return recipeService.findAllRecipes();
    }

    @GetMapping("/user")
    public List<RecipeDto> findRecepiesbyUserId (@RequestParam Long id) {
        return recipeService.findAllByUserId(id);
    }

    @GetMapping("/name")
    public ResponseEntity<List<RecipeDto>> findRecepiesByName(@RequestParam String name) {
        return recipeService.findByName(name)
                .map(
                        recepies -> ResponseEntity.status(HttpStatus.OK).body(recepies)
                ).orElseGet(
                        () -> ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                );
    }

    @PostMapping("/save/{userId}/")
    public RecipeDto save(@PathVariable(value = "userId") Long userId, @RequestBody RecipeDto recipeDto) {
        return recipeService.save(userId, recipeDto);
    }


}
