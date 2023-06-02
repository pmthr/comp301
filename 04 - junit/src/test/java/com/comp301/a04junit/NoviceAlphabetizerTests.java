package com.comp301.a04junit;

import com.comp301.a04junit.alphabetizer.Alphabetizer;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/** Write tests for the Alphabetizer class here */
public class NoviceAlphabetizerTests {
    @Test
    public void testMutation() {
      String[] input = {"c", "a", "b"};
      Alphabetizer a = new Alphabetizer(input);
      input[0] = "d";
      assertEquals("a", a.next());
      assertEquals("b", a.next());
      assertEquals("c", a.next());
    }

    @Test
    public void testNull() {
        Alphabetizer a = new Alphabetizer(null);
        assertFalse(a.hasNext());
        try {
            a.next();
            fail("expected exception to be thrown");
        } catch(NoSuchElementException e) {
            //
        }
    }

    @Test
    public void testCapitalized() {
        String[] input = {"c", "b", "a", "C", "B", "A"};
        String[] expected = {"A", "B", "C", "a", "b", "c"};
        Alphabetizer a = new Alphabetizer(input);
        assertEquals("A", a.next());
        assertEquals("B", a.next());
        assertEquals("C", a.next());
        assertEquals("a", a.next());
        assertEquals("b", a.next());
        assertEquals("c", a.next());
        try {
            a.next();
            fail("expected exception to be thrown");
        } catch (NoSuchElementException e) {
            //
        }
    }

    @Test
    public void testEmptyArray() {
      String[] arr = {};
      Alphabetizer a = new Alphabetizer(arr);
      assertFalse(a.hasNext());
      try {
        a.next();
        fail("expected exception to be thrown");
      } catch (NoSuchElementException e) {
        //
      }
    }

    @Test
    public void testHasNext() {
      String[] arr = {"b", "c", "a"};
      Alphabetizer a = new Alphabetizer(arr);
      assertTrue(a.hasNext());
      a.next();
      assertTrue(a.hasNext());
      a.next();
      assertTrue(a.hasNext());
      a.next();
      assertFalse(a.hasNext());
    }

    @Test
    public void testNext() {
      String[] arr = {"b", "c", "a"};
      Alphabetizer a = new Alphabetizer(arr);
      assertEquals("a", a.next());
      assertEquals("b", a.next());
      assertEquals("c", a.next());
      try {
        a.next();
        fail("expected exception to be thrown");
      } catch (NoSuchElementException e) {
        //
      }
    }
}
