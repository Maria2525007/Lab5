package utility;

import data.StudyGroup;
import utility.interfaces.CollectionManagerInterface;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

/**
 * Class to work with collection
 */
@XmlRootElement(name = "studyGroups")
public class CollectionManager implements CollectionManagerInterface {

    private HashSet<data.StudyGroup> studyGroups;
    private final HashSet<Integer> usedId;
    private final String initTime;

    public CollectionManager() {
        studyGroups = new HashSet<>();
        initTime = new Date().toString();
        usedId = new HashSet<>();
    }

    @Override
    public String getInfo() {

        return "Type of collection" + "  \t\t\t:\t" + "HashSet" + "\n" +
                "Type of collection items" + "\t\t:\t" + "Study groups" + "\n" +
                "Priority" + "\t\t\t\t:\t" + "Student's count" + "\n" +
                "Initialization date" + "\t\t\t:\t" + initTime + "\n" +
                "Number of items in te collection" + "\t:\t" + studyGroups.size() + "\n\n";
    }

    @Override
    public HashSet<StudyGroup> getCollection() {
        return studyGroups;
    }

    @Override
    public HashSet<Integer> getUsedId() {
        return usedId;
    }

    @Override
    @XmlElement(name = "studyGroup")
    public void setCollection(HashSet<StudyGroup> aStudyGroups) {
        studyGroups = aStudyGroups;
    }

    @Override
    public void add(StudyGroup studyGroup) {

        if (!usedId.add(studyGroup.getId())) studyGroups.remove(this.getId(studyGroup.getId()));

        if (studyGroups.add(studyGroup)) usedId.add(studyGroup.getId());
        else usedId.remove(studyGroup.getId());

    }

    @Override
    public void remove(StudyGroup studyGroup) {
        studyGroups.remove(studyGroup);
    }

    @Override
    public StudyGroup getMinStudentsCount() {
        if (studyGroups.size() == 0) return null;

        StudyGroup minimalGroup = null;

        for (StudyGroup studyGroup : studyGroups) {
            if (minimalGroup == null) {
                minimalGroup = studyGroup;
            } else if (studyGroup.getStudentsCount() < minimalGroup.getStudentsCount()) {
                minimalGroup = studyGroup;
            }
        }
        return minimalGroup;
    }

    @Override
    public StudyGroup getMin() {

        StudyGroup minGroup = null;

        for (StudyGroup studyGroup : studyGroups) {
            if (minGroup == null) {
                minGroup = studyGroup;
            } else {
                if (minGroup.compareTo(studyGroup) < 0) minGroup = studyGroup;
            }
        }

        return minGroup;
    }

    @Override
    public StudyGroup getMax() {

        StudyGroup maxGroup = null;

        for (StudyGroup studyGroup : studyGroups) {
            if (maxGroup == null) {
                maxGroup = studyGroup;
            } else {
                if (maxGroup.compareTo(studyGroup) > 0) maxGroup = studyGroup;
            }
        }
        return maxGroup;
    }

    @Override
    public StudyGroup getId(int key) {
        for (StudyGroup studyGroup : studyGroups) {
            if (studyGroup.getId() == key) return studyGroup;
        }
        return null;
    }

    @Override
    public void clear() {
        studyGroups.clear();
    }
}