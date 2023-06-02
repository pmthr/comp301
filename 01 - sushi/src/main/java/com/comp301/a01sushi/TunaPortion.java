package com.comp301.a01sushi;

public class TunaPortion extends PorImp {
  static Ingredient Tuna = new Tuna();

  public TunaPortion(double amount) {
    super(amount, Tuna);
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    }
    if (!other.getIngredient().equals(Tuna)) {
      throw new IllegalArgumentException("Can't combine portions of different ingredients");
    }
    return new TunaPortion(other.getAmount() + this.getAmount());
  }
}
