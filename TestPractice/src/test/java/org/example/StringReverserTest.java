package org.example;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StringReverserTest {

    @Test
    public void reverseASimpleString() {
        String input = "abc";
        String output = StringReverser.reverse(input);
        assertEquals(output, "cba");
    }

    @Test
    public void reverseAnEmptyString() {
        String input = "";
        String output = StringReverser.reverse(input);
        assertEquals(output, "");
    }

    @Test(expected = NullPointerException.class)
    public void reverseANullString() {
        StringReverser.reverse(null);
    }

    @Test
    public void testStringTooLong() {
        String input = "123456789101112131415";
        String output = StringReverser.reverse(input);
        assertEquals(output, "String too long!");
    }
}
