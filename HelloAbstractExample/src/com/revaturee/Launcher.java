package com.revaturee;

import com.revature.models.Cat;
import com.revature.models.Dog;
import com.revature.models.Snake;
public class Launcher {

    public static void main(String[] args) {
        Dog d = new Dog();

        d.makeNoise();
        d.eat();
        d.walk();

        System.out.println(d.isOrganic);

        Snake s = new Snake();

        s.makeNoise();
        s.eat();
        s.walk();

        System.out.println(s.isOrganic);

        Cat c = new Cat();

        c.makeNoise();
        c.eat();
        c.walk();

        System.out.println(c.isOrganic);

    }

}
