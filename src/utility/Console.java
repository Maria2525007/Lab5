package utility;

import utility.interfaces.ConsoleInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Console helps us to read and print information
 */
public class Console implements ConsoleInterface {
    private final Scanner scanner;
    private boolean exeStatus;
    private BufferedReader scriptReader;

    public Console(Scanner aScanner) {

        exeStatus = false;
        scanner = aScanner;
        scriptReader = null;
    }

    @Override
    public String readline() {
        try {
            return scriptReader.readLine();
        } catch (IOException e) {
            return TextFormatting.getRedText("\n\tInput or Output error!\n");
        }
    }

    @Override
    public void setScriptMode(BufferedReader aScriptReader) {
        exeStatus = true;
        scriptReader = aScriptReader;
    }

    @Override
    public void setInteractiveStatus() {
        exeStatus = false;
        try {
            scriptReader.close();
        } catch (IOException e) {
            print(TextFormatting.getRedText("\n\tInput or Output error!\n"));
        }
    }

    @Override
    public boolean getExeStatus() {
        return exeStatus;
    }

    @Override
    public void print(Object anObj) {

        System.out.print(anObj);
    }

    @Override
    public String read() {
        String line;

        try {
            line = scanner.nextLine();
        } catch (NoSuchElementException e) {
            if (!exeStatus) System.exit(0);
            return null;
        }

        if (line.trim().isEmpty()) {
            return null;
        }

        return line.trim();
    }

    @Override
    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }
}