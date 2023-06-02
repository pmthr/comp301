package com.comp301.a04junit;

import com.comp301.a04junit.adventure.*;
import org.junit.Test;

import static org.junit.Assert.*;

/** Write unit tests for the PlayerImpl class here */
public class JediPlayerTests {
  @Test
  public void testConstructor() {
    try {
      Player player = new PlayerImpl(null, 0, 0);
      fail("expected exception to be thrown");
    } catch (IllegalArgumentException e) {
      //
    }
  }

  @Test
  public void testGetName() {
    PlayerImpl player = new PlayerImpl("player1", 0, 0);
    assertEquals("player1", player.getName());
  }

  @Test
  public void testGetPosition() {
    PlayerImpl player = new PlayerImpl("player1", 0, 0);
    player.move(Direction.NORTH);
    assertEquals(0, player.getPosition().getX());
    assertEquals(1, player.getPosition().getY());
  }

  @Test
  public void testGetInventory() {
    Player player = new PlayerImpl("player1", 0, 0);
    assertNotNull(player.getInventory());
    assertTrue(player.getInventory().isEmpty());

    Item item1 = new ItemImpl("book");
    player.getInventory().addItem(item1);
    assertFalse(player.getInventory().isEmpty());
    assertEquals(1, player.getInventory().getNumItems());
    assertTrue(player.getInventory().getItems().contains(item1));

    Item item2 = new ItemImpl("key");
    player.getInventory().addItem(item2);
    assertFalse(player.getInventory().isEmpty());
    assertEquals(2, player.getInventory().getNumItems());
    assertTrue(player.getInventory().getItems().contains(item1));
    assertTrue(player.getInventory().getItems().contains(item2));
  }


  @Test
  public void testNorth() {
      Player player = new PlayerImpl("player",2,2);
      player.move(Direction.NORTH);
      assertEquals(2, player.getPosition().getX());
      assertEquals(3, player.getPosition().getY());
      player.move(Direction.EAST);
      assertEquals(3, player.getPosition().getX());
      assertEquals(3, player.getPosition().getY());
      player.move(Direction.WEST);
      assertEquals(2, player.getPosition().getX());
      assertEquals(3, player.getPosition().getY());
      player.move(Direction.SOUTH);
      assertEquals(2, player.getPosition().getX());
      assertEquals(2, player.getPosition().getY());
  }

  @Test
  public void testNorthN() {
    Player player = new PlayerImpl("player",0,0);
    player.move(Direction.NORTH);
    assertEquals(0, player.getPosition().getX());
    assertEquals(1, player.getPosition().getY());
  }

  @Test
  public void testEastN() {
    Player player = new PlayerImpl("player",0,0);
    player.move(Direction.EAST);
    assertEquals(1, player.getPosition().getX());
    assertEquals(0, player.getPosition().getY());
  }

  @Test
  public void testWestN() {
    Player player = new PlayerImpl("player",0,0);
    player.move(Direction.WEST);
    assertEquals(-1, player.getPosition().getX());
    assertEquals(0, player.getPosition().getY());
  }

  @Test
  public void testSouthN() {
    Player player = new PlayerImpl("player",0,32767);
    player.move(Direction.NORTH);
    assertEquals(0, player.getPosition().getX());
    assertEquals(32768, player.getPosition().getY());
  }

  @Test
  public void testNeg() {
    Player player = new PlayerImpl("player",-1,-1);
    player.move(Direction.NORTH);
    assertEquals(-1, player.getPosition().getX());
    assertEquals(0, player.getPosition().getY());
    player.move(Direction.NORTH);
    assertEquals(-1, player.getPosition().getX());
    assertEquals(1, player.getPosition().getY());
    player.move(Direction.SOUTH);
    assertEquals(-1, player.getPosition().getX());
    assertEquals(0, player.getPosition().getY());
    player.move(Direction.WEST);
    assertEquals(-2, player.getPosition().getX());
    assertEquals(0, player.getPosition().getY());
    player.move(Direction.EAST);
    assertEquals(-1, player.getPosition().getX());
    assertEquals(0, player.getPosition().getY());


  }


}
