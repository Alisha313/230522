package com.revature.models;

public class Cat implements Animal{

    @Override
    public void makeNoise() {
        System.out.println("Meow");
    }

    @Override
    public void walk() {
        System.out.println("Cat loves to jump");
    }

    @Override
    public void eat() {
        System.out.println("Cat drinks milk");
    }


}
