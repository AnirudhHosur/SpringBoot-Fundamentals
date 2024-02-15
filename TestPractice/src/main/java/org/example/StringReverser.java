package org.example;

public class StringReverser {

    public static String reverse(String input) {
        if(input.length() < 15) {
            return new StringBuilder(input).reverse().toString();
        } else {
            return "String too long!";
        }
    }
}
