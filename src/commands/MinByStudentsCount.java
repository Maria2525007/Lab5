package commands;

import utility.CollectionManager;
import utility.interfaces.CollectionManagerInterface;
import utility.interfaces.QueueController;
import utility.TextFormatting;

import java.util.Queue;

/**
 * Class print object form collection
 */
public class MinByStudentsCount extends CommandAbstract implements QueueController {

    private final CollectionManagerInterface collectionManager;
    private final Queue<String> previousCommands;

    /**
     * Class constructor
     *
     * @param aCollectionManager - Class to work with collection
     * @param aPreviousCommands  - Variable to control previous commands
     */
    public MinByStudentsCount(CollectionManager aCollectionManager, Queue<String> aPreviousCommands) {
        super("min_by_students_count", "print any object from the collection whose " +
                "studentsCount field value is minimal");
        collectionManager = aCollectionManager;
        previousCommands = aPreviousCommands;
    }

    /**
     * We return execute status
     * <p>
     * (In future we can return min object from collection and print on client)
     */
    @Override
    public Object execute(String aArg) {
        if (aArg.equals("")) {
            controlQueue(previousCommands, "min_by_students_count");

            if (collectionManager.getMinStudentsCount() != null) return collectionManager.getMinStudentsCount().
                    toString();
            else return TextFormatting.getRedText("\tThere are no study groups in the collection yet!\n");
        } else {
            return TextFormatting.getRedText("\tArguments entered incorrectly!\n");
        }
    }
}