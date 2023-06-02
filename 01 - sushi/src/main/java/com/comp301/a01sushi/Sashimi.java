package com.comp301.a01sushi;

public class Sashimi implements Sushi {
  private static final double por = .75;
  private final SashimiType type;
  private IngredientPortion seafood;

  public Sashimi(SashimiType type) {
    this.type = type;
    switch (type) {
      case TUNA:
        seafood = new TunaPortion((por));
        break;
      case YELLOWTAIL:
        seafood = new YellowtailPortion((por));
        break;
      case EEL:
        seafood = new EelPortion((por));
        break;
      case CRAB:
        seafood = new CrabPortion((por));
        break;
      case SHRIMP:
        seafood = new ShrimpPortion((por));
        break;
    }
  }

  @Override
  public String getName() {
    return seafood.getName() + " sashimi";
  }

  @Override
  public IngredientPortion[] getIngredients() {
    return new IngredientPortion[] {seafood};
  }

  @Override
  public int getCalories() {
    return (int) Math.round((seafood.getCalories()));
  }

  @Override
  public double getCost() {
    return seafood.getCost();
  }

  @Override
  public boolean getHasRice() {
    return false;
  }

  @Override
  public boolean getHasShellfish() {
    return seafood.getIsShellfish();
  }

  @Override
  public boolean getIsVegetarian() {
    return false;
  }

  public enum SashimiType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  }
}
