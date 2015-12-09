package com.neyd.cookbook.util;

import com.neyd.cookbook.cookbook.CookBook;
import com.neyd.cookbook.cookbook.Recipe;

import java.util.*;

/**
 * Created by Zheka on 08.12.2015.
 */
public class RecipeGenerator {
    public static String[] nameOfRecipe = {
            "Тонкі млинці на сироватці",
            "Рулет із лаваша з сирною начинкою",
            "Салат з капусти з куркою і яєчними млинцями",
            "Салат з квасолею та печінкою",
            "Лінива шуба"
    };

    public static String[] description = {
            "Навіть при нетривалому зберіганні смак смаженого м’яса погіршується, тому смажити його слід незадовго до подавання. Перш ніж розігрівати на жиру вчорашнє смажене м’ясо, збризніть його трохи холодною водою. М’ясо збереже смак свіжо зажареного.",
            "Як визначити, чи добре просмажилось м’ясо? Добре просмажене м’ясо має рівномірне коричневе забарвлення і при натискуванні виділяє безбарвний сік.",
            "М’ясо при смаженні добре підрум’яниться, коли його обсушити на серветці.Для поліпшення смаку тушкованого м’яса використовують цибулю, моркву, петрушку. Загальна кількість приправ — не менш як 100 г на 1 кг м’яса.",
            "Хочете, щоб смажене м’ясо було соковитим? В такому разі перед подаею до столу чверть години потримайте його над каструлею з киплячою водою.",
            "М’ясо птиці буде ніжним і швидше звариться, якщо у воду влити столову ложку оцту.Кладіть котлети та шматки м’яса на добре розігріту з жиром сковороду, тоді сік не витікатиме з них."


    };

    public static String[] product = {
            "Яйця",
            "Буряк",
            "Цибуля",
            "Майонез",
            "Огірки",
            "Морква",
            "Квасоля",
            "Молоко",
            "Куряче філе",
            "Капуста",
            "Сир",
            "Часник",
            "Цукор",
            "Сіль",
            "Борошно",
            "Олія",
            "Перець",
            "Вода"

    };

    public RecipeGenerator() {
    }

    public static List<Recipe> fillCookBook() {
        Random random = new Random();
        List<Recipe> recipes = new ArrayList<Recipe>();
        for (int i = 0; i < nameOfRecipe.length; i++) {
            recipes.add(
                   new Recipe().setName(nameOfRecipe[i]).
                            setDescription(description[i]).
                            addProduct(product[random.nextInt(product.length)]).
                            addProduct(product[random.nextInt(product.length)]).
                            addProduct(product[random.nextInt(product.length)]).
                            addProduct(product[random.nextInt(product.length)])
            );
        }
        return recipes;
    }
}
