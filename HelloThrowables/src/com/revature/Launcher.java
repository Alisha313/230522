package com.revature;

import com.revature.models.CookieEatingMonster;
import com.revature.models.Food;

public class Launcher {

    public static void main(String[] args) {

        System.out.println("===================(Throwing some RuntimeExceptions)");

        //we'll never purposefully throw these built-in Java Exceptions. This is just for science

        System.out.println("Trying to divide by zero");

        //System.out.println(30/0);
        //Java lets us compile this, but throws an ArithmeticException at RUntime (Runtime Exception)

        System.out.println("Trying to access an Array index that doesn't exist");

        int[] numbers = {1, 7, 4, 900}; //this Array has indexes 0 through 3.

        //System.out.println(numbers[4]);
        //again, Java compiles, but we get an ArrayIndexOutOfBounds Exception

        System.out.println("================(Exception Handling)");

        /*
        One way to handle Exceptions is with a Try CATCH BLOCK
        - First, we TRY to execute some code that may throw an Exception
        -Next, we have a series of CATCH blocks which are set to catch certain Exceptions
        -we can also have a Finally block that runs at the end no matter what
         */

        try{
            System.out.println("Try block starting--/");
            int x = 5/0; //the exception gets thrown here
            System.out.println("Will I run? NO - Because an Exception was thrown before this line");
        }
        catch (NullPointerException e){
            System.out.println("I will not run!! An Arithmetic Exception is getting thrown");
        }
        catch (ArithmeticException e){
            System.out.println("Hello from the catch block! I caught an ArithmeticException.");
        }
        catch (Exception e){
            System.out.println("I could have caught any kind of Exception if the other's didn't");
        }
        finally{
            System.out.println("Hello from the finally block! I will always run.");
        }


        System.out.println("============(Using our Custom Exception)");

        //instantiate a CookieEatingMonster
        CookieEatingMonster cm = new CookieEatingMonster();

        //Make some Food objects to test with
        Food apple = new Food("Apple", false);
        Food chocoChip = new Food("Chocolate Chip Cookie", true);

        cm.eatCookieWithTryCatch(chocoChip); //we gave it a cookie, so no problem
        cm.eatCookieWithTryCatch(apple);
        //yes, an exception was thrown here, but the app did not crash.
        //the red text we see is a result of e.printStackTrace()

        System.out.println("App didn't actually crash");

        //now, we're going to use the other CookieEatingMonster method
        cm.eatCookieWithThrows(chocoChip);
        cm.eatCookieWithThrows(apple);

        //the main methods throws a NotACookieException.
        //but since main is the method on that stack, it has nowhere else to go.
        // so the exception gets thrown regardless.
        //A better solution here would be a try/catch.

    }

}
