package com.comp301.a01sushi;

public class EelPortion extends PorImp {
  static Ingredient Eel = new Eel();

  public EelPortion(double amount) {
    super(amount, Eel);
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    }
    if (!other.getIngredient().equals(Eel)) {
      throw new IllegalArgumentException("Can't combine portions of different ingredients");
    }
    return new EelPortion(other.getAmount() + this.getAmount());
  }
}
