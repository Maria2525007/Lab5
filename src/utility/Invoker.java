package utility;

import commands.*;
import utility.interfaces.FieldsProtectorInterface;
import utility.interfaces.InvokerInterface;

import java.util.*;

/**
 * Proxy class to redirect commands and write the executed commands to the queue
 */
public class Invoker implements InvokerInterface, FieldsProtectorInterface {

    private final Console console;
    private final CollectionManager collectionManager;
    private final Map<String, CommandAbstract> commands;
    private final StudyGroupFactory studyGroupFactory;
    private final Queue<String> previousCommands;
    private final Set<String> executedScripts;
    private final FileWorker fileWorker;

    /**
     * Class construct
     *
     * @param aConsole           - Class to print and read information
     * @param aCollectionManager - Class for add new element into collection
     */
    public Invoker(Console aConsole, CollectionManager aCollectionManager) {

        console = aConsole;
        FieldsReceiver fieldsReceiver = new FieldsReceiver(aConsole);
        collectionManager = aCollectionManager;
        studyGroupFactory = new StudyGroupFactory(fieldsReceiver, collectionManager);
        commands = new HashMap<>();
        previousCommands = new LinkedList<>();
        executedScripts = new HashSet<>();
        fileWorker = new FileWorker(collectionManager, console);
        initMap();
    }

    @Override
    public void execute(CommandInit newCommand) {
        String aCommand = newCommand.getCommandName();
        String aArg = newCommand.getArgName();

        if (commands.containsKey(aCommand)) {

            console.print(commands.get(aCommand).execute(aArg));
        } else {
            console.print(TextFormatting.getRedText("\tCommand not found. Please, try again!\n"));
        }
    }

    @Override
    public boolean addScriptPath(String anArg) {

        return executedScripts.add(anArg);
    }

    @Override
    public void removeScriptPath(String anArg) {
        executedScripts.remove(anArg);
    }

    @Override
    public Console getConsole() {
        return console;
    }

    private void initMap() {
        commands.put("help", new Help(commands, previousCommands));
        commands.put("info", new Info(collectionManager, previousCommands));
        commands.put("show", new Show(collectionManager, previousCommands));
        commands.put("add", new Add(studyGroupFactory, collectionManager, previousCommands));
        commands.put("update", new UpdateId(studyGroupFactory, collectionManager, previousCommands));
        commands.put("remove_by_id", new RemoveById(collectionManager, previousCommands));
        commands.put("clear", new Clear(collectionManager, previousCommands));
        commands.put("save", new Save(fileWorker, previousCommands));
        commands.put("execute_script", new ExecuteScript(this, previousCommands));
        commands.put("add_if_max", new AddIfMax(studyGroupFactory, collectionManager, previousCommands));
        commands.put("add_if_min", new AddIfMin(studyGroupFactory, collectionManager, previousCommands));
        commands.put("history", new History(previousCommands));
        commands.put("min_by_students_count", new MinByStudentsCount(collectionManager, previousCommands));
        commands.put("count_less_than_students_count", new CountLessThanStudentsCount(collectionManager,
                previousCommands));
        commands.put("filter_starts_with_name", new FilterStartsWithName(collectionManager, previousCommands));
    }
}