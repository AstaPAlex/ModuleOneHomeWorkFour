package org.example.homework.four.exfour;

public class User {
    private final String name;
    private String password;
    private Message[] messages;
    private int countMessage;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        messages = new Message[100];
        countMessage = 0;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void addMessage(Message message) {
        messages[countMessage] = message;
        countMessage++;
    }

    public Message[] getMessages() {
        return messages;
    }

    public int getCountMessage() {
        return countMessage;
    }
}
