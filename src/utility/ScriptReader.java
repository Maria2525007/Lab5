package utility;

import utility.interfaces.CommandReaderInterface;
import utility.interfaces.InvokerInterface;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Class for reading script and executing commands in script mode
 */
public class ScriptReader {

    private final BufferedReader scriptBufferedReader;
    private final InvokerInterface invoker;
    private final CommandReaderInterface commandReader;
    private final Console console;

    /**
     * Class constructor
     *
     * @param aScriptBufferedReader - Class for read text from a character-input stream(script)
     * @param aInvoker              - Proxy class for call command's classes
     */
    public ScriptReader(BufferedReader aScriptBufferedReader, InvokerInterface aInvoker) {
        scriptBufferedReader = aScriptBufferedReader;
        invoker = aInvoker;
        commandReader = new CommandReader(invoker);
        console = invoker.getConsole();
    }

    public void read() {
        console.print("\n");
        String nextLine = null;
        CommandInit nextCommand;

        do {
            console.setScriptMode(scriptBufferedReader);
            nextCommand = null;
            try {
                nextLine = scriptBufferedReader.readLine();

                if (nextLine != null) nextCommand = commandReader.readCommand(nextLine + " ");
            } catch (IOException e) {
                console.print(TextFormatting.getRedText("\n\tInput or Output error!\n"));
                break;
            }
            if (nextCommand != null) {
                invoker.execute(nextCommand);
            } else if (nextLine != null) console.print(TextFormatting.getRedText("\n\tCommand entered incorrectly!\n"));

        } while (nextLine != null);
    }
}