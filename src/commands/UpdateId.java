package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.interfaces.CollectionManagerInterface;
import utility.interfaces.FieldsProtectorInterface;
import utility.interfaces.QueueController;
import utility.interfaces.StudyGroupFactoryInterface;
import utility.StudyGroupFactory;
import utility.TextFormatting;

import java.util.Queue;

/**
 * Class to update study groups in collection by id(set new fields)
 */
public class UpdateId extends CommandAbstract implements FieldsProtectorInterface, QueueController {

    private final StudyGroupFactoryInterface studyGroupFactory;
    private final CollectionManagerInterface collectionManager;
    private final Queue<String> previousCommands;

    /**
     * Class constructor
     *
     * @param aStudyGroupFactory - Class to create new study group
     * @param aCollectionManager - Class to work with collection
     * @param aPreviousCommands  - Variable to control previous commands
     */
    public UpdateId(StudyGroupFactory aStudyGroupFactory, CollectionManager aCollectionManager, Queue<String> aPreviousCommands) {
        super("update");
        studyGroupFactory = aStudyGroupFactory;
        collectionManager = aCollectionManager;
        previousCommands = aPreviousCommands;
    }

    /**
     * We return execute status
     * <p>
     * (In future we can return updated collection)
     */
    @Override
    public Object execute(String aArg) {
        if (isPositiveInt(aArg)) {
            controlQueue(previousCommands, "update");

            StudyGroup studyGroup = collectionManager.getId(Integer.parseInt(aArg));

            if (studyGroup != null) collectionManager.remove(studyGroup);
            else return TextFormatting.getRedText("\tAn object with this id does not exist!\n");

            StudyGroup upgradingGroup = studyGroupFactory.createStudyGroup();
            upgradingGroup.setId(Integer.parseInt(aArg));
            collectionManager.add(upgradingGroup);

            return TextFormatting.getGreenText("\n\tObject has been updated!\n\n");
        }
        return TextFormatting.getRedText("\tId should be not null positive integer!\n");
    }
}