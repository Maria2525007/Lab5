package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.interfaces.CollectionManagerInterface;
import utility.interfaces.QueueController;
import utility.TextFormatting;

import java.util.Queue;

/**
 * Class to print all elements from collection in stdout
 */
public class Show extends CommandAbstract implements QueueController {

    private final CollectionManagerInterface collectionManager;
    private final Queue<String> previousCommands;

    /**
     * Class constructor
     *
     * @param aCollectionManager - Class to work with collection
     * @param aPreviousCommands  - Variable to control previous commands
     */
    public Show(CollectionManager aCollectionManager, Queue<String> aPreviousCommands) {
        super("show");
        collectionManager = aCollectionManager;
        previousCommands = aPreviousCommands;
    }

    /**
     * We return execute status
     * <p>
     * (In future we can return collection and print on client)
     */
    @Override
    public Object execute(String aArg) {
        if (aArg.equals("")) {
            controlQueue(previousCommands, "show");

            if (collectionManager.getCollection().size() == 0)
                return TextFormatting.getRedText("\tCollection is empty!\n");
            StringBuilder sb = new StringBuilder();
            for (StudyGroup studyGroup : collectionManager.getCollection()) {
                sb.append(studyGroup);
                sb.append("------\n");
            }
            return sb.toString();
        } else {
            return TextFormatting.getRedText("\tArguments entered incorrectly\n");
        }
    }
}