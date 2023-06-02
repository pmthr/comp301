package com.comp301.a01sushi;

public interface Ingredient {
  String getName();

  double getCaloriesPerDollar();

  int getCaloriesPerOunce();

  double getPricePerOunce();

  boolean getIsVegetarian();

  boolean getIsRice();

  boolean getIsShellfish();

  boolean equals(Ingredient other);
}
