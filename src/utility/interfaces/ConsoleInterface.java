package utility.interfaces;

import utility.FieldsReceiver;

import java.io.BufferedReader;

public interface ConsoleInterface {

    /**
     * Method to read fields from script
     */
    String readline();

    /**
     * Method to set console in script mode
     */
    void setScriptMode(BufferedReader aScriptReader);

    /**
     * Method to set console to Interactive mode
     */
    void setInteractiveStatus();

    /**
     * Return script execution status to understand how we should receive fields
     *
     * @see FieldsReceiver
     */
    boolean getExeStatus();

    /**
     * Print object in stdout
     *
     * @param anObject - Object, that we should print(usually String)
     */
    void print(Object anObject);

    /**
     * Read String from stdin
     *
     * @return null or not empty String
     */
    String read();

    /**
     * Check next line to find any symbol to avoid NullPointerException
     */
    boolean hasNextLine();
}