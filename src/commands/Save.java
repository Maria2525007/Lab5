package commands;

import utility.FileWorker;
import utility.interfaces.FileWorkerInterface;
import utility.interfaces.QueueController;

import java.util.Queue;

/**
 * Class to save collection in xml file
 */
public class Save extends CommandAbstract implements QueueController {

    private final FileWorkerInterface fileWorker;
    private final Queue<String> previousCommands;

    /**
     * Class constructor
     *
     * @param aFileWorker       - Class to work with xml file(read and save)
     * @param aPreviousCommands - Variable to control previous commands
     */
    public Save(FileWorker aFileWorker, Queue<String> aPreviousCommands) {
        super("save", "save the collection to file");
        fileWorker = aFileWorker;
        previousCommands = aPreviousCommands;
    }

    /**
     * We return execute status
     * <p>
     * (In future also)
     */
    @Override
    public Object execute(String aArg) {
        controlQueue(previousCommands, "save");

        return fileWorker.saveToXml();
    }
}