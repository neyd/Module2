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

/**
 * Created by Zheka on 08.12.2015.
 */
public class Main {
    private static Scanner scanner;
    private static CookBook cookBook;


    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        cookBook = new CookBook();
        cookBook.loadRecipes();
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
            }catch (NumberFormatException e){
                System.out.println("Ви ввели неправильне число");
            }
            switch (choice){
                case 1:
                    showAll();
                    break;
                case 2:
                    searchRecipe();
                    break;
                case 3:
                    addRecipe();
                    break;
                case 4:
                    deleteRecipe();
                    break;
                case 5:
                    saveAndExit();
                    return;
            }
        }
    }

    private static void showAll(){
        List<Recipe> recipes = cookBook.getRecipes();
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        for (Recipe entry : recipes) {
            count++;
            System.out.println(count + "." + entry.getName());
        }
        count = 0;
        int resp = 0;
        try{
            resp = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Ви ввели неправильне число");
        }

        for (int i = 0; i < recipes.size(); i++) {
            if (resp == i+1) {
                System.out.println(recipes.get(i));
            }
        }
        scanner.nextLine();
    }
    private static void searchRecipe(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("По скількох продуктах будете шукати? (5)");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                searchByOneProducts();
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
            case 5:
                searchByFiveProducts();
                break;
        }

    }
    private static void addRecipe(){
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
        cookBook.addRecipes(
                new Recipe().setName(name).setDescription(discription).addProduct(product1).addProduct(product2).addProduct(product3)
        );

//                System.out.println("Четвертий");
//                String product4 = scanner.nextLine();
//                System.out.println("П'ятий");
//                String product5 = scanner.nextLine();
//                cookBook.addRecipeWithFiveProduct(name,discription,product1,product2,product3,product4,product5);
    }
    private static void deleteRecipe(){
        List<Recipe> recipes = cookBook.getRecipes();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Що хочете видалити?");
        for (int i = 0; i < recipes.size(); i++) {
            System.out.println(i + 1);
            System.out.println(recipes.get(i));
        }
        int resp = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < recipes.size(); i++) {
            if (resp == i + 1) {
                cookBook.deleteRecipe(recipes.get(i));
            }
        }
        recipes = cookBook.getRecipes();
    }
    private static void saveAndExit() throws FileNotFoundException {
        SaveRecipe saveRecipe = new SaveRecipe();
        System.out.println("Допобачення");
        saveRecipe = new SaveRecipe();
        saveRecipe.saveToFile(cookBook);
    }

    private static void searchByOneProducts(){
        int resp = 0;
        for (int i = 0; i < RecipeGenerator.product.length; i++) {
            System.out.println((i + 1) + "." + RecipeGenerator.product[i]);
        }
        Scanner scanner = new Scanner(System.in);
        try {
            resp = Integer.parseInt(scanner.nextLine());
        }catch(NumberFormatException e){
            System.out.println("Ви ввели неправильне число");
        }
        for (int i = 0; i < RecipeGenerator.product.length; i++) {
            if (resp == i + 1) {
                System.out.println(cookBook.getByProduct(RecipeGenerator.product[resp-1]));
            }
        }
        scanner.nextLine();
    }
    public static void searchByTwoProducts(){
        int resp = 0;
        int resp2 = 0;
        boolean one = false;
        for (int i = 0; i < RecipeGenerator.product.length; i++) {
            System.out.println((i + 1) + "." + RecipeGenerator.product[i]);
        }
        Scanner scanner = new Scanner(System.in);
        try {
            resp = Integer.parseInt(scanner.nextLine());
            resp2 = Integer.parseInt(scanner.nextLine());
        }catch(NumberFormatException e){
            System.out.println("Ви ввели неправильне число");
        }
        for (int i = 0; i < RecipeGenerator.product.length; i++) {
            if (resp == i + 1) {
                one = true;
            }
            if (resp2 == i + 1 && one){
                System.out.println(cookBook.getByTwoProduct(RecipeGenerator.product[resp-1],RecipeGenerator.product[resp2-1]));
            }
            one = false;
        }
        scanner.nextLine();
    }
    public static void searchByTreeProducts(){

    }
    public static void searchByFourProducts(){

    }
    public static void searchByFiveProducts(){

    }
}
