package com.comp301.a07pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaFactory {
  public static Pizza makeCheesePizza(Pizza.Size size) {
    return new PizzaImpl(size, Crust.HAND_TOSSED, Sauce.TOMATO, Cheese.BLEND, new ArrayList<>());
  }

  public static Pizza makeHawaiianPizza(Pizza.Size size) {
    List<Ingredient> toppings = new ArrayList<>();
    toppings.add(Topping.HAM);
    toppings.add(Topping.PINEAPPLE);
    return new PizzaImpl(size, Crust.HAND_TOSSED, Sauce.TOMATO, Cheese.BLEND, toppings);
  }

  public static Pizza makeMeatLoversPizza(Pizza.Size size) {
    List<Ingredient> toppings = new ArrayList<>();
    toppings.add(Topping.PEPPERONI);
    toppings.add(Topping.SAUSAGE);
    toppings.add(Topping.BACON);
    toppings.add(Topping.GROUND_BEEF);
    return new PizzaImpl(size, Crust.DEEP_DISH, Sauce.TOMATO, Cheese.BLEND, toppings);
  }

  public static Pizza makeVeggieSupremePizza(Pizza.Size size) {
    List<Ingredient> toppings = new ArrayList<>();
    toppings.add(Topping.SUN_DRIED_TOMATO);
    toppings.add(Topping.GREEN_PEPPER);
    toppings.add(Topping.MUSHROOMS);
    toppings.add(Topping.OLIVES);
    return new PizzaImpl(size, Crust.THIN, Sauce.TOMATO, Cheese.BLEND, toppings);
  }

  public static Pizza makeDailySpecialPizza() {
    List<Ingredient> toppings = new ArrayList<>();
    toppings.add(Topping.MUSHROOMS);
    toppings.add(Topping.PEPPERONI);
    toppings.add(Topping.PINEAPPLE);
    toppings.add(Topping.SUN_DRIED_TOMATO);
    return new PizzaImpl(
        Pizza.Size.MEDIUM, Crust.HAND_TOSSED, Sauce.TOMATO, Cheese.BLEND, toppings);
  }
}
