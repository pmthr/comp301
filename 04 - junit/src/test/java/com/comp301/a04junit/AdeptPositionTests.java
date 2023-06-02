package com.comp301.a04junit;

import com.comp301.a04junit.adventure.Direction;
import com.comp301.a04junit.adventure.Position;
import com.comp301.a04junit.adventure.PositionImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** Write unit tests for the PositionImpl class here */
public class AdeptPositionTests {
  @Test
  public void testImmutableGetters() {
    PositionImpl position = new PositionImpl(0, 0);
    int x = position.getX();
    int y = position.getY();
    x = 5;
    y = 10;
    assertEquals(0, position.getX());
    assertEquals(0, position.getY());
  }

  @Test
  public void testGetX() {
    Position position = new PositionImpl(5, 0);
    assertEquals(5, position.getX());
  }

  @Test
  public void testGetY() {
    Position position = new PositionImpl(0, 10);
    assertEquals(10, position.getY());
  }

  @Test
  public void testGetNeighbor() {
    Position position = new PositionImpl(3, 4);
    assertEquals(2, position.getNeighbor(Direction.WEST).getX());
    assertEquals(4, position.getNeighbor(Direction.EAST).getX());
    assertEquals(3, position.getNeighbor(Direction.SOUTH).getY());
    assertEquals(5, position.getNeighbor(Direction.NORTH).getY());
  }
}
