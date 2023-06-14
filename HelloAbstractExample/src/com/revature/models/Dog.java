package com.revature.models;

public class Dog implements Animal{

    @Override
    public void makeNoise() {
        System.out.println("Barkkkkkkkk");
    }

    @Override
    public void walk() {
        System.out.println("Dog loves to walk with their tail moving");
    }

    @Override
    public void eat() {
        System.out.println("Eats meat");
    }



}
