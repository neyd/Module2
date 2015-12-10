package com.neyd.cookbook;

import com.neyd.cookbook.cookbook.CookBook;
import com.neyd.cookbook.cookbook.Recipe;
import com.neyd.cookbook.util.RecipeGenerator;
import com.neyd.cookbook.util.SaveRecipe;

import javax.print.DocFlavor;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**клас Мейн
 * Created by Zheka on 08.12.2015.
 */
public class Main {
    private static CookBook cookBook;


    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        cookBook = new CookBook();
        LoadingScreen();

        System.out.println("Вітаю тебе у кулінарній книзі\n" +
                "------------------\n");
        while (true) {
            System.out.println(
                    "1.Подивитися всі рецепти\n" +
                            "2.Пощук по продукту\n" +
                            "3.Додати рецепти\n" +
                            "4.Видалити рецепти\n" +
                            "5 Вийти");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ви ввели неправильне число");
                System.out.println();
            }
            switch (choice) {
                case 1:
                    ShowAll();
                    break;
                case 2:
                    SearchRecipe();
                    break;
                case 3:
                    AddRecipe();
                    break;
                case 4:
                    DeleteRecipe();
                    break;
                case 5:
                    SaveAndExit();
                    return;
            }
        }
    }

    private static void LoadingScreen() {
        Scanner scanner = new Scanner(System.in);
        boolean s = false;
        System.out.println("1.Загрузити файл 'recipe.txt'");
        System.out.println("2.Згенерувати рецепти");
        int choice = 0;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ви ввели неправильне число");
            System.out.println();
        }
        switch (choice) {
            case 1:
                cookBook.loadRecipesWithFile();
                break;
            case 2:
                System.out.println("Скільки хочете сгенерувати рецептів?" + " (" + RecipeGenerator.nameOfRecipe.length + ")");
                int count = 0;
                try{
                    count = Integer.parseInt(scanner.nextLine());
                }catch (NumberFormatException e){
                    System.out.println("Ви ввели неправильне число");
                }
                cookBook.loadRecipesWithGenerator(count);
                System.out.println(RecipeGenerator.nameOfRecipe.length + " рецептів згенеровано");
                break;
        }
    }

    private static void ShowAll() {
        List<Recipe> recipes = cookBook.getRecipes();
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        for (Recipe entry : recipes) {
            count++;
            System.out.println(count + "." + entry.getName());
        }
        count = 0;
        int resp = 0;
        try {
            resp = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ви ввели неправильне число");
            System.out.println();
        }

        for (int i = 0; i < recipes.size(); i++) {
            if (resp == i + 1) {
                System.out.println(recipes.get(i));
            }
        }
        scanner.nextLine();
    }

    private static void SearchRecipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("По скількох продуктах будете шукати? (4)");
        int choice = 0;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ви ввели неправильне число");
            System.out.println();
        }
        switch (choice) {
            case 1:
                searchByOneProduct();
                break;
            case 2:
                searchByTwoProducts();
                break;
            case 3:
                searchByTreeProducts();
                break;
            case 4:
                searchByFourProducts();
                break;
        }

    }

    private static void AddRecipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву рецепту");
        String name = scanner.nextLine();
        System.out.println("Напишіть опис");
        String discription = scanner.nextLine();
        System.out.println("Введіть продукти");
        System.out.println("Перший");
        String product1 = scanner.nextLine();
        System.out.println("Другий");
        String product2 = scanner.nextLine();
        System.out.println("Третій");
        String product3 = scanner.nextLine();
        System.out.println("Четвертий");
        String product4 = scanner.nextLine();
        cookBook.addRecipes(
                new Recipe().setName(name).
                        setDescription(discription).
                        addProduct(product1).
                        addProduct(product2).
                        addProduct(product3).
                        addProduct(product4)
        );
    }

    private static void DeleteRecipe() {
        List<Recipe> recipes = cookBook.getRecipes();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Що хочете видалити?");
        int count = 0;
        for (Recipe entry : recipes) {
            count++;
            System.out.println(count + "." + entry.getName());
        }
        count = 0;
        int resp = 0;
        try {
            resp = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ви ввели неправильне число");
            System.out.println();
        }
        for (int i = 0; i < recipes.size(); i++) {
            if (resp == i + 1) {
                cookBook.deleteRecipe(recipes.get(i));
            }
        }
        recipes = cookBook.getRecipes();
    }

    private static void SaveAndExit() throws FileNotFoundException {
        SaveRecipe saveRecipe;
        System.out.println("Допобачення");
        saveRecipe = new SaveRecipe();
        saveRecipe.saveToFile(cookBook);
    }

    private static void searchByOneProduct() {
        int product = 0;
        for (int i = 0; i < RecipeGenerator.product.length; i++) {
            System.out.println((i + 1) + "." + RecipeGenerator.product[i]);
        }
        Scanner scanner = new Scanner(System.in);
        try {
            product = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ви ввели неправильне число");
        }
        if (cookBook.getByProduct(RecipeGenerator.product[product - 1]).isEmpty()){
            System.out.println("Нічого не знайдено");
        }
        else {
            System.out.println(cookBook.getByProduct(RecipeGenerator.product[product - 1]));
        }
        scanner.nextLine();
    }

    public static void searchByTwoProducts() {
        int product1 = 0;
        int product2 = 0;
        for (int i = 0; i < RecipeGenerator.product.length; i++) {
            System.out.println((i + 1) + "." + RecipeGenerator.product[i]);
        }
        Scanner scanner = new Scanner(System.in);
        try {
            product1 = Integer.parseInt(scanner.nextLine());
            product2 = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ви ввели неправильне число");
        }
        if (cookBook.getByTwoProduct(RecipeGenerator.product[product1 - 1], RecipeGenerator.product[product2 - 1]).isEmpty()){
            System.out.println("Нічого не знайдено");
        }else {
            System.out.println(cookBook.getByTwoProduct(RecipeGenerator.product[product1 - 1], RecipeGenerator.product[product2 - 1]));
        }
        scanner.nextLine();
    }

    public static void searchByTreeProducts() {
        int product1 = 0;
        int product2 = 0;
        int product3 = 0;
        for (int i = 0; i < RecipeGenerator.product.length; i++) {
            System.out.println((i + 1) + "." + RecipeGenerator.product[i]);
        }
        Scanner scanner = new Scanner(System.in);
        try {
            product1 = Integer.parseInt(scanner.nextLine());
            product2 = Integer.parseInt(scanner.nextLine());
            product3 = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ви ввели неправильне число");
        }
        if (cookBook.getByTreeProduct(RecipeGenerator.product[product1 - 1], RecipeGenerator.product[product2 - 1], RecipeGenerator.product[product3 - 1]).isEmpty()){
            System.out.println("Нічого не знайдено");
        }else {
            System.out.println(cookBook.getByTreeProduct(RecipeGenerator.product[product1 - 1], RecipeGenerator.product[product2 - 1], RecipeGenerator.product[product3 - 1]));
        }
        scanner.nextLine();
    }

    public static void searchByFourProducts() {
        int product1 = 0;
        int product2 = 0;
        int product3 = 0;
        int product4 = 0;
        for (int i = 0; i < RecipeGenerator.product.length; i++) {
            System.out.println((i + 1) + "." + RecipeGenerator.product[i]);
        }
        Scanner scanner = new Scanner(System.in);
        try {
            product1 = Integer.parseInt(scanner.nextLine());
            product2 = Integer.parseInt(scanner.nextLine());
            product3 = Integer.parseInt(scanner.nextLine());
            product4 = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ви ввели неправильне число");
        }
        if (cookBook.getByFourProduct(RecipeGenerator.product[product1 - 1], RecipeGenerator.product[product2 - 1], RecipeGenerator.product[product3 - 1], RecipeGenerator.product[product4 - 1]).isEmpty()){
            System.out.println("Нічого не знайдено");
        } else {
            System.out.println(cookBook.getByFourProduct(RecipeGenerator.product[product1 - 1], RecipeGenerator.product[product2 - 1], RecipeGenerator.product[product3 - 1], RecipeGenerator.product[product4 - 1]));
        }
        scanner.nextLine();
    }
}
