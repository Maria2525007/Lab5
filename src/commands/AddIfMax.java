package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.interfaces.CollectionManagerInterface;
import utility.interfaces.QueueController;
import utility.interfaces.StudyGroupFactoryInterface;
import utility.StudyGroupFactory;
import utility.TextFormatting;

import java.util.Queue;

/**
 * Class for add maximum element in collection
 */
public class AddIfMax extends CommandAbstract implements QueueController {

    private final StudyGroupFactoryInterface studyGroupFactory;
    private final CollectionManagerInterface collectionManager;
    private final Queue<String> previousCommands;

    /**
     * Class constructor
     *
     * @param aStudyGroupFactory - Class for read fields from stdin
     * @param aCollectionManager - Class for add new element into collection
     * @param aPreviousCommands  - Variable to control previous commands
     */
    public AddIfMax(StudyGroupFactory aStudyGroupFactory, CollectionManager aCollectionManager, Queue<String> aPreviousCommands) {
        super("add_if_max", "add new element to the collection, if it`s greater, " +
                "than biggest element of this collection.");
        studyGroupFactory = aStudyGroupFactory;
        collectionManager = aCollectionManager;
        previousCommands = aPreviousCommands;
    }

    /**
     * We return status of execute and add maximal element in main collection
     * <p>
     * (In future we can return collection with added object or error message)
     */
    @Override
    public Object execute(String aArg) {
        if (aArg.equals("")) {

            controlQueue(previousCommands, "add_if_max");

            StudyGroup inputStudyGroup = studyGroupFactory.createStudyGroup();

            if (inputStudyGroup != null) {
                if (collectionManager.getMax() != null) {
                    if (inputStudyGroup.compareTo(collectionManager.getMax()) <= 0)
                        return TextFormatting.getRedText("\tStudy group isn't best!\n\n");
                }

                collectionManager.add(inputStudyGroup);
                return TextFormatting.getGreenText("\n\n\tStudy group has been added!\n\n");
            } else {
                return TextFormatting.getRedText("\n\tObject hasn't been added!(fields were entered incorrectly)\n\n");
            }
        } else {
            return TextFormatting.getRedText("\tCommand arguments entered incorrectly!\n");
        }
    }
}