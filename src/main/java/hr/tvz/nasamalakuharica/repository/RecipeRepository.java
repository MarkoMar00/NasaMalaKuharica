package hr.tvz.nasamalakuharica.repository;

import hr.tvz.nasamalakuharica.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findAllByUser_Id(Long userId);

    Optional<List<Recipe>> findByName(String name);
}
