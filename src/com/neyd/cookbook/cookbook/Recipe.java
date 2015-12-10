package com.neyd.cookbook.cookbook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * клас рецептів
 * Created by Zheka on 08.12.2015.
 */
public class Recipe {
    int id;
    private String name;
    private String description;
    private List<String> products = new ArrayList<String>();

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
        Set<String> sorted = new HashSet<String>();
        for (String product : products) {
            sorted.add(product);
        }
        return sorted;
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
        return products;
    }

    public Recipe addProduct(String product) {
        products.add(product);
        return this;
    }
}
