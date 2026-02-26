/*
13. Using class definition from number 11 above, create an instance of class Person called person1 in 
main method. Then assign the following values to each attribute:  age gets the value of 20 and id gets 
the value of 101.  
14. Using class definition from number 11 above, define an array or list (in Java use ArrayList) of type 
Person. Then write a loop to print out the value of age attribute of each element in the array.  
15. Use the same class definition as number 11 and then create a separate class called Driver with main 
method. In main() method write code to open and read a file. The file will have two integers on each 
line for unknown number of lines. The program should read each line as string and parse the string 
into two integers. Each set of values (one line of data) should be stored in an instance of Person and 
added to array or list (ArrayList in Java) of type Person.  
16. Using the code from number 15 above, add error checking where if either integers is less than 0, the 
code does not store that instance in the array or list (ArrayList for Java). At the end of the program it 
prints to console how many elements it successfully stored in the array or list.  
17. Write a method definition called myMethod with one parameter of type String. In the method check 
the string and if it empty string, thrown an exception (IllegalArgumentException for Java and 
ValueError for Python).  
18. In main() method, create a String variable and assign it a value “abcd” . Then call a String method 
called charAt (for Java and equivalent code in other languages) passing it a parameter of value of 1. 
Assume that the method charAt returns a character and you pass it the index value you want it to 
return. For example, if you pass index value 0, it would return ‘a’, if you pass 1, it would return ‘b’, 
etc. If you pass an index value outside of range of the string size, charAt will throw  
StringIndexOutOfBoundsException for Java and IndexError for Python. Use try/catch block to catch if 
the method thrown an exception and print out the value that charAt returns. Then run again giving it 
an index of out range.  
*/

package edu.mdc.javaassessment12to18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author bbece
 */
public class Driver {

    public static void main(String[] args) {
        //#13
        Person person1 = new Person(20, 101);
        //#14
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person(21, 102));
        people.add(new Person(81, 103));
        people.add(new Person(19, 104));
        
        for (int i = 0; i < people.size(); i++)
        {
            System.out.println("Person #" + i + " age: " + people.get(i).getAge());
        }
        
        
        
        //#15
        ArrayList<Person> drivers = new ArrayList<>();
        File file = new File("Data.txt");
        //2 arraies
        int[] firstIntegers = new int[100];
        int[] secondIntegers = new int[100];
        //keeps track what # of line we are in the text file to be printed later
        int lineNum = 0;

        try {
            //scan file
            Scanner inputFile = new Scanner(file);
            //while file has something next
            while (inputFile.hasNextLine()) {
                String line = inputFile.nextLine().trim();
                lineNum++;

                String[] parts = line.split("\\s+");
                if (parts.length != 2) {
                    System.err.println("Error: Line " + lineNum + " is not properly formatted.");
                    inputFile.close();
                    return;
                }

                try {
                    int num1 = Integer.parseInt(parts[0]);
                    int num2 = Integer.parseInt(parts[1]);

                    firstIntegers[lineNum - 1] = num1;
                    secondIntegers[lineNum - 1] = num2;

                } catch (NumberFormatException e) {
                    System.err.println("Error: Non-integer value found on line " + lineNum);
                    inputFile.close();
                    return;
                }
            }

            inputFile.close();

            // Print stored values
            for (int i = 0; i < lineNum; i++) {
                if (firstIntegers[i] > 0 && secondIntegers[i] > 0) {
                 drivers.add(new Person(firstIntegers[i], secondIntegers[i]));   
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        }
        //#18
        String stringFor18 = "abcd";
        System.out.println(stringFor18.charAt(1));
        try {
            System.out.println(stringFor18.charAt(10));
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("Lol, you went too far and so there is no character in that position for the line of text.");
        }
        
        
    }
    //#17
    public static void myMethod(String input) {
        if (input == null || input.trim().isEmpty()){
            throw new IllegalArgumentException("Bro, this input string cannot be empty.");
        }
    }
}
