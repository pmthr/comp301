package com.comp301.a04junit;

import com.comp301.a04junit.adventure.Item;
import com.comp301.a04junit.adventure.ItemImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/** Write unit tests for the ItemImpl class here */
public class AdeptItemTests {
  @Test
  public void testConstructor() {
    try {
      Item item = new ItemImpl(null);
      fail("expected exception to be thrown");
    } catch (IllegalArgumentException e) {
      //
    }
  }

  @Test
  public void testGetName() {
    Item item = new ItemImpl("key");
    assertEquals("key", item.getName());
  }

  @Test
  public void testEquals() {
    Item item1 = new ItemImpl("key");
    Item item2 = new ItemImpl("key");
    Item item3 = new ItemImpl("book");
    assertEquals(item1, item2);
    assertNotEquals(item1, item3);
  }

  @Test
  public void testToString() {
    Item item = new ItemImpl("key");
    assertEquals("key", item.toString());
  }
}
