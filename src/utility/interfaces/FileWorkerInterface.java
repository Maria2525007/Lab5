package utility.interfaces;

public interface FileWorkerInterface {

    /**
     * Print all objects from collection to xml file(file path should be in environment variable "FILE_PATH")
     *
     * @see commands.Save#execute
     */
    String saveToXml();

    /**
     * Read objects from xml file and add objects to collection(file path should be in environment variable "FILE_PATH")
     */
    String getFromXmlFormat();
}