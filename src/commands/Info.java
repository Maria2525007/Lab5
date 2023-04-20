package commands;

import utility.CollectionManager;
import utility.interfaces.CollectionManagerInterface;
import utility.interfaces.QueueController;
import utility.TextFormatting;

import java.util.Queue;

/**
 * Class for displaying all information about collection
 */
public class Info extends CommandAbstract implements QueueController {

    private final CollectionManagerInterface collectionManager;
    private final Queue<String> previousCommands;

    /**
     * Class constructor
     *
     * @param aCollectionManager - Class to work with collection
     * @param aPreviousCommands  - Variable to control previous commands
     */
    public Info(CollectionManager aCollectionManager, Queue<String> aPreviousCommands) {
        super("info");
        collectionManager = aCollectionManager;
        previousCommands = aPreviousCommands;
    }

    /**
     * We return execute status
     * <p>
     * (In future we can return map of properties and their values)
     */
    @Override
    public Object execute(String aArg) {
        if (aArg.equals("")) {
            controlQueue(previousCommands, "info");

            return TextFormatting.getBlueText("\nInformation about collection:\n\n") + collectionManager.getInfo();
        } else {
            return TextFormatting.getRedText("\tArguments entered incorrectly\n");
        }
    }
}