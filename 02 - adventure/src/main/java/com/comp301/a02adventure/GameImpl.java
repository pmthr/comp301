package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class GameImpl implements Game {
  private final Map map;
  private final Player player;

  public GameImpl(Map map, Player player) {
    if (map == null | player == null) {
      throw new IllegalArgumentException("Map and player cannot be null");
    }
    this.map = map;
    this.player = player;
  }

  @Override
  public Position getPlayerPosition() {
    return player.getPosition();
  }

  @Override
  public String getPlayerName() {
    return player.getName();
  }

  @Override
  public List<Item> getPlayerItems() {
    return new ArrayList<>(player.getInventory().getItems());
  }

  @Override
  public boolean getIsWinner() {
    return player.getInventory().getNumItems() == map.getNumItems();
  }

  @Override
  public void printCellInfo() {
    Cell current = map.getCell(player.getPosition());
    System.out.println("Location: " + current.getName());
    System.out.println(current.getDescription());
    if (current.getIsVisited()) {
      System.out.println("You have already visited this location.");
    }
    if (current.hasChest()) {
      System.out.println("You found a chest! Type 'open' to see what's inside, or keep moving.");
    }
    current.visit();
  }

  @Override
  public void openChest() {
    Cell current = map.getCell(player.getPosition());
    if (!current.hasChest()) {
      System.out.println("No chest to open, sorry!");
      return;
    }
    Inventory chest = current.getChest();
    if (chest.isEmpty()) {
      System.out.println("The chest is empty.");
    } else {
      player.getInventory().transferFrom(chest);
      System.out.println("You collected these items: " + player.getInventory().getItems());
    }
  }

  @Override
  public boolean canMove(Direction direction) {
    try {
      if (map.getCell(getPlayerPosition().getNeighbor(direction)) == null) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  @Override
  public void move(Direction direction) {
    if (!canMove(direction)) {
      System.out.println("You can't go that way! Try another direction.");
      return;
    }
    player.move(direction);
    printCellInfo();
  }
}
