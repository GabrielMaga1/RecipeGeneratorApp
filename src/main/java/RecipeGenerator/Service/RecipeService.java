package RecipeGenerator.Service;

import java.util.*;
import java.util.stream.Collectors;
import RecipeGenerator.Entity.Recipe;
import RecipeGenerator.IService.IRecipeService;
import RecipeGenerator.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService implements IRecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public List<Recipe> getAllRecipes(){
        return recipeRepository.findAll();
    }

    public List<Recipe> findRecipesIdeas(String ingredients){
        List<Recipe> recipes = new ArrayList<>();
        List<String> listIngredients = Arrays.stream(ingredients.split("\\s*,\\s*"))
                .collect(Collectors.toList());
        Collections.sort(listIngredients);
        List<List<String>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (String ingredient : listIngredients) {
            int n = result.size();
            for (int i = 0; i < n; i++) {
                List<String> subList = new ArrayList<>(result.get(i));
                subList.add(ingredient);
                result.add(subList);
                String portion = String.join(", ",subList);
                recipes.addAll(recipeRepository.findByIngredients(portion));
            }
        }
    return recipes;
    }

    @Override
    public void createRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }
    @Override
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }
    @Override
    public Optional<Recipe> findRecipe(Long id) {
       return recipeRepository.findById(id);
    }
}