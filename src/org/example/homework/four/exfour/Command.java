package org.example.homework.four.exfour;

public enum Command {
    LOGIN("войти"), NEW_USER("новый"), EXIT("exit"),
    WRITE("написать"), READ("прочитать"), LOGOUT("выйти");

    private static final String TEXT_NO_COMMAND = "Такой команды нет";
    private final String commandName;


    Command(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }


    public static Command fromString(String value) throws IllegalArgumentException {
        if (value != null) {
            for (Command command : Command.values()) {
                if (value.equalsIgnoreCase(command.getCommandName())) {
                    return command;
                }
            }
        }
        throw new IllegalArgumentException(TEXT_NO_COMMAND);
    }
}
