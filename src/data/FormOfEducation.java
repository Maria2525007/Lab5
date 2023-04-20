package data;

/**
 * Enum for study group form of education
 */
public enum FormOfEducation implements Comparable<FormOfEducation> {
    DISTANCE_EDUCATION("DISTANCE_EDUCATION", "distance_education"),
    FULL_TIME_EDUCATION("FULL_TIME_EDUCATION", "full_time_education"),
    EVENING_CLASSES("EVENING_CLASSES", "evening_classes");

    private final String stringInUpperCaseRepresentation;
    private final String stringInLowerCaseRepresentation;

    FormOfEducation(String aStringInUpperCaseRepresentation, String aStringInLowerCaseRepresentation) {
        stringInUpperCaseRepresentation = aStringInUpperCaseRepresentation;
        stringInLowerCaseRepresentation = aStringInLowerCaseRepresentation;
    }

    private String getStringInLowerCaseRepresentation() {
        return stringInLowerCaseRepresentation;
    }

    private String getStringInUpperCaseRepresentation() {
        return stringInUpperCaseRepresentation;
    }

    public static boolean isIncludeElement(String aFormOfEducation) {

        for (FormOfEducation currentFormOfEducation : FormOfEducation.values()) {
            if (aFormOfEducation.equals(currentFormOfEducation.getStringInUpperCaseRepresentation())) return true;
            if (aFormOfEducation.equals(currentFormOfEducation.getStringInLowerCaseRepresentation())) return true;
        }

        return false;
    }
}