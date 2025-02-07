package recipes;

import java.util.ArrayList;
import java.util.List;

public class RecipeManager {
    private final List<Recipe> recipes = new ArrayList<>();


    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
}
