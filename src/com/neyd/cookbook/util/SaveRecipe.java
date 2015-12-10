package com.neyd.cookbook.util;

import com.neyd.cookbook.Main;
import com.neyd.cookbook.cookbook.CookBook;
import com.neyd.cookbook.cookbook.Recipe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Записування в файл і зчитування з файлу
 * Created by Zheka on 09.12.2015.
 */
public class SaveRecipe {

    public void saveToFile(CookBook cookBook) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("recipe.txt");
        List<Recipe> recipes = cookBook.getRecipes();
        writer.println(cookBook.getRecipes().size());
        for (Recipe entry : recipes) {
            writer.println(entry.getName());
            writer.println(entry.getDescription());
            writer.println(entry.getProductList().size());
            for (int i = 0; i < entry.getProductList().size(); i++) {
                writer.println(entry.getProductList().get(i));
            }
        }
        writer.close();
    }

    public static List<Recipe> loadFromFile() {
        List<Recipe> savedContacts = new ArrayList<Recipe>();
        List<String> products = new ArrayList<String>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("recipe.txt"));
        } catch (FileNotFoundException ignored) {
        }
        int size = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < size; i++) {
            String name = scanner.nextLine();
            String discription = scanner.nextLine();
            int size1 = Integer.parseInt(scanner.nextLine());
            for (int j = 0; j < size1; j++) {
                String product = scanner.nextLine();
                products.add(product);
            }
            String product1;
            String product2;
            String product3;
            String product4;
            switch (size1){
                case 1:
                    product1 = products.get(0);
                    savedContacts.add(
                            new Recipe().setName(name).
                                    setDescription(discription).
                                    addProduct(product1)
                    );
                    break;
                case 2:
                    product1 = products.get(0);
                    product2 = products.get(1);
                    savedContacts.add(
                            new Recipe().setName(name).
                                    setDescription(discription).
                                    addProduct(product1).
                                    addProduct(product2)
                    );
                    break;
                case 3:
                    product1 = products.get(0);
                    product2 = products.get(1);
                    product3 = products.get(2);
                    savedContacts.add(
                            new Recipe().setName(name).
                                    setDescription(discription).
                                    addProduct(product1).
                                    addProduct(product2).
                                    addProduct(product3)
                    );
                    break;
                case 4:
                    product1 = products.get(0);
                    product2 = products.get(1);
                    product3 = products.get(2);
                    product4 = products.get(3);
                    savedContacts.add(
                            new Recipe().setName(name).
                                    setDescription(discription).
                                    addProduct(product1).
                                    addProduct(product2).
                                    addProduct(product3).
                                    addProduct(product4)
                    );
                    products.clear();
                    break;
            }
        }
        return savedContacts;
    }
}
