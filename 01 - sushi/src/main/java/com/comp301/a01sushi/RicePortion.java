package com.comp301.a01sushi;

public class RicePortion extends PorImp {
  static Ingredient Rice = new Rice();

  public RicePortion(double amount) {
    super(amount, Rice);
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    }
    if (!other.getIngredient().equals(Rice)) {
      throw new IllegalArgumentException("Can't combine portions of different ingredients");
    }
    return new RicePortion(other.getAmount() + this.getAmount());
  }
}
