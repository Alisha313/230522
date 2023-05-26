package com.revature.models;

public abstract class Cat implements Animal {

    public int whiskers;

    public abstract void makeNoise();

    public void sneeze() {
        System.out.println("ka chew :3");
    }

    public Cat(int whiskers) {
        this.whiskers = whiskers;
    }
}