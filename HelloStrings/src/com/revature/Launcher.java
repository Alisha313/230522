package com.revature;

public class Launcher {
    public static void main(String[] args) {

        System.out.println("==================(String Immutability)");

        // strings are immutable so we can't change them

        String s = "I am immutable  (Aka unchangeable)";
        s.toLowerCase();
        System.out.println(s);

        System.out.println(s.toLowerCase());

        String s2 = s.toLowerCase();
        System.out.println("New String s2: " + s2);
        System.out.println("Old String s: " + s);

        System.out.println("========================(String Equality)");

        int i = 5;
        System.out.println(i == 5);

        String st = "Hi Java"; // string literal (no new keyword)
        String st2 = "Hi Java"; // another string literal same value as another

        // the two strings above are actually the same

        String st3 = new String("Hi Java"); // since we used the new keyword this will be a brand new object in java memory

        String st4 = new String("Hi Java");

        System.out.println(st == st3); // false
        System.out.println(st == st2);
        System.out.println(st3 == st4);

        System.out.println(st.equals(st4));
        System.out.println(st3.equals(st4));

        System.out.println("===================(String Methods)");

        // A pangram to use on string methodsm on
        String pangram = "Sphinx of Black Quartz, judge my vow";

        System.out.println(pangram.length());

        //.subString() returns a string found within the original string
        System.out.println(pangram.substring(10));
        System.out.println(pangram.substring(10, 30));

        //.split() will create an Array via certain delimiters (things to seperate by)
        System.out.println(pangram.split(" "));

        String[] words = pangram.split(" ");

        //This is an "enhanced for loop" , it's like a shortcut for loop.
        //we'll use it to iterate(move) through the array
        for(String word: words){ // For every string in the array called words.. do something".
            System.out.println(word);
        }

        // .charAt()
        System.out.println(pangram.charAt(1)); //p
        System.out.println(pangram.charAt(0)); //s

        //a small method chain
        // we need length -1
        System.out.println(pangram.charAt(pangram.length() -1)); //w

        //Strings (and every other Array) are ZERO INDEXED
        //this means first character is going to be at index 0 (not 1)

        // StringBuilders are mutable or we can directly modify them
        StringBuilder sb = new StringBuilder("I am a StringBuilder");
        sb.reverse();
        System.out.println(sb);


        // Practice test
        StringBuilder sb1 = new StringBuilder(pangram);
        //.reverse() to reverse the given sentence

        sb1.reverse();

        //.append() to add string at the end

        sb1.append("Alisha");

        //.insert() to insert something new to the sentence

        sb1.insert(12, "ben");

        //.replace() to 3

        sb1.replace(0,5, "Hello from the replace method");
        System.out.println(sb1);



    }
}
