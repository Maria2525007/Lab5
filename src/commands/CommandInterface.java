package commands;

/**
 * Interface for commands
 */
public interface CommandInterface {

    /**
     * Method for print command's description
     */
    String getDescription();

    /**
     * Method for execute command and return execution status
     */
    Object execute(String aArg);
}