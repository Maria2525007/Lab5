package commands;

import utility.interfaces.QueueController;
import utility.TextFormatting;

import java.util.Queue;

/**
 * Class for displaying last 14 commands
 */
public class History extends CommandAbstract implements QueueController {

    Queue<String> previousCommands;

    /**
     * Class constructor
     *
     * @param aPreviousCommands - Queue of last 14 commands
     * @param aPreviousCommands - Variable to control previous commands
     */
    public History(Queue<String> aPreviousCommands) {
        super("history", "print the last 14 commands (without their arguments)");
        previousCommands = aPreviousCommands;
    }

    /**
     * We return execute status
     * <p>
     * (in future we can return queue of last 14 commands and print on client)
     */
    @Override
    public Object execute(String aArg) {
        if (aArg.equals("")) {
            controlQueue(previousCommands, "history");

            int i = 0;
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            for (String command : previousCommands) {
                sb.append(++i).append(") ").append(command).append("\n");
            }
            return sb.toString();
        } else {
            return TextFormatting.getRedText("\tArguments entered incorrectly\n");
        }
    }
}