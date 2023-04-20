package utility.interfaces;

import utility.CommandInit;
import utility.Console;

public interface InvokerInterface {

    /**
     * Method to execute command
     */
    void execute(CommandInit commandInit);

    /**
     * Method to add script path in executed scripts to catch recursion
     */
    boolean addScriptPath(String anArg);

    /**
     * Method to remove script path from executed scripts
     */
    void removeScriptPath(String anArg);

    /**
     * Method to get console from invoker
     */
    Console getConsole();
}