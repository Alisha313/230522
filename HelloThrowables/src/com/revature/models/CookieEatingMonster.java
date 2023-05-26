
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.revature.models;

import com.revature.exceptions.NotACookieException;

public class CookieEatingMonster {
    public CookieEatingMonster() {
    }

    public void eatCookieWithTryCatch(Food food) {
        try {
            if (!food.isCookie) {
                throw new NotACookieException("I only eat COOKIES");
            }

            System.out.println("Thanks for the cookie omnomnom");
        } catch (NotACookieException var3) {
            System.out.println("Exception Caught!");
            var3.printStackTrace();
        }

    }

    //This method THROWS NotACookieException, which makes it not responsible for that Exception
    //If a NotACookieException gets thrown here, it will be the responsibility for the method that called it
    public void eatCookieWithThrows(Food food) throws NotACookieException{

        if(food.isCookie){
            System.out.println("Thanks for the delicious cookie. OMNONMNOM ");
        }else{
            throw new NotACookieException("So not feed me anything other than cookies.");
        }

    }
}
