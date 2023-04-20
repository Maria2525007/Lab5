package commands;

/**
 * Interface for commands
 */
public interface CommandInterface {

    /**
     * Method for print command's description
     */
    default String getDescription() {
        return this.getClass().getSimpleName();
    };

    /**
     * Method for execute command and return execution status
     */
    Object execute(String aArg);
}