package com.comp301.a01sushi;

public abstract class PorImp implements IngredientPortion {
  private final double amount;
  private final Ingredient ing;

  public PorImp(double amount, Ingredient ing) {
    if (amount < 0.0) {
      throw new RuntimeException("Portion must be greater than 0");
    }
    this.amount = amount;
    this.ing = ing;
  }

  @Override
  public Ingredient getIngredient() {
    return ing;
  }

  @Override
  public double getAmount() {
    return amount;
  }

  @Override
  public String getName() {
    return ing.getName();
  }

  @Override
  public boolean getIsVegetarian() {
    return ing.getIsVegetarian();
  }

  @Override
  public boolean getIsRice() {
    return ing.getIsRice();
  }

  @Override
  public boolean getIsShellfish() {
    return ing.getIsShellfish();
  }

  @Override
  public double getCalories() {
    return amount * ing.getCaloriesPerOunce();
  }

  @Override
  public double getCost() {
    return amount * ing.getPricePerOunce();
  }

  public abstract IngredientPortion combine(IngredientPortion other);
}
