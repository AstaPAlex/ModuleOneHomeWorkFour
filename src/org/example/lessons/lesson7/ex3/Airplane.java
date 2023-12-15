package org.example.lessons.lesson7.ex3;

public class Airplane extends Mechanics implements FlyableDrive {

    public void fly() {
        System.out.println("Самолет летит");
    }

    @Override
    public void go() {
        System.out.println("самолет едет");
    }

    @Override
    public void repair() {
        System.out.println("чиним самолет");
    }
}
