package com.comp301.a01sushi;

public class IngImp implements Ingredient {
  private final String name;
  private final double pricePerOunce;
  private final int caloriesPerOunce;
  private final boolean veg;
  private final boolean rice;
  private final boolean shell;

  public IngImp(
      String name,
      double pricePerOunce,
      int caloriesPerOunce,
      boolean veg,
      boolean rice,
      boolean shell) {
    this.name = name;
    this.pricePerOunce = pricePerOunce;
    this.caloriesPerOunce = caloriesPerOunce;
    this.veg = veg;
    this.rice = rice;
    this.shell = shell;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public double getCaloriesPerDollar() {
    return caloriesPerOunce / pricePerOunce;
  }

  @Override
  public double getPricePerOunce() {
    return pricePerOunce;
  }

  @Override
  public int getCaloriesPerOunce() {
    return caloriesPerOunce;
  }

  @Override
  public boolean getIsVegetarian() {
    return veg;
  }

  @Override
  public boolean getIsRice() {
    return rice;
  }

  @Override
  public boolean getIsShellfish() {
    return shell;
  }

  @Override
  public boolean equals(Ingredient other) {
    if (other == null) {
      return false;
    }
    return other.getName().equals(getName())
        && (other.getCaloriesPerOunce() == getCaloriesPerOunce())
        && (Math.abs(other.getPricePerOunce() - getPricePerOunce()) < 0.01)
        && (other.getIsVegetarian() == getIsVegetarian())
        && (other.getIsRice() == getIsRice())
        && (other.getIsShellfish() == getIsShellfish());
  }
}
