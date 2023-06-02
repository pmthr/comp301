package com.comp301.a07pizza;

public class IngredientImpl implements Ingredient {
  private final String name;
  private final boolean vegetarian;
  private final boolean vegan;

  public IngredientImpl(String name, boolean vegetarian, boolean vegan) {
    this.name = name;
    this.vegetarian = vegetarian;
    this.vegan = vegan;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean isVegetarian() {
    return vegetarian;
  }

  @Override
  public boolean isVegan() {
    return vegan;
  }
}
