package com.revature;

import com.revature.controllers.EmployeeController;
import com.revature.utils.JavalinAppConfig;
import io.javalin.Javalin;

public class Driver {

    //thi driver has the sole responsibility of starting our javelin application, in a perfect world this will likely
    //contain the ONLY mai method in our application

    public static void main(String[] args) {

        JavalinAppConfig app = new JavalinAppConfig();

        app.start(8080);

    }


}
