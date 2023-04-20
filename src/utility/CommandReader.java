package utility;

import utility.interfaces.CommandReaderInterface;
import utility.interfaces.ConsoleInterface;
import utility.interfaces.InvokerInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CommandReader read and parse strings from input to commands and arguments
 */
public class CommandReader implements CommandReaderInterface {

    private final ConsoleInterface console;
    private final InvokerInterface invoker;


    public CommandReader(InvokerInterface aInvoker) {
        console = aInvoker.getConsole();

        invoker = aInvoker;
    }

    @Override
    public void enable() {

        String nextLine = "";

        while (!nextLine.equals("exit ")) {

            console.print("Enter the command: ");

            nextLine = console.read() + " ";

            CommandInit newCommand = readCommand(nextLine);

            if (newCommand == null) console.print(TextFormatting.getRedText("\tCommand entered incorrectly!\n"));
            else if (newCommand.getCommandName().equals("exit") && newCommand.getArgName().equals("")) {
                console.print(TextFormatting.getGreenText("\tThank you for working in this program!\n"));
                System.exit(0);
            } else invoker.execute(newCommand);
        }
    }

    @Override
    public CommandInit readCommand(String anInputString) {

        String command;
        String arg;
        String inputString = anInputString;
        Pattern commandName = Pattern.compile("^\\w+\\s+");
        Pattern argName = Pattern.compile("^.+");

        Matcher matcher = commandName.matcher(inputString);

        if (matcher.find()) {
            command = matcher.group();
        } else {
            return null;
        }

        inputString = inputString.substring(command.length());
        matcher = argName.matcher(inputString);

        arg = matcher.find() ? matcher.group() : "";

        return new CommandInit(command.trim(), arg.trim());
    }
}