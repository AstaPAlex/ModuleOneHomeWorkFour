package org.example.homework.four.exfour;

public class Message {
    private final String text;
    private final TypeMessage typeMessage;
    private final String name;

    public Message(String text, TypeMessage typeMessage, String name) {
        this.text = text;
        this.typeMessage = typeMessage;
        this.name = name;
    }

    @Override
    public String toString() {
        return switch (typeMessage) {
            case INPUT -> "Письмо от " + name + ": " + text;
            case OUTPUT -> "Письмо к " + name + ": " + text;
        };
    }
}
