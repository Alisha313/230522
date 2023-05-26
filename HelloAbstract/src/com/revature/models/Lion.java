package com.revature.models;

public class Lion extends Cat{

    public void move() {
        System.out.println("Lion is stalking in the grass");
    }

    public void makeNoise() {
        System.out.println("ROOOOOOOARRR");
    }

    public Lion(int whiskers) {
        super(whiskers);
    }

}
