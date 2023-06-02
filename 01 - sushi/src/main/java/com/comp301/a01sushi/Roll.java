package com.comp301.a01sushi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Roll implements Sushi {
  private final String name;
  private final IngredientPortion[] roll;

  public Roll(String name, IngredientPortion[] roll) {
    if (name == null) {
      throw new RuntimeException("Roll name is null");
    }
    this.name = name;
    if (roll == null) {
      throw new RuntimeException("Roll ingredients are null");
    }
    ArrayList<IngredientPortion> roll_list = new ArrayList<>();
    int temp = -1;
    int listIndex;
    for (IngredientPortion ingredientPortion : roll) {
      if (ingredientPortion == null) {
        throw new RuntimeException("At least one roll ingredient is null");
      } else {
        listIndex = -1;
        for (IngredientPortion ingPor : roll_list) {
          if (ingPor.getName().equals(ingredientPortion.getName())) {
            listIndex = roll_list.indexOf(ingPor);
            roll_list.set(listIndex, roll_list.get(listIndex).combine(ingredientPortion));
          }
        }
        if (listIndex == -1) {
          roll_list.add(ingredientPortion);
        }
      }
    }
    for (IngredientPortion ingredientPortion : roll_list) {
      if (ingredientPortion.getName().equals("seaweed")) {
        temp = roll_list.indexOf(ingredientPortion);
      }
    }
    if (temp == -1) {
      roll_list.add(new SeaweedPortion(.1));
    } else {
      double tempamt = roll_list.get(temp).getAmount();
      if (tempamt < .1) {
        roll_list.set(temp, new SeaweedPortion(.1));
      }
    }
    this.roll = roll_list.toArray(new IngredientPortion[0]);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public IngredientPortion[] getIngredients() {
    return roll.clone();
  }

  @Override
  public int getCalories() {
    double sum = 0.0;
    for (IngredientPortion ingredientPortion : roll) {
      sum += ingredientPortion.getCalories();
    }
    return (int) Math.round(sum);
  }

  @Override
  public double getCost() {
    double sum = 0.0;
    for (IngredientPortion ingredientPortion : roll) {
      sum += ingredientPortion.getCost();
    }
    return Math.round(sum * 100) / 100.0;
  }

  @Override
  public boolean getHasRice() {
    for (IngredientPortion ingredientPortion : roll) {
      if (ingredientPortion.getIsRice()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean getHasShellfish() {
    for (IngredientPortion ingredientPortion : roll) {
      if (ingredientPortion.getIsShellfish()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean getIsVegetarian() {
    for (IngredientPortion ingredientPortion : roll) {
      if (ingredientPortion.getIsVegetarian()) {
        return true;
      }
    }
    return false;
  }
}
