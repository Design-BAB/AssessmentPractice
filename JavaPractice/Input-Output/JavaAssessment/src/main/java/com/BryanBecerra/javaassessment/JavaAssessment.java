package com.BryanBecerra.javaassessment;
//need this for input
import java.util.Scanner;
//need this to handle files
import java.io.*;

/**
 *
 * @author bbece
 */

public class JavaAssessment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Using while-loop, write “Hello” to the screen 10 times, each on new line.  
        System.out.println("Hello");
        System.out.println("Hello");
        System.out.println("Hello");
        System.out.println("Hello");
        System.out.println("Hello");
        System.out.println("Hello");
        System.out.println("Hello");
        System.out.println("Hello");
        System.out.println("Hello");
        System.out.println("Hello");
        //Using for-loop, write code to loop 10 times and on each loop print message “loop #” followed by the count of the loop.
        int fooWhile = 1;
        while (fooWhile < 11) {
            System.out.println("Loop # " + fooWhile);
            fooWhile++;
        }
        // 3. Write code to prompt user for an integer, read in response, store it in a variable, and print out the variable
        System.out.println("Please type in a number and press ENTER...");
        int numInt = scanner.nextInt();
        System.out.println(numInt);
        /*
        Write code to display text based menu with 3 selections:  1) print hello, 2) print hi, and 3) exit. Allow 
user to select one option and either print the corresponding message (hello or hi) or terminate 
program.  User needs to type in 1, 2, or 3 as the input. After either “hello” or “hi” message is printed, 
user is presented with the menu again until he selects exit and program is terminated. Using the menu code from number 4 above, add error checking where if user enters an invalid input, 
he gets an error message and is allowed to select again.   Modify the menu code from number 5 above and instead of printing the messages directly in the 
menu code, define methods/functions that print the two strings and then call the methods/functions 
from the menu.  All else is to remain the same.  
        */
        
        
        
        boolean valid = false;
        do {
            System.out.println("Pick from the 3 options: ");
            System.out.println("1) Print hello");
            System.out.println("2)Print hi");
            System.out.println("3) Exit");
            numInt = scanner.nextInt();
            switch (numInt) {
                case 1: displayMessage1();
                    valid = true;
                     break;
                case 2: displayMessage2();
                        valid = true;
                        break;
                case 3: System.exit(0);
                    valid = true;
                    break;
                default: System.out.println("Please try again.");
            }
        } while (valid == false);
        /*
        Define a function that takes a character as a parameter and using a nested if-else statements, prints 
        as follow: if parameter value is ‘Y’ or ‘y’ prints “yellow”, if parameter value is ‘b’ or ‘B’ prints  “blue”, if 
        parameter value is ‘r’ or ‘R’ prints “red”, and for all other values prints “unknown”. 
        */
        
        String txt = scanner.next();
        printColor(txt);
        
        
    }
    
    public static void displayMessage1()
    {
        System.out.println("hello");
    }
    public static void displayMessage2()
    {
        System.out.println("hi");
    }
    
    public static void printColor(String txt) {
        txt = txt.toUpperCase();
        if (txt.equals("Y")) {
            System.out.println("yellow");
        } else if (txt.equals("B")) {
            System.out.println("blue");
        } else if (txt.equals("R")) {
            System.out.println("red");
        } else {
            System.out.println("unknown");
        }        
    }
}
