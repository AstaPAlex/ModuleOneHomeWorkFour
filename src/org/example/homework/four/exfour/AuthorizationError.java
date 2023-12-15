package org.example.homework.four.exfour;

public class AuthorizationError  extends Exception {
    public AuthorizationError() {
        super("Вы не авторизованы!");
    }
}
