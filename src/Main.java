import utility.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Console console = new Console(scanner);
        CollectionManager collectionManager = new CollectionManager();
        Invoker invoker = new Invoker(console, collectionManager);
        CommandReader commandReader = new CommandReader(invoker);
        FileWorker fileWorker = new FileWorker(collectionManager, console);
        console.print(fileWorker.getFromXmlFormat());
        commandReader.enable();
        scanner.close();
    }
}