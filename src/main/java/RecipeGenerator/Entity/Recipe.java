package RecipeGenerator.Entity;

import jakarta.persistence.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "recipesDB")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String text;
    @OrderBy("ingredients ASC")
    private String ingredients;

    public Recipe(String name, String text, String ingredients) {
        this.name = name;
        this.text = text;
        List<String> listIngredients = Arrays.stream(ingredients.split("\\s*,\\s*"))
                .collect(Collectors.toList());
        Collections.sort(listIngredients);
        String ingredientsOrder = String.join(", ",listIngredients);
        this.ingredients = ingredientsOrder;
    }
    public Recipe(){

    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        List<String> listIngredients = Arrays.stream(ingredients.split("\\s*,\\s*"))
                .collect(Collectors.toList());
        Collections.sort(listIngredients);
        String ingredientsOrder = String.join(", ",listIngredients);
        this.ingredients = ingredientsOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}