package com.comp301.a01sushi;

public class YellowtailPortion extends PorImp {
  static Ingredient Yellowtail = new Yellowtail();

  public YellowtailPortion(double amount) {
    super(amount, Yellowtail);
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    }
    if (!other.getIngredient().equals(Yellowtail)) {
      throw new IllegalArgumentException("Can't combine portions of different ingredients");
    }
    return new YellowtailPortion(other.getAmount() + this.getAmount());
  }
}
