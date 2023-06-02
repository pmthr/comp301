package com.comp301.a01sushi;

public class ShrimpPortion extends PorImp {
  static Ingredient Shrimp = new Shrimp();

  public ShrimpPortion(double amount) {
    super(amount, Shrimp);
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    }
    if (!other.getIngredient().equals(Shrimp)) {
      throw new IllegalArgumentException("Can't combine portions of different ingredients");
    }
    return new ShrimpPortion(other.getAmount() + this.getAmount());
  }
}
