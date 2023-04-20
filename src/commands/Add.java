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
 * Class for read study group from console and add this in collection
 */
public class Add extends CommandAbstract implements QueueController {

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
    public Add(StudyGroupFactory aStudyGroupFactory, CollectionManager aCollectionManager, Queue<String> aPreviousCommands) {
        super("add", "add new element to the collection");
        studyGroupFactory = aStudyGroupFactory;
        collectionManager = aCollectionManager;
        previousCommands = aPreviousCommands;
    }

    /**
     * We returning status of execute
     * <p>
     * (In future we can return collection with added object)
     */
    @Override
    public Object execute(String aArg) {
        if (aArg.equals("")) {

            controlQueue(previousCommands, "add");

            StudyGroup studyGroup = studyGroupFactory.createStudyGroup();

            if (studyGroup != null) {
                collectionManager.add(studyGroup);
                return TextFormatting.getGreenText("\n\tStudy group has been added!\n\n");
            } else
                return TextFormatting.getRedText("\n\tObject hasn't been added!(fields were entered incorrectly)\n\n");
        } else {
            return TextFormatting.getRedText("\tCommand arguments entered incorrectly!\n");
        }
        /**
         * Добавить про несоответсвие полей при скриптомов режиме
         */
    }
}