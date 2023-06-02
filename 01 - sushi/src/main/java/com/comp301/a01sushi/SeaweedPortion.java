package com.comp301.a01sushi;

public class SeaweedPortion extends PorImp {
  static Ingredient Seaweed = new Seaweed();

  public SeaweedPortion(double amount) {
    super(amount, Seaweed);
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    }
    if (!other.getIngredient().equals(Seaweed)) {
      throw new IllegalArgumentException("Can't combine portions of different ingredients");
    }
    return new SeaweedPortion(other.getAmount() + this.getAmount());
  }
}
