package org.example.homework.four.exfour;

public enum TypeMessage {
    INPUT("Входящее"), OUTPUT("Исходящее");
    private String typeMessage;

    TypeMessage(String typeMessage) {
        this.typeMessage = typeMessage;
    }

    public String getTypeMessage() {
        return typeMessage;
    }
}
