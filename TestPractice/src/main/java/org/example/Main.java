package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter random string");

        String random = myObj.nextLine();  // Read user input
        System.out.println("Here is the input" + random);

        System.out.println("Reversed -->" + StringReverser.reverse(null));
    }
}