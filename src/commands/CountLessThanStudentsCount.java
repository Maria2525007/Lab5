package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.interfaces.CollectionManagerInterface;
import utility.interfaces.FieldsProtectorInterface;
import utility.interfaces.QueueController;
import utility.TextFormatting;

import java.util.HashSet;
import java.util.Queue;

/**
 * Class for count elements whose less than specified amount of students count
 */
public class CountLessThanStudentsCount extends CommandAbstract implements FieldsProtectorInterface, QueueController {

    private final CollectionManagerInterface collectionManager;
    private final Queue<String> previousCommands;

    /**
     * Class constructor
     *
     * @param aCollectionManager - Class to work with collection
     * @param aPreviousCommands  - Variable to control previous commands
     */
    public CountLessThanStudentsCount(CollectionManager aCollectionManager, Queue<String> aPreviousCommands) {
        super("count_less_than_students_count", "print the number of elements whose "
                + "studentsCount field value is less than the specified one" +
                TextFormatting.getBlueText("\n\tYou should to enter students count after entering a command"));
        collectionManager = aCollectionManager;
        previousCommands = aPreviousCommands;
    }

    /**
     * We return count of study groups in string representation
     * <p>
     * (In future we can return Integer number or error message)
     */
    @Override
    public Object execute(String aArg) {
        HashSet<StudyGroup> collection = collectionManager.getCollection();

        if (collection.size() == 0) return TextFormatting.getRedText("\tCollection is empty!\n");

        if (isPositiveInt(aArg)) {

            controlQueue(previousCommands, "count_less_than_students_count");

            int i = 0;
            for (StudyGroup studyGroup : collection) {
                if (studyGroup.getStudentsCount() < Integer.parseInt(aArg)) i++;
            }
            return TextFormatting.getGreenText("\tAmount of elements: " + i + "\n");
        }

        return TextFormatting.getRedText("\tStudent's count should be not null positive integer number\n");
    }
}