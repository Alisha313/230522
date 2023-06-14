package com.revature.models;

public class Snake implements Animal{

    @Override
    public void makeNoise() {
        System.out.println("Snake never make noise.");
    }

    @Override
    public void walk() {
        System.out.println("Snake can crawl");
    }

    @Override
    public void eat() {
        System.out.println("Snake eat animals");
    }


}

