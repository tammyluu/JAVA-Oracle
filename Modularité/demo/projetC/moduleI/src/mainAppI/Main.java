package mainAppI;



import ingredient.Ingredient;
import recipes.Recipe;
import recipes.RecipeManager;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Ingredient flour = new Ingredient("Flour");
        Ingredient sugar = new Ingredient("Sugar");
        Ingredient butter = new Ingredient("Butter");

        Recipe cake = new Recipe("Cake", Arrays.asList(flour, sugar, butter));

        RecipeManager manager = new RecipeManager();
        manager.addRecipe(cake);

        System.out.println("Recipes:");
        for (Recipe recipe : manager.getRecipes()) {
            System.out.println(recipe);
        }
    }
}