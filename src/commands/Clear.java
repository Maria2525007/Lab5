package commands;
import utility.CollectionManager;
import utility.interfaces.CollectionManagerInterface;
import utility.interfaces.QueueController;
import utility.TextFormatting;

import java.util.Queue;

/**
 * Class for remove all elements from collection
 */
public class Clear extends CommandAbstract implements QueueController {

    private final CollectionManagerInterface collectionManager;
    private final Queue<String> previousCommands;

    /**
     * Class constructor
     *
     * @param aCollectionManager - Class for work with collection
     * @param aPreviousCommands  - Variable to control previous commands
     */
    public Clear(CollectionManager aCollectionManager, Queue<String> aPreviousCommands) {
        super("clear", "clear the collection");
        collectionManager = aCollectionManager;
        previousCommands = aPreviousCommands;
    }

    /**
     * We return status of execute and main collection
     * <p>
     * (in future we can return empty collection)
     */
    @Override
    public Object execute(String aArg) {
        if (aArg.equals("")) {

            controlQueue(previousCommands, "clear");

            collectionManager.clear();
            return TextFormatting.getGreenText("\n\tSuccessful!\n\n");
        } else {
            return TextFormatting.getRedText("Command arguments entered incorrectly!\n");
        }
    }
}