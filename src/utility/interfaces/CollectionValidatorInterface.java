package utility.interfaces;

import data.StudyGroup;
import utility.FileWorker;

import java.util.HashSet;

public interface CollectionValidatorInterface {

    /**
     * Method to validate collection and return execution status
     *
     * @see FileWorker#getFromXmlFormat()
     */
    String validateCollection(HashSet<StudyGroup> inputCollection);
}