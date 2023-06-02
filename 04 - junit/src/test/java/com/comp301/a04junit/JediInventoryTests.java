package com.comp301.a04junit;

import com.comp301.a04junit.adventure.Inventory;
import com.comp301.a04junit.adventure.InventoryImpl;
import com.comp301.a04junit.adventure.Item;
import com.comp301.a04junit.adventure.ItemImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/** Write unit tests for the InventoryImpl class here */
public class JediInventoryTests {
  @Test
  public void testIsEmpty() {
    InventoryImpl inventory = new InventoryImpl();
    assertTrue(inventory.isEmpty());
    inventory.addItem(new ItemImpl("item1"));
    assertFalse(inventory.isEmpty());
  }

  @Test
  public void testGetNumItems() {
    InventoryImpl inventory = new InventoryImpl();
    assertEquals(inventory.getNumItems(), 0);
    inventory.addItem(new ItemImpl("item1"));
    assertEquals(inventory.getNumItems(), 1);
  }

  @Test
  public void testGetItems() {
    Inventory inventory = new InventoryImpl();
    Item item1 = new ItemImpl("item1");
    Item item2 = new ItemImpl("item2");
    inventory.addItem(item1);
    inventory.addItem(item2);
    List<Item> expected = Arrays.asList(item1, item2);
    assertEquals(expected, inventory.getItems());
  }

  @Test
  public void testAddItem() {
    InventoryImpl inventory = new InventoryImpl();
    inventory.addItem(new ItemImpl("item1"));
    assertEquals(inventory.getNumItems(), 1);
    assertEquals("item1", inventory.getItems().get(0).getName());
  }

  @Test
  public void testRemoveItem() {
    InventoryImpl inventory = new InventoryImpl();
    Item item1 = new ItemImpl("item1");
    Item item2 = new ItemImpl("item2");
    inventory.addItem(item1);
    inventory.addItem(item2);
    inventory.removeItem(item1);
    assertEquals(inventory.getNumItems(), 1);
    assertEquals("item2", inventory.getItems().get(0).getName());
  }

  @Test
  public void testClear() {
    InventoryImpl inventory = new InventoryImpl();
    inventory.addItem(new ItemImpl("item1"));
    inventory.addItem(new ItemImpl("item2"));
    inventory.clear();
    assertEquals(inventory.getNumItems(), 0);
    assertTrue(inventory.getItems().isEmpty());
  }

  @Test
  public void testTransferFrom() {
    InventoryImpl inventory1 = new InventoryImpl();
    InventoryImpl inventory2 = new InventoryImpl();
    inventory1.addItem(new ItemImpl("item1"));
    inventory2.addItem(new ItemImpl("item2"));
    inventory1.transferFrom(inventory2);
    assertEquals(inventory1.getNumItems(), 2);
    assertEquals("item1", inventory1.getItems().get(0).getName());
    assertEquals("item2", inventory1.getItems().get(1).getName());
    assertEquals(inventory2.getNumItems(), 0);
    assertTrue(inventory2.getItems().isEmpty());
    }

  @Test
  public void testTransferNull() {
    InventoryImpl inventory3 = new InventoryImpl();
    inventory3.addItem(new ItemImpl("item1"));
    inventory3.addItem(new ItemImpl("item2"));
    inventory3.transferFrom(null);
    assertEquals(2, inventory3.getNumItems());
  }

  @Test
  public void testAddRemoveMultipleItems() {
    Inventory inventory = new InventoryImpl();
    Item item1 = new ItemImpl("item1");
    Item item2 = new ItemImpl("item2");
    Item item3 = new ItemImpl("item3");
    Item item4 = new ItemImpl("item4");
    inventory.addItem(item1);
    inventory.addItem(item2);
    inventory.addItem(item3);
    assertEquals(3, inventory.getItems().size());
    inventory.removeItem(item2);
    inventory.addItem(item4);
    assertEquals(3, inventory.getItems().size());
    assertTrue(inventory.getItems().contains(item1));
    assertTrue(inventory.getItems().contains(item3));
    assertTrue(inventory.getItems().contains(item4));
  }

  @Test
  public void testGetItemsReturnsClone() {
    Inventory inventory = new InventoryImpl();
    Item item1 = new ItemImpl("item1");
    inventory.addItem(item1);
    List<Item> items = inventory.getItems();
    items.clear();
    assertEquals(1, inventory.getItems().size());
    assertTrue(inventory.getItems().contains(item1));
  }

  @Test
  public void testGetItemsReturnsCorrectItems() {
    Inventory inventory = new InventoryImpl();
    Item item1 = new ItemImpl("item1");
    Item item2 = new ItemImpl("item2");
    inventory.addItem(item1);
    inventory.addItem(item2);
    Item[] expectedItems = {item1, item2};
    Item[] actualItems = inventory.getItems().toArray(new Item[0]);
    assertArrayEquals(expectedItems, actualItems);
  }


}
