package commands;

import utility.interfaces.InvokerInterface;
import utility.interfaces.QueueController;
import utility.Invoker;
import utility.ScriptReader;
import utility.TextFormatting;

import java.io.*;
import java.util.Queue;

/**
 * Class for validation script path, check script status and check it for recursion
 */
public class ExecuteScript extends CommandAbstract implements QueueController {

    private final InvokerInterface invoker;
    private final Queue<String> previousCommands;

    /**
     * Class constructor
     *
     * @param aInvoker          - Proxy class for call command's classes
     * @param aPreviousCommands - Variable to control previous commands
     */
    public ExecuteScript(Invoker aInvoker, Queue<String> aPreviousCommands) {
        super("execute_script", "Read and execute script from entered file" +
                TextFormatting.getBlueText("\n\tYou should to enter script name after entering a command"));
        invoker = aInvoker;
        previousCommands = aPreviousCommands;
    }

    /**
     * We return status of execute
     * <p>
     * (In future we can return list of commands from script)
     */
    @Override
    public Object execute(String aArg) {
        if (aArg.equals("")) return TextFormatting.getRedText("\tYou should write script path!\n");
        else {
            File file = new File(aArg);
            if (file.exists() && !file.canRead())
                return "Невозможно выполнить данную команду, так как у указанного файла отсутвуют права на чтение";

            if (!(invoker.addScriptPath(aArg))) return TextFormatting.getRedText("\n\tRecursion has been found in " +
                    "command: execute_script " + aArg + "!" +
                    " Please correct your script!\n\n");
            else {
                invoker.addScriptPath(aArg);

                try {
                    BufferedReader scriptBufferedReader = new BufferedReader(new FileReader(aArg));
                    ScriptReader scriptReader = new ScriptReader(scriptBufferedReader, invoker);
                    controlQueue(previousCommands, "execute_script");
                    scriptReader.read();
                    scriptBufferedReader.close();
                } catch (FileNotFoundException e) {
                    return TextFormatting.getRedText("\tFile not found!\n");
                } catch (IOException e) {
                    return TextFormatting.getRedText("\n\tInput or Output error!\n");
                }
                invoker.removeScriptPath(aArg);
                invoker.getConsole().setInteractiveStatus();
                return TextFormatting.getGreenText("\n\tThe script " + aArg + " was processed successfully!\n\n");
            }
        }
    }
}