//We start by creating a class named Launcher with the public access modifier.
// The class will contain our main method, which serves as the entry point for the application.
package com.revature;


public class Launcher {
        //we instantiate a String array named daysOfWeek and initialize it
       //with the names of the days of the week: "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday".

        public static void main(String[] args) {
            String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
            //We use a for loop to iterate through each element of the daysOfWeek array.
            // For each iteration, the current day is stored in the day variable of type String.
            for (String day : daysOfWeek) {
                //This prints the day of the week without a new line character.
                System.out.print(day + " : ");

                //if the current day starts with the letter "T" or "S".
                // We utilize the startsWith() method of the String class to perform this check.
                // If the condition is true, indicating that the day starts with "T" or "S", we execute the code within the if block.
                if (day.startsWith("T") || day.startsWith("S")) {
                    //we use System.out.println("stay home") to print the message "stay home" on a new line if the condition is not met.

                    System.out.println("go to the gym");
                } else {
                    //
                    System.out.println("stay home");
                }
            }
        }
    }


