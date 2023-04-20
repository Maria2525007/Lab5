package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.interfaces.QueueController;
import utility.TextFormatting;

import java.util.HashSet;
import java.util.Queue;

/**
 * Class for print elements which name field starts with special substring
 */
public class FilterStartsWithName extends CommandAbstract implements QueueController {

    private final HashSet<StudyGroup> collection;
    private final Queue<String> previousCommands;

    /**
     * Class constructor
     *
     * @param aCollectionManager - Class to work with collection
     * @param aPreviousCommands  - Variable to control previous commands
     */
    public FilterStartsWithName(CollectionManager aCollectionManager, Queue<String> aPreviousCommands) {
        super("filter_starts_with_name");
        collection = aCollectionManager.getCollection();
        previousCommands = aPreviousCommands;
    }

    /**
     * We return list of study groups in string representation
     * <p>
     * (In future we can return ArrayList of names or error message)
     */
    public Object execute(String aArg) {
        if (!aArg.equals("")) {

            controlQueue(previousCommands, "filter_starts_with_name");

            if (collection.size() == 0) return TextFormatting.getRedText("\tCollection is empty!\n");

            StringBuilder sb = new StringBuilder();
            for (StudyGroup studyGroup : collection) {
                if (studyGroup.getName().startsWith(aArg)) sb.append(studyGroup).append("------\n");
            }
            if (sb.toString().equals("")) return TextFormatting.getRedText("\tNo objects found!\n");

            return sb.toString();

        } else {
            return TextFormatting.getRedText("\tSubstring should be not empty!\n");
        }
    }
}