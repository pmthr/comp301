package com.comp301.a01sushi;

public class Nigiri implements Sushi {
  private static final double por = .75;
  private static final double rpor = .5;
  private final NigiriType type;
  private final IngredientPortion rice;
  private IngredientPortion seafood;

  public Nigiri(NigiriType type) {
    rice = new RicePortion((rpor));
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
    return seafood.getName() + " nigiri";
  }

  @Override
  public IngredientPortion[] getIngredients() {
    return new IngredientPortion[] {seafood, rice};
  }

  @Override
  public int getCalories() {
    return (int) Math.round((seafood.getCalories() + rice.getCalories()));
  }

  @Override
  public double getCost() {
    return seafood.getCost() + rice.getCost();
  }

  @Override
  public boolean getHasRice() {
    return true;
  }

  @Override
  public boolean getHasShellfish() {
    return seafood.getIsShellfish();
  }

  @Override
  public boolean getIsVegetarian() {
    return false;
  }

  public enum NigiriType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  }
}
