package com.comp301.a01sushi;

public class AvocadoPortion extends PorImp {
  static Ingredient Avocado = new Avocado();

  public AvocadoPortion(double amount) {
    super(amount, Avocado);
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    }
    if (!other.getIngredient().equals(Avocado)) {
      throw new IllegalArgumentException("Can't combine portions of different ingredients");
    }
    return new AvocadoPortion(other.getAmount() + this.getAmount());
  }
}
