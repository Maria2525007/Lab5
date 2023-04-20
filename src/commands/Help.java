package commands;

import utility.interfaces.QueueController;
import utility.TextFormatting;

import java.util.Map;
import java.util.Queue;

/**
 * Class for displaying all commands with explanations
 */
public class Help extends CommandAbstract implements QueueController {

    private final Map<String, CommandAbstract> commandsInfo;
    private final Queue<String> previousCommands;

    /**
     * Class constructor
     *
     * @param aCommands         - Map of command's name and their classes
     * @param aPreviousCommands - Variable to control previous commands
     */
    public Help(Map<String, CommandAbstract> aCommands, Queue<String> aPreviousCommands) {
        super("help", "display help for available commands");
        commandsInfo = aCommands;
        previousCommands = aPreviousCommands;
    }

    /**
     * We return list of commands
     * <p>
     * (In future we can return map of commands and their descriptions)
     */
    @Override
    public Object execute(String aArg) {

        if (aArg.equals("")) {

            controlQueue(previousCommands, "help");

            StringBuilder sb = new StringBuilder();
            sb.append(TextFormatting.getBlueText("\nList of commands:\n\n"));
            for (String i : commandsInfo.keySet()) {
                sb.append("\t").append(commandsInfo.get(i).getDescription()).append("\n\n");
            }
            sb.append("\t").append("exit : end the program (without saving it to a file)").append("\n\n");
            return sb.toString();
        } else {
            return TextFormatting.getRedText("\tArguments entered incorrectly\n");
        }
    }
}