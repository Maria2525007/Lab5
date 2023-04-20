package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.interfaces.CollectionManagerInterface;
import utility.interfaces.FieldsProtectorInterface;
import utility.interfaces.QueueController;
import utility.TextFormatting;

import java.util.Queue;

/**
 * Class that remove object with current id from collection
 */
public class RemoveById extends CommandAbstract implements FieldsProtectorInterface, QueueController {

    private final CollectionManagerInterface collectionManager;
    private final Queue<String> previousCommands;

    /**
     * Class constructor
     *
     * @param aCollectionManager - Class to work with collection
     * @param aPreviousCommands  - Variable to control previous commands
     */
    public RemoveById(CollectionManager aCollectionManager, Queue<String> aPreviousCommands) {
        super("remove_by_id", "remove an element from the collection by ID." +
                TextFormatting.getBlueText("\n\tYou should to enter ID after entering a command"));
        collectionManager = aCollectionManager;
        previousCommands = aPreviousCommands;
    }

    /**
     * We return execute status
     * <p>
     * (In future we can return collection without removed object)
     */
    @Override
    public Object execute(String aArg) {
        if (isPositiveInt(aArg)) {
            controlQueue(previousCommands, "remove_by_id");

            StudyGroup studyGroup = collectionManager.getId(Integer.parseInt(aArg));

            if (studyGroup != null) collectionManager.remove(studyGroup);
            else return TextFormatting.getRedText("\tAn object with this id does not exist!\n");

            return TextFormatting.getGreenText("\n\tObject has been removed!\n\n");
        }

        return TextFormatting.getRedText("\tId should be not null positive integer!\n");
    }
}