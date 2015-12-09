package com.neyd.cookbook.util;

import com.neyd.cookbook.Main;
import com.neyd.cookbook.cookbook.CookBook;
import com.neyd.cookbook.cookbook.Recipe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Zheka on 09.12.2015.
 */
public class SaveRecipe {
    public void saveToFile(CookBook cookBook) throws FileNotFoundException {
        List<Recipe> recipeList = cookBook.getRecipes();
        PrintWriter writer = new PrintWriter("recipe.txt");

        writer.println(cookBook.getRecipes().size());
        for (Recipe entry : recipeList) {
            writer.println(entry.getName());
            writer.println(entry.getDescription());
            writer.println(entry.getProduct());
        }

        writer.close();
    }


    public List<Recipe> loadFromFile() throws FileNotFoundException {
        CookBook cookBook = new CookBook();
        List<Recipe> savedRecipes = new ArrayList<Recipe>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("recipe.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int size = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < size; i++) {
            String name = scanner.nextLine();
            String discription = scanner.nextLine();
            String product = scanner.nextLine();
            cookBook.addRecipes(
                    new Recipe().setName(name).
                            setDescription(discription).
                            addProduct(product)
            );
            savedRecipes.add(
                    new Recipe().setName(name).
                            setDescription(discription).
                            addProduct(product)
            );
        }return savedRecipes;
    }
}
