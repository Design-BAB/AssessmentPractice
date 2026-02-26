/*
 Bryan Becerra
8-29-2025
Description: This program 
 */

package edu.mdc.javaassessment8to11;
import java.util.Scanner;
import java.io.*;

public class JavaAssessment8To11 {

    public static void main(String[] args) throws FileNotFoundException {
        /*
        Write code to open and read a file. The file will have two integers on each line for unknown number 
        of lines. The program should read each line as string and parse the string into two integers. The value 
        of the two integers should be printed with a message: “Line number” followed by the line where the 
        data was read from. And on the same line, “Integer 1 =” followed by the value on first integer and 
        “Integer 2 =” followed by value of the second integer.  If the file has incorrectly formatted data, the 
        program should print an error message and terminate. 
        
        Using the program from number 9 above, instead of printing the two values, store them in two 
        separate arrays of size 100. First array will hold the first integer values and the second array will hold 
        the second integer values. Then after the whole file is processed, use a loop to traverse the array and 
        print the values same as in number 8: “Line number” followed by the line where the data was read 
        from. And on the same line, “Integer 1 =” followed by the value on first integer and “Integer 2 =” 
        followed by value of the second integer. For the purpose of this code assume that the file can never 
        have more than 100 elements. 
        */
        //initially getting file
        File file = new File("ints.txt");
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
                System.out.println("Line number " + (i + 1) + ": Integer 1 = " +
                                   firstIntegers[i] + ", Integer 2 = " + secondIntegers[i]);
            }
            System.out.println("The biggest number in the first array is " + biggestValue(firstIntegers));
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        }
        
    }
    
    /*
    Write code for a function called biggestValue that takes an array of integers (or any list you wish to 
    use such as ArrayList for Java) as parameter and size of array if needed and returns the highest value 
    found in that array.
    */
    public static int biggestValue(int[] array)
    {
        int theBigOne = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] > theBigOne) {
                theBigOne = array[i];
            }
        }
        return theBigOne;
    }
    
    
}

