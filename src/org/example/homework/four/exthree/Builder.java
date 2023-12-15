package org.example.homework.four.exthree;

public class Builder extends Human {
    @Override
    public String makeSound() {
        return "Я строитель. " + super.makeSound();
    }
}
