package org.example.homework.four.exfour;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OneGramChat {
    private static final String TEXT_CREATE_USER = "Вы создаете нового пользователя!\n";
    private static final String TEXT_LOG_IN_USER = "Вы входите в систему!\n";
    private static final String TEXT_ADDRESS_EMAIL = "Введите имя пользователя, кому хотите"
            + " отправить сообщение и нажмите 'Enter'!\n";
    private static final String TEXT_MESSAGE = "Введите сообщение!\n";
    private static final String TEXT_INFO_LOGIN_TYPING = """
            Введите имя пользователя и нажмите 'Enter'!
            Введите пароль и нажмите 'Enter'!""";
    private static final String COMMAND_CHAT = """
            "войти" - запуск функции "войти пользователю"
            "новый" - запуск функции "создать пользователя"
            "выйти" - запуск функции "выйти пользователю"
            "написать" - запуск функции "написать письмо"
            "прочитать" - запуск функции "прочитать письмо"
            "exit" - окончание работы программы""";
    private static final String NO_MESSAGE = "Сообщений нет!";
    private static final String TEXT_NO_USER = "Пользователь не выбран!";
    private static final String TEXT_NEW_USER = "Пользователь создан!";
    private static final String TEXT_AUTHORIZATION_USER = "Пользователь авторизован!";
    private static final String TEXT_LETTER = "Сообщение отправлено!";
    public static final Scanner scanner = new Scanner(System.in);
    private final List<User> listUsers;
    private User selectedUser;

    public OneGramChat() {
        this.listUsers = new ArrayList<>();
        this.selectedUser = null;
    }

    public void startChat() {
        while (true) {
            Command command = selectCommand();
            if (command == null) {
                continue;
            }
            switch (command) {
                case NEW_USER -> createUser();
                case LOGIN -> logInUser();
                case LOGOUT -> exitUser();
                case WRITE -> writeLetter();
                case READ -> readMessage();
                case EXIT -> {
                    return;
                }
                default -> {
                }
            }
        }
    }

    private Command selectCommand() {
        System.out.println(COMMAND_CHAT);
        try {
            return Command.fromString(typingText());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private String typingText() {
        while (true) {
            String str;
            try {
                str = scanner.nextLine();
                isEmpty(str);
            } catch (IsEmptyTypingException e) {
                System.out.println(e.getMessage());
                continue;
            }
            return str;
        }
    }

    private void isEmpty(String text) throws IsEmptyTypingException {
        if (text.isEmpty()) {
            throw new IsEmptyTypingException();
        }
    }

    private void createUser() {
        System.out.println(TEXT_CREATE_USER + TEXT_INFO_LOGIN_TYPING);
        String name = typingText();
        String password = typingText();
        listUsers.add(new User(name, password));
        System.out.println(TEXT_NEW_USER);
    }

    private void logInUser() {
        System.out.println(TEXT_LOG_IN_USER + TEXT_INFO_LOGIN_TYPING);
        String name = typingText();
        String password = typingText();
        try {
            selectedUser = verificationUser(name, password);
        } catch (NoUserInList e) {
            System.out.println(e.getMessage());
        }
        System.out.println(TEXT_AUTHORIZATION_USER);
    }

    private User verificationUser(String name, String password) throws NoUserInList {
        for (User user : listUsers) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new NoUserInList();
    }

    private User verificationUser(String name) throws NoUserInList {
        for (User user : listUsers) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        throw new NoUserInList();
    }

    private void exitUser() {
        selectedUser = null;
        System.out.println(TEXT_NO_USER);
    }

    private void checkAuthorization() throws AuthorizationError {
        if (selectedUser == null) {
            throw new AuthorizationError();
        }
    }

    private void writeLetter() {
        try {
            checkAuthorization();
        } catch (AuthorizationError e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(TEXT_ADDRESS_EMAIL);
        User userTo;
        try {
            userTo = verificationUser(typingText());
        } catch (NoUserInList e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(TEXT_MESSAGE);
        String message = typingText();
        selectedUser.addMessage(new Message(message, TypeMessage.OUTPUT, userTo.getName()));
        userTo.addMessage(new Message(message, TypeMessage.INPUT, selectedUser.getName()));
        System.out.println(TEXT_LETTER);
    }

    private void readMessage() {
        try {
            checkAuthorization();
        } catch (AuthorizationError e) {
            System.out.println(e.getMessage());
            return;
        }
        if (selectedUser.getCountMessage() == 0) {
            System.out.println(NO_MESSAGE);
            return;
        }
        for (int i = 0; i < selectedUser.getCountMessage(); i++) {
            System.out.println(selectedUser.getMessages()[i]);
        }
    }

}
