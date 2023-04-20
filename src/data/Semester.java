package data;
/**
 * Enum for study group education semester
 */
public enum Semester {
    SECOND("SECOND", "second"),
    THIRD("THIRD", "third"),
    FOURTH("FOURTH", "fourth"),
    FIFTH("FIFTH", "fifth"),
    SIXTH("SIXTH", "sixth");

    private final String stringInUpperCaseRepresentation;
    private final String stringInLowerCaseRepresentation;

    Semester(String aStringInUpperCaseRepresentation, String aStringInLowerCaseRepresentation) {
        stringInUpperCaseRepresentation = aStringInUpperCaseRepresentation;
        stringInLowerCaseRepresentation = aStringInLowerCaseRepresentation;
    }

    private String getStringInLowerCaseRepresentation() {
        return stringInLowerCaseRepresentation;
    }

    private String getStringInUpperCaseRepresentation() {
        return stringInUpperCaseRepresentation;
    }

    public static boolean isIncludeElement(String aSemester) {

        for (Semester currentSemester : Semester.values()) {
            if (aSemester.equals(currentSemester.getStringInUpperCaseRepresentation())) return true;
            if (aSemester.equals(currentSemester.getStringInLowerCaseRepresentation())) return true;
        }
        return false;
    }
}