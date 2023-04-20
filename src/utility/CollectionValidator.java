package utility;

import data.StudyGroup;
import utility.interfaces.CollectionManagerInterface;
import utility.interfaces.CollectionValidatorInterface;
import utility.interfaces.ObjectValidator;

import java.util.HashSet;

/**
 * Class to validate objects from xml file and add correct study groups in collection
 */
public class CollectionValidator implements CollectionValidatorInterface, ObjectValidator {

    CollectionManagerInterface collectionManager;

    /**
     * Class constructor
     *
     * @param aCollectionManager - Class for add new element into collection
     */
    public CollectionValidator(CollectionManager aCollectionManager) {
        collectionManager = aCollectionManager;
    }

    @Override
    public String validateCollection(HashSet<StudyGroup> inputCollection) {

        for (StudyGroup studyGroup : inputCollection) {

            if (validateObject(studyGroup)) collectionManager.add(studyGroup);
            else return TextFormatting.getGreenText("\n\tXml file has been broken!(not all objects was loaded)\n\n");
        }
        return TextFormatting.getGreenText("\n\tCollection was loaded!\n\n");
    }
}