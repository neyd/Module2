package com.neyd.cookbook.cookbook;

import java.util.*;

/**
 * клас рецептів
 * Created by Zheka on 08.12.2015.
 */
public class Recipe {
    int id;
    private String name;
    private String description;
    private Set<String> products = new HashSet<String>();

    @Override
    public String toString() {
        return "--------------\n" +
                "Рецепт: " + name + "\n" +
                description + "\n" +
                "Продукти які потрібні для приготування" + "\n" +
                products + "\n" +
                "---------------";
    }

    public int getId() {
        return id;
    }

    public Set<String> getProduct() {
        return products;
    }

    public String getName() {
        return name;
    }

    public Recipe setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Recipe setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<String> getProductList() {
        List<String> sorted = new ArrayList<String>(products);
        return sorted;
    }

    public Recipe addProduct(String product) {
        products.add(product);
        return this;
    }
}
