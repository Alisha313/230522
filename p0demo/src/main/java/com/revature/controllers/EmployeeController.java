package com.revature.controllers;

import com.revature.models.Employee;
import com.revature.service.EmployeeService;
import io.javalin.http.Context;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class EmployeeController {
    /*
    The controller layer has the sole responsibility of taking in HTTPRequests and has to the responsibility of sending the corresponding response.
    For our responses, best practice will be to return an appropriate message in the response body and have the proper status code
    Just
     */

    
    private static final  EmployeeService employeeService = new EmployeeService();

    public static void handleGetAll(Context ctx){
        //inside here we need tp make a call to our Employee service to get us all the employees listed
        ArrayList<Employee> employees = employeeService.getAllEmployees();
        
        // String result = "";

        //for (Employee e : employees){
        // result += e.toString() + "\n";
        //}

       // ctx.status(200);
       // ctx.result(result);

        //Now we can leverage our JSON mapper, GSON, to convert our java object to a JSON

        ctx.status(200);
        ctx.json(employees);
    }

    public static void handleCreate(Context ctx){
        //To create a new employee from our context body we need to essentially take it in as a JSOn and convert it
        //To an object of the appropriate class.

        Employee emp = ctx.bodyAsClass(Employee.class);

        Employee returnedEmployee = employeeService.createNewEmployee(emp);

        //If the employee object we receive from the service is null, something has gone wrong
        //If it is not null, yay we did it

        if (returnedEmployee != null){
            //This means the employee was created
            ctx.status(200);
            ctx.json(returnedEmployee);
        } else{
            //What happens if it comes back null?
            ctx.status(400);
        }
    }

    //create some method stubs here just for now
    public static void handleGetOne(Context ctx){
        ctx.status(405);
    }

    public static void handleUpdate(Context ctx){
        ctx.status(405);
    }

    public static void handleDelete(Context ctx){
        ctx.status(405);
    }
}



