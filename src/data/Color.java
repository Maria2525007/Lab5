package data;

/**
 * Enum for study group admin eyes color
 */
public enum Color {
    BLACK("BLACK", "black"),
    BLUE("BLUE", "blue"),
    YELLOW("YELLOW", "yellow"),
    WHITE("WHITE", "white"),
    BROWN("BROWN", "brown");

    private final String stringInUpperCaseRepresentation;
    private final String stringInLowerCaseRepresentation;

    Color(String aStringInUpperCaseRepresentation, String aStringInLowerCaseRepresentation) {
        stringInUpperCaseRepresentation = aStringInUpperCaseRepresentation;
        stringInLowerCaseRepresentation = aStringInLowerCaseRepresentation;
    }

    private String getStringInLowerCaseRepresentation() {
        return stringInLowerCaseRepresentation;
    }

    private String getStringInUpperCaseRepresentation() {
        return stringInUpperCaseRepresentation;
    }

    public static boolean isIncludeElement(String aColor) {

        for (Color currentColor : Color.values()) {
            if (aColor.equals(currentColor.getStringInUpperCaseRepresentation())) return true;
            if (aColor.equals(currentColor.getStringInLowerCaseRepresentation())) return true;
        }

        return false;
    }
}
