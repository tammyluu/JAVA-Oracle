package recipes;

import ingredient.Ingredient;

import java.util.List;

public class Recipe {
    private final String name;
    private final List<Ingredient> ingredients;

    public Recipe(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return name + ": " + ingredients;
    }
}
