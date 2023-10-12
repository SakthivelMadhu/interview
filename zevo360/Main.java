package zevo360;

import java.util.*;

class CoffeeMachine {
    private final int outlets;
    private final Map<String, Integer> ingredients;
    private final Map<String, Map<String, Integer>> recipes;

    public CoffeeMachine(int outlets, Map<String, Integer> ingredients, Map<String, Map<String, Integer>> recipes) {
        this.outlets = outlets;
        this.ingredients = ingredients;
        this.recipes = recipes;
    }

    // Method to refill a specific ingredient with a certain quantity
    public synchronized void refillIngredient(String ingredient, int quantity) {
        ingredients.put(ingredient, ingredients.getOrDefault(ingredient, 0) + quantity);
    }

    // Method to check if there are enough ingredients for a given recipe
    public synchronized boolean checkIngredients(Map<String, Integer> recipe) {
        for (String ingredient : recipe.keySet()) {
            if (!ingredients.containsKey(ingredient) || ingredients.get(ingredient) < recipe.get(ingredient)) {
                System.out.println("Not enough " + ingredient);
                return false;
            }
        }
        return true;
    }

    // Method to make a beverage
    public synchronized void makeBeverage(String name, Map<String, Integer> recipe) {
        if (checkIngredients(recipe)) {
            System.out.println(name + " is prepared");
            for (String ingredient : recipe.keySet()) {
                ingredients.put(ingredient, ingredients.get(ingredient) - recipe.get(ingredient));
            }
        }
    }

    // Method to serve multiple beverages in parallel
    public synchronized void serveBeverages(List<String> beverageNames) {
        // Check if the number of requested beverages exceeds the available outlets
        if (beverageNames.size() > outlets) {
            System.out.println("Error: Requested beverages exceed available outlets");
            return;
        }

        // Iterate through the requested beverage names
        for (String beverageName : beverageNames) {
            Map<String, Integer> recipe = recipes.get(beverageName);

            // Attempt to make the beverage
            if (checkIngredients(recipe)) {
                makeBeverage(beverageName, recipe);
            } else {
                System.out.println(beverageName + " cannot be prepared");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int outlets = 2;

        Map<String, Integer> initialIngredients = new HashMap<>();
        initialIngredients.put("hot_water", 500);
        initialIngredients.put("hot_milk", 500);
        initialIngredients.put("tea_leaves_syrup", 100);
        initialIngredients.put("ginger_syrup", 100);
        initialIngredients.put("sugar_syrup", 100);

        Map<String, Map<String, Integer>> recipes = new HashMap<>();

	     // Ginger Tea Recipe
	     Map<String, Integer> gingerTeaRecipe = new HashMap<>();
	     gingerTeaRecipe.put("hot_water", 50);
	     gingerTeaRecipe.put("hot_milk", 10);
	     gingerTeaRecipe.put("tea_leaves_syrup", 10);
	     gingerTeaRecipe.put("ginger_syrup", 5);
	     gingerTeaRecipe.put("sugar_syrup", 10);
	     recipes.put("ginger_tea", gingerTeaRecipe);
	
	     // Elaichi Tea Recipe
	     Map<String, Integer> elaichiTeaRecipe = new HashMap<>();
	     elaichiTeaRecipe.put("hot_water", 50);
	     elaichiTeaRecipe.put("hot_milk", 10);
	     elaichiTeaRecipe.put("tea_leaves_syrup", 10);
	     elaichiTeaRecipe.put("elaichi_syrup", 5);
	     elaichiTeaRecipe.put("sugar_syrup", 10);
	     recipes.put("elaichi_tea", elaichiTeaRecipe);
	
	     // Coffee Recipe
	     Map<String, Integer> coffeeRecipe = new HashMap<>();
	     coffeeRecipe.put("hot_water", 50);
	     coffeeRecipe.put("hot_milk", 10);
	     coffeeRecipe.put("coffee_syrup", 10);
	     coffeeRecipe.put("sugar_syrup", 10);
	     recipes.put("coffee", coffeeRecipe);
	
	     // Hot Milk Recipe
	     Map<String, Integer> hotMilkRecipe = new HashMap<>();
	     hotMilkRecipe.put("milk", 50);
	     recipes.put("hot_milk", hotMilkRecipe);
	
	     // Hot Water Recipe
	     Map<String, Integer> hotWaterRecipe = new HashMap<>();
	     hotWaterRecipe.put("water", 50);
	     recipes.put("hot_water", hotWaterRecipe);
	
	     // Black Tea Recipe
	     Map<String, Integer> blackTeaRecipe = new HashMap<>();
	     blackTeaRecipe.put("hot_water", 50);
	     blackTeaRecipe.put("tea_leaves_syrup", 10);
	     blackTeaRecipe.put("sugar_syrup", 10);
	     recipes.put("black_tea", blackTeaRecipe);
	
	     // Green Tea Recipe
	     Map<String, Integer> greenTeaRecipe = new HashMap<>();
	     greenTeaRecipe.put("hot_water", 50);
	     greenTeaRecipe.put("green_mixture", 10);
	     greenTeaRecipe.put("sugar_syrup", 10);
	     recipes.put("green_tea", greenTeaRecipe);
	
	     // Hot Coffee Recipe
	     Map<String, Integer> hotCoffeeRecipe = new HashMap<>();
	     hotCoffeeRecipe.put("hot_water", 50);
	     hotCoffeeRecipe.put("hot_milk", 10);
	     hotCoffeeRecipe.put("coffee_syrup", 10);
	     hotCoffeeRecipe.put("sugar_syrup", 10);
	     recipes.put("hot_coffee", hotCoffeeRecipe);

        CoffeeMachine machine = new CoffeeMachine(outlets, initialIngredients, recipes);

        // Refill ingredients
        machine.refillIngredient("hot_water", 1000);
        machine.refillIngredient("hot_milk", 1000);
        machine.refillIngredient("tea_leaves_syrup", 100);
        machine.refillIngredient("ginger_syrup", 100);
        machine.refillIngredient("sugar_syrup", 100);

        // Serve beverages
        //please put above 5 outlets 
        List<String> requestedBeverages = Arrays.asList("ginger_tea", "elaichi_tea", "coffee", "hot_milk", "hot_water");
        machine.serveBeverages(requestedBeverages);
    }
}
