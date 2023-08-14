package hr.tvz.nasamalakuharica.repository;

import hr.tvz.nasamalakuharica.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> getAllByRecepy_Id(Long recepyId);
}
