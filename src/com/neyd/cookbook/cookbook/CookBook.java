package com.neyd.cookbook.cookbook;

import com.neyd.cookbook.util.RecipeGenerator;
import com.neyd.cookbook.util.SaveRecipe;
import java.util.*;

/**
 * Кулінарна книга
 * Created by Zheka on 08.12.2015.
 */
public class CookBook {
    private List<Recipe> recipes;
    private List<Recipe> recipeList;
    private int lastId = 0;

    public void loadRecipesWithFile() {
        recipes = SaveRecipe.loadFromFile();

    }

    public void loadRecipesWithGenerator(int count) {
        recipes = RecipeGenerator.fillCookBook(count);
    }

    public List<Recipe> getRecipes() {
        if (recipeList == null) {
            recipeList = new ArrayList<Recipe>(recipes);
        }
        return recipes;
    }

    public boolean deleteRecipe(Recipe recipe) {
        recipeList = null;
        return recipes.remove(recipe);
    }

    public boolean addRecipes(Recipe recipe) {
        recipeList = null;
        recipe.id = lastId++;
        return recipes.add(recipe);
    }

    public List<Recipe> getByProduct(String product) {
        List<Recipe> filteredList = new ArrayList<Recipe>();
        for (Recipe recipe : recipes) {
            if (recipe.getProduct().contains(product)) {
                filteredList.add(recipe);
            }
        }
        return filteredList;
    }

    public List<Recipe> getByTwoProduct(String product1, String product2) {
        List<Recipe> filteredList = new ArrayList<Recipe>();
        for (Recipe recipe : recipes) {
            if (recipe.getProduct().contains(product1) && recipe.getProduct().contains(product2)) {
                filteredList.add(recipe);
            }
        }
        return filteredList;
    }

    public List<Recipe> getByTreeProduct(String product1, String product2, String product3) {
        List<Recipe> filteredList = new ArrayList<Recipe>();
        for (Recipe recipe : recipes) {
            if (recipe.getProduct().contains(product1) && recipe.getProduct().contains(product2) && recipe.getProduct().contains(product3)) {
                filteredList.add(recipe);
            }
        }
        return filteredList;
    }

    public List<Recipe> getByFourProduct(String product1, String product2, String product3, String product4) {
        List<Recipe> filteredList = new ArrayList<Recipe>();
        for (Recipe recipe : recipes) {
            if (recipe.getProduct().contains(product1) && recipe.getProduct().contains(product2) && recipe.getProduct().contains(product3) && recipe.getProduct().contains(product4)) {
                filteredList.add(recipe);
            }
        }
        return filteredList;
    }


}
