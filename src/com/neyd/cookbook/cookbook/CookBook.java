package com.neyd.cookbook.cookbook;

import com.neyd.cookbook.util.RecipeGenerator;
import com.neyd.cookbook.util.SaveRecipe;
import com.sun.istack.internal.NotNull;
import com.sun.org.apache.bcel.internal.generic.LUSHR;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Zheka on 08.12.2015.
 */
public class CookBook {
    private CookBook cookBook;
    private SaveRecipe saveRecipe;
    private List<Recipe> recipes;
    private List<Recipe> recipeList;
    private Recipe recipe = new Recipe();

    public void loadRecipes() throws FileNotFoundException {
        recipes = RecipeGenerator.fillCookBook();
    }
    public List<Recipe> getRecipes() {
        if (recipeList == null) {
            recipeList = new ArrayList<Recipe>(recipes);
        }
        return recipeList;
    }

    public boolean deleteRecipe(Recipe recipe) {
        recipeList = null;
        return recipes.remove(recipe);
    }

    public boolean addRecipes(Recipe recipe) {
        recipeList = null;
        return recipes.add(recipe);
    }

    public void addRecipeWithFiveProduct(String name, String description, String product1, String product2, String product3, String product4, String product5) {
        recipes.add(
        new Recipe().setName(name).
                        setDescription(description).
                        addProduct(product1).
                        addProduct(product2).
                        addProduct(product3).
                        addProduct(product4).
                        addProduct(product5)
        );
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
        for (Recipe recipe : filteredList) {
            if (recipe.getProduct().contains(product1) && recipe.getProduct().contains(product2)) {
                recipeList.add(recipe);
            }
        }
        return filteredList;
    }
}
