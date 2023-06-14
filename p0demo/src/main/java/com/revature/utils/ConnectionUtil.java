package com.revature.utils;

import ch.qos.logback.classic.net.SimpleSocketServer;
import jdk.internal.misc.ThreadFlock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.SubmissionPublisher;

//This Class is where we manage and establish our database connection
public class ConnectionUtil {


    //This method will eventually return an object of type Connection, which we'll use to connect to our databse
    public static Connection getConnection() throws SQLException {

        //For compatibility with other technologies/frameworks, we'll need to register our PostgreSQL driver
        //This process makes the application aware of what Driver class we're using
        try {
            Class.forName("org.postgresql.Driver"); //searching for the postgres driver, which we have as a dependency
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); //This tells us in the console what went wrong
            System.out.println("problem occurred locating driver");
        }


        //Use our database credentials to establish a database connection
        //Hardcoded for now - It's possible hide them in the Environment Variables, feel free to look into it

        //I'm going to put the credentials in Strings, and use those strings in a method that gets connections
        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema= p0demo";
        String username = "postgres";
        String password = "password";

        //This return statement is what returns out actual database Connection object
        //Note how this getConnection() method has a return type of Connection
        // return DriverManager.getConnection(url, username, password);


        if (connection != null && !connection.isClosed()){
            System.out.println("using a previously created connection");
            return (Connection);
        }
    }

}

