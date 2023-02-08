package RecipeGenerator.IService;

import RecipeGenerator.Entity.Recipe;

import java.util.List;
import java.util.Optional;

public interface IRecipeService {
    List<Recipe> getAllRecipes();
    void createRecipe(Recipe recipe);
    void deleteRecipe(Long id);
    Optional<Recipe> findRecipe(Long id);
}