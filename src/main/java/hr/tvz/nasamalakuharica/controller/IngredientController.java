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

    @GetMapping("/recepy")
    public List<IngredientDto> findIngredientsByRecepyId (@RequestParam Long id) {
        return ingredientService.getAllByRecepyId(id);
    }

    @PostMapping("/save/{recepyId}/")
    public IngredientDto saveIngredient(@PathVariable(value = "recepyId") Long recepyId, @RequestBody IngredientDto ingredientDto) {
        return ingredientService.save(recepyId, ingredientDto);
    }
}
