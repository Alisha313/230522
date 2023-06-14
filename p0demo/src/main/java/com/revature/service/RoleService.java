package com.revature.service;

import com.revature.daos.RoleDAO;
import com.revature.daos.RoleDAOInterface;
import com.revature.models.Role;

public class RoleService {

    //This is going to function the same way our employee service does but for roles

    /*
    We need to check our DAO to see what methods we have available to work it form CRUD
    we have getRoleById and updateRoleSalary
     */

    //we need to get an instance of our RoleDAO to use it
    private final RoleDAOInterface roleDAO = new RoleDAO();

    //now we need to think about how the controller is going to call our methods

    //there are some problems if the controller layer hands us any old integer
    //we're going to add in some logic to do some validates with the information that the controller hands us
    public Role getRoleById(int id){
        //The controller doesn't care WHAT integer it hands us, it's only job is to pass the infor

        if (id > 0){
            return roleDAO.getRoleById(id);
        } else{
            return null;
            //our controller will have some logic to print out an appropriate statement if it receives
            //a valid Role object or a null object
        }
    }


    //To update our role salary there's a couple of things we need to do first
    //TODOwe need to validate that the salary is >0
    //TODOwe need to find some way to make the string we're handed TitleCase otherwise there's point searching for it
    public boolean updateSalary(int salary, String title) {

        //before everything let's make sure we have a valid string length
        if (title == null || title.trim().equals("")) {
            return false;
        }

        //fry cook --> Fry Cook
        //fRY CoOK --> Fry Cook
        //Let's find a way to make our string TitleCase
        //we're going to make a bunch of string object (sorry string pool lol) to basically reconstruct the string
        //

        char[] titleArray = title.toLowerCase().toCharArray();

        //now i need a strin gto store the result
        StringBuilder formattedTitle = new StringBuilder();

        //we need to add the first character as a capital letter
        //we're going to use the wrapper class character's toUpperCase method
        formattedTitle.append(Character.toUpperCase(titleArray[0]));

        //Now we need to loop over the rest of the characters and if the character BEFORE the current one is a space
        //we need to capitalize that character, otherwise just add
        for (int i = 1; i < titleArray.length; i++) {
            if (titleArray[i - 1] == ' ') {
                formattedTitle.append(Character.toUpperCase(titleArray[i]));
            } else {
                formattedTitle.append(titleArray[i]);
            }
        }

        if (salary > 0) {
            return roleDAO.updateRoleSalary(salary, formattedTitle.toString());
        }

        //an additional way to do this
        /*
        Fry Cook
        String[] words = title.split(" ")
        String formattedTitle2 = ""
        for(String word: words){
            formattedTitle2 += Character.toUpperCase(word.charAt(0)) + word.subString(1)
         */

        return false;

    }

}




