package RecipeGenerator.Repository;

import RecipeGenerator.Entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {
    List<Recipe> findByIngredients(String ingredients);

    List<Recipe> findByName(String ingredients);
}
