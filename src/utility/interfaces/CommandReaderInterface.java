package utility.interfaces;

import utility.CommandInit;

public interface CommandReaderInterface {

    /**
     * Method to enable line entry
     */
    void enable();

    /**
     * Class to receive command with argument and return command structure or command status message
     */
    CommandInit readCommand(String anInputString);
}