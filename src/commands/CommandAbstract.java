package commands;

/**
 * Abstract class for commands
 */
public abstract class CommandAbstract implements CommandInterface {

    private final String name;

    /**
     * Class constructor
     *
     * @param aName - Command's name
     */
    public CommandAbstract(String aName) {
        name = aName;
    }

    /**
     * Method for print information about command
     *
     * @return String with command's name and description
     */

    /**
     * Universal method to executing commands
     */
    @Override
    public abstract Object execute(String aArg);
}
