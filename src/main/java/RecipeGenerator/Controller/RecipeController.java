package RecipeGenerator.Controller;

import RecipeGenerator.Entity.Recipe;
import RecipeGenerator.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecipeController {
    @Autowired
    private RecipeService recipeService;


    @GetMapping(path = "/recipes-list")
    public String getRecipes(Model model){
        model.addAttribute("recipe", recipeService.getAllRecipes());
        return "recipes-list";
    }
    @RequestMapping(value = "/ingredients")
    public String recipesIdeas(@RequestParam (value = "ingredients", required = false)String ingredients, Model model){
        model.addAttribute("recipe", recipeService.findRecipesIdeas(ingredients));
        System.out.println(ingredients);
        return  "ingredients";
    }
    @GetMapping(path = "/recipes-list/new-recipe")
    public String newRecipe(Model model){
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        return "new-recipe";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveRecipe(@ModelAttribute("recipe") Recipe recipe){
        recipeService.createRecipe(recipe);
        return "redirect:/recipes-list";
    }


    @GetMapping(path = "/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return "redirect:/recipes-list";
    }
    @GetMapping(path = "/edit-post/{id}")
    public String editRecipe(@PathVariable Long id, Model model){
        model.addAttribute("recipe", recipeService.findRecipe(id));
        return "edit-post";
    }
}