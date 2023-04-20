package utility;

public class CommandInit {

    private final String commandName;
    private final String argName;

    public CommandInit(String aCommandName, String anArgName) {
        commandName = aCommandName;
        argName = anArgName;
    }

    public String getCommandName() {
        return commandName;
    }

    public String getArgName() {
        return argName;
    }

    @Override
    public String toString() {
        return "[" + commandName + "], [" + argName + "]";
    }
}