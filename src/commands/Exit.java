package commands;

import java.util.Queue;

public class Exit extends CommandAbstract {

    /**
     * Class constructor
     *
     * @param aName - Command's name
     */
    public Exit(String aName) {
        super(aName);
    }
    public Exit(Queue<String> previousCommands) {
        super();

    }

    @Override
    public Object execute(String aArg) {
        return null;
    }
}