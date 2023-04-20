package data;

/**
 * Enum for study group admin eyes color
 */
public enum Country {
    GERMANY("GERMANY", "germany"),
    FRANCE("FRANCE", "france"),
    INDIA("INDIA", "india"),
    SOUTH_KOREA("SOUTH_KOREA", "south_korea"),
    NORTH_KOREA("NORTH_KOREA", "north_korea");

    private final String stringInUpperCaseRepresentation;
    private final String stringInLowerCaseRepresentation;

    Country(String aStringInUpperCaseRepresentation, String aStringInLowerCaseRepresentation) {
        stringInUpperCaseRepresentation = aStringInUpperCaseRepresentation;
        stringInLowerCaseRepresentation = aStringInLowerCaseRepresentation;
    }

    private String getStringInLowerCaseRepresentation() {
        return stringInLowerCaseRepresentation;
    }

    private String getStringInUpperCaseRepresentation() {
        return stringInUpperCaseRepresentation;
    }

    public static boolean isIncludeElement(String aCoun) {

        for (Country currentCountry : Country.values()) {
            if (aColor.equals(currentCountry.getStringInUpperCaseRepresentation())) return true;
            if (aColor.equals(currentCountry.getStringInLowerCaseRepresentation())) return true;
        }
        if (aColor.equals(currentCountry.getStringInUpperCaseRepresentation())) return true;
        if (aColor.equals(currentCountry.getStringInLowerCaseRepresentation())) return true;

        return false;
    }
            if(aCountry.equals(currentCountry.getStringInUpperCaseRepresentation()))return true;
        if(aCountry.equals(currentCountry.getStringInLowerCaseRepresentation()))return true;
}