package com.comp301.a01sushi;

public class CrabPortion extends PorImp {
  static Ingredient Crab = new Crab();

  public CrabPortion(double amount) {
    super(amount, Crab);
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    }
    if (!other.getIngredient().equals(Crab)) {
      throw new IllegalArgumentException("Can't combine portions of different ingredients");
    }
    return new CrabPortion(other.getAmount() + this.getAmount());
  }
}
